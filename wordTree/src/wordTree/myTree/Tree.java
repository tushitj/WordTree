package wordTree.myTree;

public class Tree {
	private Node root;
	
	public Tree(){
		root = null;
	}
//	public String insertCourse(int id, String course){
//		Node node;
//		if(course != null && id>999 && id<10000){
//			if((node = searchNode(id)) !=null){
//				node.addCourse(course);
//				node.notifyAllObservers(Operation.INSERT, course);
//			}else{
//				node = new Node(id,course);
//				insertNodeIntoTree(node);
//				try{
//					ObserverI nodeBackup1 = node.clone();
//					backupTree1.insertNodeIntoTree((Node)nodeBackup1);
//					node.subscribeObserver(nodeBackup1);
//				}catch(Exception e){
//					System.err.println("Error occured while cloning backupNode1");
//				}
//				try{
//					ObserverI nodeBackup2 = node.clone();
//					backupTree2.insertNodeIntoTree((Node)nodeBackup2);
//					node.subscribeObserver(nodeBackup2);
//				}catch(Exception e){
//					System.err.println("Error occured while cloning backupNode2");
//				}
//				
//			}
//		}
//		return "Course added successfuly";
//		
//	}

	
	
	
	public void insertWord(String wordIn){
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
	
	
	private void insertNodeIntoTree(Node node) {
		root = insert(root,node);
	
}
	private Node insert(Node curr, Node node) {
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

	private Node searchNode(String m) {
		Node node = searchRec(root,m);
		return node;
	}
	
	private Node searchRec(Node node, String m) {
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
}
