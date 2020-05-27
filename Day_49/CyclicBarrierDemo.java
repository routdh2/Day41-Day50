package may_27;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		CyclicBarrier barrier = new CyclicBarrier(3);
		service.submit(new Task(barrier));
		service.submit(new Task(barrier));
		service.submit(new Task(barrier));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

private static class Task implements Runnable {
	
	private CyclicBarrier barrier;
	
	Task(CyclicBarrier barrier) {
		this.barrier=barrier;
	}
	@Override
	public void run() {
		//do something
		while(true) {
			try {
				barrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//processing of each thread
		}
		
		
		
	}
}

}

