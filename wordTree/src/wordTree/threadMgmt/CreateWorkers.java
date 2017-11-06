package wordTree.threadMgmt;

import wordTree.myTree.Tree;
import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;

public class CreateWorkers implements Runnable {
	FileProcessor fp;
	Tree tree;
	Results result;
	int num_threads;
	String[] wordsDel;
	public CreateWorkers(FileProcessor fpIn, Tree tIn, Results resultIn){
		MyLogger.writeMessage("Constructor called", DebugLevel.CONSTRUCTOR);
		this.fp = fpIn;
		this.tree = tIn;
		this.result = resultIn;
		
	}
	private boolean insert = true;
	public void setInsert(boolean insert) {
		this.insert = insert;
	}

	public void startPopulateWorkers(int num) throws InterruptedException{
		PopulateThread insertT = new PopulateThread(num,this);
		for(Thread t: insertT.getPopulateThreads()){
			//System.out.println("AAA" +t);
			t.start();
		}
		for(Thread t: insertT.getPopulateThreads()){
			t.join();
		}
		
		//t.print();
		//tree.print here
		//store result in results object here.
	}

	public void startDeleteWorkers(String[] wordsIn) throws InterruptedException{
		//System.out.println("######################################################");
		//System.out.println(insert);
		this.wordsDel = wordsIn;
		int num = wordsIn.length;
		DeleteThread deleteT = new DeleteThread(num,this);
		for(Thread t: deleteT.getDeleteThreads()){
			t.start();
		}
		for(Thread t: deleteT.getDeleteThreads()){
			t.join();
		}
		//System.out.println("*****************************");
		//tree.print();
		
		//store new result in results object here
	}

	@Override
	public void run() {
		MyLogger.writeMessage("Thread's run called", DebugLevel.IN_RUN);
		String str="";
		if(insert == true){
			//String str;
			while((str = fp.readLine())!=null){
				String[] words = str.split("\\s+");
				for(String wordIn : words){
					//System.out.println(wordIn);
					tree.insertWord(wordIn);
					str = null;
					
				}
			}
			//read from file
			//enter values in the tree.
		}
		else if (insert == false){
			//String str;
			str = "";
//				for(String word : wordsDel) {
//					tree.removeWordCountFromNode(word);
//				}
			while((str = fp.getStringToDelete())!=null)
				tree.removeWordCountFromNode(str);
			//tree.removeWordCountFromNode(wordsDel[])
			
				
	}
}
}