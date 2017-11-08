package wordTree.store;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import wordTree.util.FileDisplayInterface;
import wordTree.util.StdoutDisplayInterface;

public class Results implements StdoutDisplayInterface,FileDisplayInterface {
	private PrintWriter out;
	private StringBuilder sb;
	
	public Results(){
		sb = new StringBuilder();
	}
	public void storeNewResult(String s){
		sb.append(s);
		sb.append("\n");
		//writeToScreen(s);
	}
	
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
			System.out.println("There was some error in creating the file");
			e.printStackTrace();
		}finally{
			out.close();
		}
	}

	@Override
	public void writeToScreen() {
		System.out.println(sb);
	}
		
}
