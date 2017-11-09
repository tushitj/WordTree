package wordTree.threadMgmt;

import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;

public class DeleteThread {
	private Thread[] threads;
	/**
	 * This method creates a new thread to delete words
	 * 
	 * @param num
	 * @param createWorkers
	 */
	public DeleteThread(int num, CreateWorkers createWorkers) {
		MyLogger.writeMessage(this.getClass() + "Logger: Constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		threads = new Thread[num];
		for(int i=0;i<num;i++){
			threads[i] = new Thread(createWorkers);
		}
	}

	public Thread[] getDeleteThreads(){
		return threads;
	}
	

}
