package wordTree.store;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;

import wordTree.util.FileDisplayInterface;
import wordTree.util.StdoutDisplayInterface;

public class Results implements StdoutDisplayInterface,FileDisplayInterface {
	private PrintWriter out;
	private StringBuilder sb;
	
	public Results(){
		MyLogger.writeMessage(this.getClass() + "Logger: Constructor called",  MyLogger.DebugLevel.CONSTRUCTOR);
		sb = new StringBuilder();
	}
	public void storeNewResult(String s){
		sb.append(s);
		sb.append("\n");
		//writeToScreen(s);
	}
	
	/**
	 * Method prints the output to output file
	 * @param filename
	 */
	@Override
	public void writeSchedulesToFile(String filename) {
		File file;
		file = new File(filename);
		if(!file.isDirectory() && file.exists()){
			file.delete();
		}
		try {
			out = new PrintWriter(new FileWriter(filename, true), true);
			out.write(sb.toString());
		} catch (IOException e) {
			MyLogger.writeMessage("Logger: Exception in Results", DebugLevel.IN_RESULTS);
			System.out.println("There was some error in creating the file");
			e.printStackTrace();
		}finally{
			out.close();
		}
	}

	/**
	 * Method prints the output to the screen
	 * @param filename
	 */
	@Override
	public void writeToScreen() {
		System.out.println(sb);
	}
		
}
