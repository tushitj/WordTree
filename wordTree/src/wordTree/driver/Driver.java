package wordTree.driver;

import wordTree.myTree.Tree;
import wordTree.store.Results;
import wordTree.threadMgmt.CreateWorkers;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;
import wordTree.util.OutputCalculation;

public class Driver {
	static boolean insert = true;
	public static boolean checkArgs(String... arguments) {
		boolean flag = true;
		for (String arg : arguments) {
			flag = flag && arg != null && arg.trim().length() > 0 && !arg.contains("${arg");
			//System.out.println(" AAA" + arg);
		}

		return flag;
	}

	public static boolean checkArgVal(int toCheck, int toEqual) {
		return toCheck == toEqual;
	}

	public static void main(String[] args) {
		int deleteCount = 0;
		int debuglevel = 0;
		int NUM_THREADS = 0;
		int argLength = args.length;
		if (argLength != 5 || !checkArgs(args)) {
			System.err.println("Error. Incorrect Arguments");
			System.exit(1);
		}
		String inputFile = args[0];
		String outputFile = args[1];
		// String[] deleteWords = args[2].split("\\s+");
		String[] deleteWords = args[2].split(",");
		deleteCount = deleteWords.length;
		if (1 < deleteCount && deleteCount > 3) {
			System.err.println("Number of delete words cannot be more than 3");
			System.exit(1);
		}
		// String deleteWord1 = args[2];
		// String deleteWord2 = args[3];
		// String deleteWord3 = args[4];
		try {
			debuglevel = Integer.parseInt(args[3]);
			NUM_THREADS = Integer.parseInt(args[4]);
		} catch (NumberFormatException e) {
			System.err.println("Number expected at debug level and number of threads.");
			System.exit(1);
		}
		if (1 < NUM_THREADS && NUM_THREADS > 3) {
			System.err.println("Number of threads should be between 1 and 3");
			System.exit(3);
		}
//		if (deleteCount != NUM_THREADS) {
//			System.err.println("Number of threads not equal to number of words to delete");
//			System.exit(1);
//		}
		MyLogger.setDebugValue(debuglevel);
		Tree tree = new Tree();
		FileProcessor input = new FileProcessor(inputFile);
		input.setArr(deleteWords);
		// FileProcessor output = new FileProcessor(outputFile);
		Results results = new Results();
		
//		doMethod(input,tree,deleteWords);
//		insert = false;
//		doMethod(input,tree,deleteWords);
//		tree.print();
		CreateWorkers cw = new CreateWorkers(input, tree, results);
		try {
			cw.startPopulateWorkers(NUM_THREADS);
			cw.setInsert(false);
			cw.startDeleteWorkers(deleteWords);
		} catch (InterruptedException e) {
			System.err.println("Some error with threads.");
			e.printStackTrace();
			System.exit(1);
		}
		MyLogger.setDebugValue(debuglevel);
		OutputCalculation oc = new OutputCalculation(tree);
		System.out.println("Number of Unique words : "+ oc.getUniqueWords());
		System.out.println("Number of words : "+ oc.getWordCount());
		System.out.println("Number of Characters : "+ oc.totalChars());

	}
//	public static void doMethod(FileProcessor fp, Tree tree, String[] wordsDel) {
//		
//		if(insert == true){
//			String str;
//			while((str = fp.readLine())!=null){
//				String[] words = str.split("\\s+");
//				for(String wordIn : words){
//					//System.out.println(wordIn);
//					tree.insertWord(wordIn);
//					
//				}
//			}
//			
//			//read from file
//			//enter values in the tree.
//		}
//		else if (insert == false){
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//			for(String word : wordsDel) {
//				tree.removeWordCountFromNode(word);
//			}
//		
//		
//	}
//
//}
}