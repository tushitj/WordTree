package wordTree.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * FileProcessor Class that is used to process the input and output files.
 * @author tushitjain
 *
 */
public class FileProcessor {
    //public int counter=0;
    private String fileName;
    BufferedReader br;
    FileReader fin;
    String[] arr;
    private List<String> list;
    Iterator<String> i;

    /**
     * Constructor that initializes file by filename
     * @param fileNameIn : input filename from Driver.Main
     */
    public FileProcessor(String fileNameIn) {
        if(fileNameIn != null && (fileNameIn.trim().length() > 0)){
            fileName = fileNameIn;
            try{
                File file = new File(fileName);
                if(file.length() < 1){
                    System.err.println("File is empty. Cannot proceed.");
                    System.exit(1);
                }
                if(!file.isDirectory() && file.exists()){
                    fin = new FileReader(file);
                    br = new BufferedReader(fin);
                }
                else{
                    System.err.println("No file found");
                    throw new FileNotFoundException();
                }
            }catch(FileNotFoundException e){
                e.printStackTrace();
                System.exit(0);
            }
        }
        else{
            System.err.println("Invalid File Name");
        }
        //MyLogger.writeMessage("FileProcessor class constructor." , MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * Function reads each line from the file and returns it to the calling function
     * @return 
     * @return string value from the file
     */
    public void setArr(String[] arrIn) {
    	list = Collections.synchronizedList(Arrays.asList(arrIn));
    	i = list.iterator();
    	
    }
   public synchronized String getStringToDelete() {
	   synchronized(list) {
		   if(i.hasNext()) {
			   return (String)i.next();
		   }
		   return null;
	   }
   }
   synchronized public String readLine(){
        String line = null;
        try{
            line = br.readLine();
            // if(line.trim().length()<1){
            //     return "DEB";
            // }
            //if(line == null || (line.trim().length()<1)){
                //System.out.println("Line is empty or null here.");
            if(line == null){
                //System.out.println("Line is null here.");
            	return null;
            }
            else if(line.trim().length() < 1){
                //System.out.println("Line is empty here.");
                return "1@xs4#@klmn~za-b+m?";
            }

            else{
                //counter++;
                return line.trim();
            }
        }catch(IOException e){
            //MyLogger.writeMessage("Error in FileProcessor class. The file name is either not a file or does not exist." , MyLogger.DebugLevel.IN_RESULTS);
            e.printStackTrace();
        }
        finally{
//            try {
//                if(line == null && br!=null)
//                    br.close();
//                if(line == null && fin!=null)
//                    fin.close();
//            }catch (IOException e) {
//               // MyLogger.writeMessage("Error in FileProcessor class. Could not close buffers. Some object may be still using them." , MyLogger.DebugLevel.IN_RESULTS);
//                e.printStackTrace();
//            }
        }
        return line;
    }
   public void closeFiles(){
       try{
           br.close();
       fin.close();
   }catch(IOException e){
       System.err.println("Error while closing buffers and file");
       e.printStackTrace();           
   }
   }
}