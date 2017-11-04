package wordTree.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileProcessor Class that is used to process the input and output files.
 * @author tushitjain
 *
 */
public class FileProcessor {
    private String fileName;
    BufferedReader br;
    FileReader fin;

    /**
     * Constructor that initalizes file by filename
     * @param fileNameIn : input filename from Driver.Main
     */
    public FileProcessor(String fileNameIn) {
        if(fileNameIn != null && (fileNameIn.trim().length() > 0)){
            fileName = fileNameIn;
            try{
                File file = new File(fileName);
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
            System.out.println("Invalid File Name");
        }
        //MyLogger.writeMessage("FileProcessor class constructor." , MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * Function reads each line from the file and returns it to the calling function
     * @return string value from the file
     */
    public String readLine(){
        String line = null;
        try{
            line = br.readLine();
            //if(line == null || (line.trim().length()<1)){
            if(line == null){
            		return null;
            }
            else{
                return line;
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



}