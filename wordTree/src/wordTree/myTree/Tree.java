package wordTree.myTree;

public class Tree {
	private Node root;
	
	public Tree(){
		root = null;
	}
	synchronized public void insertWord(String wordIn){
		Node node;
		if(wordIn !=null){
			if((node = searchNode(wordIn)) != null){
				node.addWord(wordIn);
			}
			else{
				node = new Node(wordIn);
				insertNodeIntoTree(node);				
			}
		}	
	}
	
	
	synchronized private void insertNodeIntoTree(Node node) {
		root = insert(root,node);
	
}
	synchronized private Node insert(Node curr, Node node) {
		if(curr==null){
			curr = node;
			return curr;
		}
		//if(curr > node ) go left
		else if(curr.compareTo(node) > 0){
			curr.setLeft(insert(curr.getLeft(),node));
		}
		//if(curr < node ) go right
		else if(curr.compareTo(node) < 0){
			curr.setRight(insert(curr.getRight(),node));
		}
		return curr;
	}

	synchronized private Node searchNode(String m) {
		Node node = searchRec(root,m);
		return node;
	}
	
	synchronized private Node searchRec(Node node, String m) {
		Node found = null;
		if(node == null || node.getWord().compareTo(m) == 0){
			return node;
		}
		else if(node.getWord().compareTo(m) > 0){
			found = searchRec(node.getLeft(), m);
		}
		else if(node.getWord().compareTo(m) < 0){
			found = searchRec(node.getRight(), m);
		}
		return found;
	}
	//pass results object here. and also in printInOrder.
	public void print(){
		printInOrder(root);
	}

	//pass Results Object here to store the output in it.
	private void printInOrder(Node node){
		if(node!=null){
			printInOrder(node.getLeft());
			System.out.println(node.toString());
			printInOrder(node.getRight());
		}
	}
	synchronized public String removeWordCountFromNode(String word){
		Node node = searchNode(word);
		if(node == null){
			return null;
		}
		else{
			node.removeWord(word);
		}
		return "Removed";
	}
}
