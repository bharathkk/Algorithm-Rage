package com.borat.datastructs;

public class BinaryHeap {

	int[] heap;
	int size;
	
	public BinaryHeap( int N) {
		heap = new int[N];
	}
	
	public BinaryHeap( int[] items) {
		heap = new int[100];
		
		buildHeap(items);	
	}
	
	public int remove() {
		return removeItem();
	}
	
	public void insert ( int item ) {
		insertItem(item);
	}
	
	private void insertItem ( int item) {
		
		int lastInd = size ,itemInd,parentInd;
		int tempItem, parentItem;
		heap[lastInd] =  item;
		itemInd = lastInd;
		parentInd = itemInd / 2;
		size++;
		
		while (itemInd > 0 && parentInd > 0) {
			
			tempItem = heap[itemInd];
			parentItem = heap[parentInd/2];
			
			if ( tempItem > parentItem ) {
				int temp = heap[itemInd];
				heap[itemInd] = heap[parentInd];
				heap[parentInd] = temp;
				itemInd = parentInd;
				parentInd = parentInd / 2;
			}
			else
				break;
		}
	}
	
	public void build ( int[] items) {
		buildHeap(items);
	}
	
	private void buildHeap ( int[] items) {
		
		heap[0] = -1234;
		for (int index = 0; index < items.length; index++ ) 
			heap[index+1] = items[index];
		
		size = items.length + 1;
		System.out.println(size);
		for ( int ind = (size-1)/2; ind >0; ind-- )
			maxHeapify(ind);
	}
	
	private void maxHeapify ( int index ) {
		
		int lChild = 2*index,rChild = 2*index + 1,largest = index;
				
		if ( lChild < size && heap[lChild] > heap[largest] )
			largest = lChild;
		
		if ( rChild < size  && heap[rChild] > heap[largest] )
			largest = rChild;
		
		if ( largest != index ) {
			int temp = heap[index];
			heap[index] = heap[largest];
			heap[largest] = temp;
			maxHeapify(largest);
		}
			
	}
	
	private int removeItem () {
		
		int removedItem = heap[1];
		
		if ( size < 2 )
			return -1;
		if ( size == 2 ) {
			size--;
		}
		else {
			
			int lastItem = heap[size-1];
			heap[1] = lastItem;
			maxHeapify(1);
			size--;
		}
		
		return removedItem;		
	}
	
	public void display() { 
		displayHeap();
	}
	
	private void displayHeap() {
		
		int parent,lChild,rChild;
		
		for ( int ind = 1; ind <= (size-1)/2; ind++ ) {
			parent = heap[ind];
			System.out.println("Parent: "+parent);
			if ( 2*ind < size ) {
				lChild = heap[2*ind];
				System.out.println("lChild: "+lChild);
			}
			
			if ( 2*ind + 1 < size ) {
				rChild = heap[2*ind + 1];
				System.out.println("rChild: "+rChild);
			}
		}
	}
	
	public static void main ( String args[] ) {
		
		int[] items = {5,3,7,2,8,1};
		BinaryHeap binHeap = new BinaryHeap(items);
		
		binHeap.insert(11);
		binHeap.display();
		
		System.out.println(items.length);
		items = binHeap.expand(items,10);
		System.out.println(items.length);
		binHeap = null;
		binHeap = new BinaryHeap(items);
		binHeap.display();
	}
	
	private int[] expand ( int[] array, int size ) {
		int[] temp = new int[size];
		
		System.arraycopy(array, 0, temp, 0, array.length);
		
		for ( int i = array.length; i < size; i++ ) 
			temp[i] = 12+i;
		
		return temp;
	}

}
