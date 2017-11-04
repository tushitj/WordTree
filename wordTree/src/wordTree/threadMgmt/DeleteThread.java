package wordTree.threadMgmt;

public class DeleteThread {
	private Thread[] threads;
	public DeleteThread(int num, CreateWorkers createWorkers) {
		threads = new Thread[num];
		for(int i=0;i<num;i++){
			threads[i] = new Thread(createWorkers);
		}
	}

	public Thread[] getDeleteThreads(){
		return threads;
	}
	

}
