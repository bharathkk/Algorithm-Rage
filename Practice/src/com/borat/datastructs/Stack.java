package com.borat.datastructs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/****

Implements stack with linked list and also facilitates a min operation to find the minimum element in the stack

**/
class Stack<T extends Comparable<T>> {

	Node top;
	int size;
	private final int maxSize = 100;

	private class Node {
   
	     Node next;
	     T data;
	
	     public Node ( T data ) {
	    	 this.data = data;
	    	 next = null;
	     }
	
	     public void setNext ( Node nextNode ) {
	    	 this.next = nextNode;
	     }
	
	     public Node getNext () {
	    	 return this.next;
	     }
	     
	     public T getData () {
	    	 return this.data;
	     }
	}

 
	public Stack () {
	    this.size = 0;
	    this.top = null;
	}

	boolean isStackEmpty () {
	    return size <= 0 || top == null? true : false;
	}

	public void push ( T data ) {
	    Node newNode = new Node(data);
	    top =  pushIntoStack (newNode);
	}

	private Node pushIntoStack ( Node newNode ) {
	    
	    if ( isStackEmpty()) {
	        Node minNode = new Node (newNode.getData());
	        minNode.setNext(newNode);
	        top = minNode;
	        size = size + 2;
	        return top;
	    }
	
	    if ( size >= maxSize ) {
	       System.out.println("Maximum limit reached… pop elements from the stack to push more");
	       return top;
	    }
	    
	    Node minNode = null;
	    T currentMin = topOfStack();
	    T minCandidate = newNode.getData();
	    
	    if ( !isNewMin (minCandidate,currentMin) ) {
	         minCandidate = currentMin;
	    }
	    
	    minNode = new Node(minCandidate);
	    newNode.setNext(top);
	    minNode.setNext(newNode);
	    top = minNode;
	    size += 2;
	
	    return top;
	}

	public void pop () {
		popFromStack();
	}

	@SuppressWarnings("unused")
	private Node popFromStack () {
	
		  if ( isStackEmpty() ) {
		     System.out.println("Pop Operation failed on the empty stack…");
		     return null;
		  }
	
	      Node minTopNode = null, actualTopNode = null;
	      minTopNode = top;
	      top = top.getNext();
	      size = size - 1;
	      actualTopNode = top;
	
	      // Checks for corrupted stack as for every push operation two nodes are inserted 
	      if ( actualTopNode == null ) {
	          System.out.println("Corrupted stack…. "); // a pop operation involves 								  //removing nodes one the current min and another the original node
	          size = 0;
	          return null;
	      }
	      
	      minTopNode = null;			// clean up the memory
	      actualTopNode = null;		// clean up 
	
	      if ( top.getNext() == null ) {                           // effectively the else part handles the null constraint as well… just to add clarity to the code
	          size = 0;
	          top = null;
	          return null;
	      }
	     else {
	    	 top = top.getNext();
	      	 size = size - 1;
	      	 return top;
	      }
      
	}

	public T top () {
	   return topOfStack();
	}

	private T topOfStack() {
	
	    if ( isStackEmpty() ) {
	
	       System.out.println("Top Operation failed on the empty stack…");
	       return null;
	    }
	    
	    Node actualTop = null;
	    actualTop = top.getNext();
	
	    if ( actualTop == null ) {
		System.out.println("Corrupted stack…. ");
	          size = 0;
	          return null;
	    } 
	
	    return actualTop.getData();
	}

	private boolean isNewMin ( T data1, T data2 ) {
	      return data1.compareTo(data2) > 0 ? false : true;
	}
	
	public T min () {
	   return getMinimum();
	}
	
	private T getMinimum() {
		
	   if ( isStackEmpty() ) {
	
	       System.out.println("Minimum Operation failed on the empty stack…");
	       return null;
	    }
	
	   T minData = top.getData();
	
	   return minData;
	}
	
	public Iterator<T> iterator() { return new ListIterator(); }
	
	private class ListIterator implements Iterator<T> {
		
		private Node current = top;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			T data = current.data;
			current = current.next;
			return data;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	public static void main ( String args[] ) {
		
		Stack<Integer> newStack = new Stack<Integer>();
		
		newStack.push(4);
		newStack.push(5);
		newStack.push(3);
		
//		System.out.println(newStack.min());
//		
//		newStack.pop();
//		System.out.println(newStack.top());
//		System.out.println(newStack.min());
//		newStack.pop();
//		System.out.println(newStack.min());
//		System.out.println(newStack.top());
//		newStack.pop();
//		newStack.top();
//		newStack.min();
		Iterator<Integer> itr = newStack.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
