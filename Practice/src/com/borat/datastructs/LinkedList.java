package com.borat.datastructs;

import java.util.*;

public class LinkedList<Item> {

	Node start;
	
	private class Node {
		
		Item data;
		Node next;
		
		Node ( Item data ) {
			this.data = data;
			next = null;
		}
	}
	
	LinkedList() {
		start = null;
	}
	
	public void insert ( Item data ) {
		start = insert(start,data);
	}
	
	public boolean lookup ( Item data ) { 
		return lookup(start,data);
	}
	
	private Node insert ( Node node, Item data ) {
		
		if ( node == null )
			return new Node(data);
		
		node.next = insert(node.next,data);
		
		return node;
	}
	
	private boolean lookup ( Node node, Item data ) {
		
		if ( node == null )
			return false;
		
		if ( node.data == data )
			return true;
		
		return lookup(node.next,data);
	}
	
	public void reverse () {
		
		start = reverseList(start);
	}
	
	private Node reverseList ( Node root ) {
		
		if ( root == null ) 
			return null;
		
		Node first,rest;
		
		first = root;
		rest = root.next;
		
		if ( rest == null )
			return first;
		
		rest = reverseList(rest);
		first.next.next = first;
		first.next = null;
		
		return rest;
	}
	
	public void display() {
		
		Node current = start;
		
		while ( current != null ) {
			System.out.println(current.data);
			current = current.next;
		}
		
		current = null;
	}
	
	public Iterator<Item> iterator() { return new ListIterator(); }
	
	private class ListIterator implements Iterator<Item> {
		private Node current = start;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			Item data = current.data;
			current = current.next;
			return data;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main ( String args[] ) {
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		linkedList.insert(2);
		linkedList.insert(0);
		linkedList.insert(1);
		linkedList.insert(4);
		
		linkedList.display();
		linkedList.reverse();
		System.out.println("Printing reverse......");
		linkedList.display();
		
	}
}
