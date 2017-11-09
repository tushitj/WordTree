package wordTree.driver;

import wordTree.myTree.Tree;
import wordTree.store.Results;
import wordTree.threadMgmt.CreateWorkers;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;
import wordTree.util.OutputCalculation;
import wordTree.util.MyLogger.DebugLevel;

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

/**
 * Main function for starting the code
 * and command line argument will be input file,
 * output file, number of threads, delete words,
 * debug level
 * 
 */
	public static void main(String[] args) {
		int deleteCount = 0;
		int debuglevel = 0;
		int NUM_THREADS = 0;
		int argLength = args.length;
		if (argLength != 5 || !checkArgs(args)) {
			MyLogger.writeMessage("Logger: Error in Main", DebugLevel.IN_RESULTS);
			System.err.println("Error. Incorrect Arguments");
			System.exit(1);
		}
		String inputFile = args[0];
		String outputFile = args[1];
		String[] deleteWords = args[3].split("\\s+");
		//String[] deleteWords = args[2].split(",");
		deleteCount = deleteWords.length;
		if (deleteCount < 1 || deleteCount > 3) {
			MyLogger.writeMessage("Logger: Error in Main", DebugLevel.IN_RESULTS);
			System.err.println("Number of delete words cannot be more than 3");
			System.exit(1);
		}
		// String deleteWord1 = args[2];
		// String deleteWord2 = args[3];
		// String deleteWord3 = args[4];
		try {
			debuglevel = Integer.parseInt(args[4]);
			NUM_THREADS = Integer.parseInt(args[2]);
		} catch (NumberFormatException e) {
			MyLogger.writeMessage("Logger: Exception in Main", DebugLevel.IN_RESULTS);
			System.err.println("Number expected at debug level and number of threads.");
			System.exit(1);
		}
		if ((NUM_THREADS < 1) || (NUM_THREADS > 3)) {
			MyLogger.writeMessage("Logger: Error in Main", DebugLevel.IN_RESULTS);
			System.err.println("Number of threads should be between 1 and 3");
			System.exit(1);
		}
		if (deleteCount != NUM_THREADS) {
			MyLogger.writeMessage("Logger: Error in Main", DebugLevel.IN_RESULTS);
			System.err.println("Number of threads not equal to number of words to delete");
			System.exit(1);
		}
		MyLogger.setDebugValue(debuglevel);
		Tree tree = new Tree();
		FileProcessor input = new FileProcessor(inputFile);
		input.setArr(deleteWords);
		Results results = new Results();
		CreateWorkers cw = new CreateWorkers(input, tree, results);
		try {
			cw.startPopulateWorkers(NUM_THREADS);
			cw.setInsert(false);
			cw.startDeleteWorkers(deleteWords);
		} catch (InterruptedException e) {
			MyLogger.writeMessage("Logger: Exception in Main", DebugLevel.IN_RESULTS);
			System.err.println("Some error with threads.");
			e.printStackTrace();
			System.exit(1);
		}
		MyLogger my = new MyLogger();
		MyLogger.setDebugValue(debuglevel);
		String level = my.toString();
		OutputCalculation oc = new OutputCalculation(tree);
		System.out.println(level);	
		String uniqueWord = String.format("Number of Unique words : %d", oc.getUniqueWords());
		String wordCount = String.format("Number of words : %d", oc.getWordCount());
		String totalChar = String.format("Number of Characters : %d", oc.totalChars());
		results.storeNewResult(uniqueWord);
		results.storeNewResult(wordCount);
		results.storeNewResult(totalChar);
		results.writeSchedulesToFile(outputFile);
		if(debuglevel == 0)
		{
			
		}
		else
		{	MyLogger.writeMessage("Logger: Only the output", DebugLevel.FROM_RESULTS);
			results.writeToScreen();
			
		}

	}
	
	
}