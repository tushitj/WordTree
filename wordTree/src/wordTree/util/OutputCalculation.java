package wordTree.util;

import wordTree.myTree.Node;
import wordTree.myTree.Tree;

public class OutputCalculation {
	Tree tree;
	static int totalWords=0;
	static int totalChars=0;
	public OutputCalculation(Tree tree) {
		this.tree = tree;
	}
	
	public int getWordCount() {
		traverseWordsCount(tree.getRoot());
		return totalWords;
	}

	public void traverseWordsCount (Node root){ // Each child of a tree is a root of its subtree.
	    if (root.getLeft() != null){
	    	traverseWordsCount(root.getLeft());
	    }
	    //System.out.println(root.data);
	    int nodeCount = root.getCount();
	    totalWords +=nodeCount;
	    if (root.getRight() != null){
	    	traverseWordsCount(root.getRight());
	    }
	}
	public int getUniqueWords() {
		return tree.nodes();		
	}
	public int totalChars() {
		traverseCharCount(tree.getRoot());	
		return totalChars;
		
	}
	public void traverseCharCount (Node root){ // Each child of a tree is a root of its subtree.
	    if (root.getLeft() != null){
	    	traverseCharCount(root.getLeft());
	    }
	    //System.out.println(root.data);
	    int nodeCount = root.getCount();
	    int wordLength = root.getWordLength();
	    totalChars += (nodeCount*wordLength);
	    if (root.getRight() != null){
	    	traverseCharCount(root.getRight());
	    }
	}
	

}
