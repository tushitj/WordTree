package wordTree.threadMgmt;

public class PopulateThread {
	private Thread[] threads;
	public PopulateThread(int num, CreateWorkers createWorkers) {
		threads = new Thread[num];
		for(int i=0;i<num;i++){
			threads[i] = new Thread(createWorkers);
		}
	}

	public Thread[] getPopulateThreads(){
		return threads;
	}
	

}
