package com.borat.datastructs;

enum NodeColour{RED,BLACK};

public class RedBlackTree {

	Node root;
	
	static private class Node { 
		
		int data;
		Node right,left,parent;
		NodeColour nodeColour;
		
		Node ( int data ) {
			
			this.data = data;
			right  = left = parent = null;
			nodeColour = NodeColour.RED;
		}
	}
	
	RedBlackTree () {
		root = null;
	}
	
	public void insert ( int data ) {
		
		root = insert(root,data);
	}
	
	public Node delete ( int data ) {
		
		return delete(root,data);
	}
	
	private Node insert ( Node node, int data ) {
		
		Node newNode = null;
		Node headNode,tempNode;
		
		newNode = new Node(data);
		
		if ( node == null ) {
			newNode.nodeColour = NodeColour.BLACK;
			return newNode;
		}
		
		headNode = node;
		tempNode = null;
		
		while ( headNode != null ) {
			
			tempNode = headNode;
			if ( data <= headNode.data )
				headNode = headNode.left;
			else
				headNode = headNode.right;
			
		}
		
		newNode.parent = tempNode;
		
		if ( data <= tempNode.data )
			tempNode.left = newNode;
		else
			tempNode.right = newNode;
		
		
		// To fix the red black constraints in the tree
		node = insertFixUp(node, newNode);
		return node;
	}
	
	private Node delete ( Node node, int data ) {
		
		if ( node == null )
			return null;
		
		
		return null;
	}
	
	private Node insertFixUp (Node node, Node newNode ) {
		
		while ( newNode.parent.nodeColour == NodeColour.RED ) {
			
			if ( newNode.parent == newNode.parent.parent.left ) {
				Node tempNode = newNode.parent.parent.right;
				
				if ( tempNode.nodeColour == NodeColour.RED ) {
					
					newNode.parent.nodeColour = NodeColour.BLACK;
					tempNode.nodeColour = NodeColour.BLACK;
					newNode.parent.parent.nodeColour = NodeColour.RED;
					newNode = newNode.parent.parent;
				}
				else {
					
					if ( newNode == newNode.parent.right ) {
						newNode = newNode.parent;
						node = rotateLeft(node,newNode);
					}
					
					newNode.parent.nodeColour = NodeColour.BLACK;
					newNode.parent.parent.nodeColour = NodeColour.RED;
					node = rotateRight(node,newNode.parent.parent);
				}					
			}
			else {
				
				Node tempNode = newNode.parent.parent.left;
				
				if ( tempNode.nodeColour == NodeColour.RED ) {
					
					newNode.parent.nodeColour = NodeColour.BLACK;
					tempNode.nodeColour = NodeColour.BLACK;
					newNode.parent.parent.nodeColour = NodeColour.RED;
					newNode = newNode.parent.parent;
				}
				else {
					
					if ( newNode == newNode.parent.left ) {
						newNode = newNode.parent;
						node = rotateRight(node,newNode);
					}
					
					newNode.parent.nodeColour = NodeColour.BLACK;
					newNode.parent.parent.nodeColour = NodeColour.RED;
					node = rotateLeft(node,newNode.parent.parent);
				}	
			}
			if ( newNode.parent == null )
				break;
		}
		
		node.nodeColour = NodeColour.BLACK;
		
		return node;
	}
	
	private Node rotateLeft ( Node node, Node nodeTobeRotated ) {
		
		Node tempNode = null;
		
		tempNode = nodeTobeRotated.right;
		nodeTobeRotated.right = tempNode.left;
		
		tempNode.left.parent = nodeTobeRotated;
		tempNode.parent = nodeTobeRotated.parent;
		
		if ( nodeTobeRotated.parent == null )
			node = tempNode;
		else {
			
			if ( nodeTobeRotated == nodeTobeRotated.parent.left )
				nodeTobeRotated.parent.left = tempNode;
			else
				nodeTobeRotated.parent.right = tempNode;
		}
		
		tempNode.left = nodeTobeRotated;
		nodeTobeRotated.parent = tempNode;
		
		return node;
	}
	
	private Node rotateRight ( Node node, Node nodeTobeRotated ) {
	
		Node tempNode = null;
		
		tempNode = nodeTobeRotated.left;
		nodeTobeRotated.left = tempNode.right;
		
		tempNode.right.parent = nodeTobeRotated;
		tempNode.parent = nodeTobeRotated.parent;
		
		if ( nodeTobeRotated.parent == null )
			node = tempNode;
		else {
			
			if ( nodeTobeRotated == nodeTobeRotated.parent.left )
				nodeTobeRotated.parent.left = tempNode;
			else
				nodeTobeRotated.parent.right = tempNode;
		}
		
		tempNode.right = nodeTobeRotated;
		nodeTobeRotated.parent = tempNode;
		
		return node;
	}
	
	public void printNodes () {
		printNodes (root);
	}
	
	private void printNodes (Node node) {
		
		if ( node == null )
			return;
		else {
			printNodes(node.left);
			int parentData = 0;
			if ( node.parent != null)
				parentData = node.parent.data;
			System.out.println(node.data+" "+node.nodeColour+" "+parentData);
			printNodes(node.right);
		}
	}
	
	public static void main ( String args[] ) {
		
		RedBlackTree rbTree = new RedBlackTree();
		
		rbTree.insert(11);
		rbTree.insert(2);
		rbTree.insert(14);
		rbTree.insert(15);
		rbTree.insert(1);
		rbTree.insert(7);
		rbTree.insert(8);
		rbTree.insert(5);
		rbTree.insert(4);
		
		rbTree.printNodes();
	}
}
