package wordTree.driver;

public class Driver {
	public static void main(String[] args) {
		if(args.length !=7){
			System.err.println("Error. Incorrect Arguments" + args.length);
			System.exit(1);
		}
		String inputFile = args[0];
		String outputFile = args[1];
		try{
			int NUM_THREADS = Integer.parseInt(args[2]);
			
		}catch(NumberFormatException e){
			System.err.println("Number Expected");
			System.exit(1);
			
			
		}
		
		
	}

}
