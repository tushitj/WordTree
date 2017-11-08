package wordTree.util;

import wordTree.myTree.Node;
import wordTree.myTree.Tree;

public class OutputCalculation {
	Tree tree;
	static int totalWords=0;
	static int totalChars=0;
	static int uniqueWords=0;
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
	   // if(nodeCount > 0)
	    	totalWords +=nodeCount;
	    if (root.getRight() != null){
	    	traverseWordsCount(root.getRight());
	    }
	}






	public int getUniqueWords() {
		traverseUniqueWords(tree.getRoot());
		return uniqueWords;
	}

		public void traverseUniqueWords (Node root){ // Each child of a tree is a root of its subtree.
	    if (root.getLeft() != null){
	    	traverseUniqueWords(root.getLeft());
	    }
	    //System.out.println(root.data);
	    if(root.getCount()>0){
	    	uniqueWords++;
	    }
	    if (root.getRight() != null){
	    	traverseUniqueWords(root.getRight());
	    }
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
	   // if(nodeCount > 0 && wordLength > 0)
	    	totalChars += (nodeCount*wordLength);
	    if (root.getRight() != null){
	    	traverseCharCount(root.getRight());
	    }
	}
	

}
