package wordTree.myTree;

/**
 * Node class that is a structure to save in the tree that implements Observer, Subject, Cloneable and Comparable Interface.
 * Class has two pointers to left and right nodes.
 * The node saves buId and a HashSet of courses.
 * I have used hashset for courses because it is fast and efficient to find
 * a course of a buId and also duplicate courses are handled by hashset.
 * @author tushitjain
 *
 */
public class Node implements Comparable<Node> {
	private Node left;
	private Node right;
	private int count;
	private int wordLength;
	private String word;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getWordLength() {
		return wordLength;
	}

	
	
	
	public Node(String wordIn) {
		count=1;
		setLeft(null);
		setRight(null);
		if(wordIn != null){
			setWord(wordIn);
			wordLength = wordIn.length();
		}

	}

	/**
	 * A function that adds the course to the node for a particular buId.
	 * @param course: the courseName
	 */
	public void addWord(String wordIn) {
			count++;
		
	}

	/**
	 * Removes the course for a particular node
	 * @param course: courseName to be removed if it exists.
	 */
	public void removeWord(String wordIn) {
		if(null != wordIn)
			count--;

	}

	/**
	 * Method returns the Id of the node
	 */
	@Override
	public int hashCode() {
		return 31*wordLength;
	}
	
	/**
	 * Method overridden from Comparable interface to compare two nodes.
	 */
//	@Override
//	public int compareTo(Node o) {
//		if (getId() < o.getId()) {
//			return -1;
//		} else if (getId() > o.getId()) {
//			return 1;
//		}
//		return 0;
//	}

	@Override
	public int compareTo(Node node){
		return word.compareTo(node.word);
	}
	/**
	 * Gets the left node of the current node.
	 * @return : left Node
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * sets the left of the node to a new node
	 * @param left: new Node
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * gets the right node of the current node
	 * @return
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * sets the right of the current node to new node and return it.
	 * @param right : new Node
	 * @return: right node
	 */
	public Node setRight(Node right) {
		this.right = right;
		return right;
	}
	@Override
	public String toString(){
		return "Word is: "+getWord() + " Count is: " + count + " Length is: " +wordLength;
	}

}
