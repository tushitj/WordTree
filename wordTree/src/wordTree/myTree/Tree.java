package wordTree.myTree;

import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;

public class Tree {
	private volatile Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Tree() {
		MyLogger.writeMessage(this.getClass() + "Logger: Constructor called",  MyLogger.DebugLevel.CONSTRUCTOR);
		root = null;
	}

	synchronized public void insertWord(String wordIn) {
		Node node;
		if (wordIn != null) {
			if ((node = searchNode(wordIn)) != null) {
				node.addWord(wordIn);
			} else {
				node = new Node(wordIn);
				insertNodeIntoTree(node);
			}
		}
	}

 private void insertNodeIntoTree(Node node) {
		root = insert(root, node);

	}

/**
 * This method would insert the words in a distinct node
 * of the BST tree by following the BST properties
 * @param curr
 * @param node
 * @return curr
 */
 private Node insert(Node curr, Node node) {
		if (curr == null) {
			curr = node;
			return curr;
		}
		// if(curr > node ) go left
		else if (curr.compareTo(node) > 0) {
			curr.setLeft(insert(curr.getLeft(), node));
		}
		// if(curr < node ) go right
		else if (curr.compareTo(node) < 0) {
			curr.setRight(insert(curr.getRight(), node));
		}
		return curr;
	}

	synchronized private Node searchNode(String m) {
		Node node = searchRec(root, m);
		return node;
	}

/**
 * This method search the word in the BST nodes
 * by following the BST properties
 * @param node
 * @param m
 * @return found
 */
	synchronized private Node searchRec(Node node, String m) {
		Node found = null;
		if (node == null || node.getWord().compareTo(m) == 0) {
			return node;
		} else if (node.getWord().compareTo(m) > 0) {
			found = searchRec(node.getLeft(), m);
		} else if (node.getWord().compareTo(m) < 0) {
			found = searchRec(node.getRight(), m);
		}
		return found;
	}

	// pass results object here. and also in printInOrder.
//	public void print() {
//		printInOrder(root);
//	}

	// pass Results Object here to store the output in it.
//	private void printInOrder(Node node) {
//		if (node != null) {
//			printInOrder(node.getLeft());
//			System.out.println(node.toString());
//			printInOrder(node.getRight());
//		}
//	}

/**
 * This method will remove the word from the node
 * of the BST after searching the node from the BST
 * @param word
 * @return String "Removed"
 */
	synchronized public String removeWordCountFromNode(String word) {
		Node node = searchNode(word);
		if (node == null) {
			return null;
		} else {
			node.removeWord(word);
		}
		return "Removed";
	}
	  

	public int nodes() {
	    return (root == null) ? 0 : root.countNode();
	}
	
}
