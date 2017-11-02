package wordTree.driver;

import wordTree.myTree.Tree;
import wordTree.util.FileProcessor;

public class Driver {
	public static void main(String[] args) {
		
		FileProcessor fp = new FileProcessor("input.txt");
		Tree t = new Tree();
		String str;
		while((str = fp.readLine())!=null){
			String[] words = str.split("\\s+");
			for(String wordIn : words){
				System.out.println(wordIn);
				t.insertWord(wordIn);
			}
				//t.insertWord(wordIn);
		}
		
		t.print();
		
	}

}
