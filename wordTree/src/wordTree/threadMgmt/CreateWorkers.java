package wordTree.threadMgmt;

import wordTree.myTree.Tree;
import wordTree.store.Results;
import wordTree.util.FileProcessor;

public class CreateWorkers implements Runnable {
	FileProcessor fp;
	Tree t;
	Results result;
	int num_threads;
	String[] wordsDel;
	public CreateWorkers(FileProcessor fpIn, Tree tIn, Results resultIn){
		this.fp = fpIn;
		this.t = tIn;
		this.result = resultIn;
		
	}
	private boolean insert = true;
	public void setInsert(boolean insert) {
		this.insert = insert;
	}

	public void startPopulateWorkers(int num) throws InterruptedException{
		PopulateThread insertT = new PopulateThread(num,this);
		for(Thread t: insertT.getPopulateThreads()){
			System.out.println("AAA" +t);
			t.start();
		}
		for(Thread t: insertT.getPopulateThreads()){
			t.join();
		}
		
		t.print();
		//tree.print here
		//store result in results object here.
	}

	public void startDeleteWorkers(String[] wordsIn) throws InterruptedException{
		System.out.println("######################################################");
		System.out.println(insert);
		this.wordsDel = wordsIn;
		int num = wordsIn.length;
		DeleteThread deleteT = new DeleteThread(num,this);
		for(Thread t: deleteT.getDeleteThreads()){
			t.start();
		}
		for(Thread t: deleteT.getDeleteThreads()){
			t.join();
		}
		System.out.println("*****************************");
		t.print();
		
		//store new result in results object here
	}

	@Override
	public void run() {
		if(insert == true){
			String str;
			while((str = fp.readLine())!=null){
				String[] words = str.split("\\s+");
				for(String wordIn : words){
					//System.out.println(wordIn);
					t.insertWord(wordIn);
					
				}
			}
			//read from file
			//enter values in the tree.
		}
		else if (insert == false){
			for(String word : wordsDel) {
				t.removeWordCountFromNode(word);
			}
		t.print();
		
	}
}
}