package wordTree.threadMgmt;

import wordTree.util.MyLogger;
import wordTree.util.MyLogger.DebugLevel;

public class DeleteThread {
	private Thread[] threads;
	public DeleteThread(int num, CreateWorkers createWorkers) {
		MyLogger.writeMessage("Constructor called", DebugLevel.CONSTRUCTOR);
		threads = new Thread[num];
		for(int i=0;i<num;i++){
			threads[i] = new Thread(createWorkers);
		}
	}

	public Thread[] getDeleteThreads(){
		return threads;
	}
	

}
