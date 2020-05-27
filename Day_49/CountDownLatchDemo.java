package may_27;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		CountDownLatch latch = new CountDownLatch(3);
		service.submit(new DependentService(latch));
		service.submit(new DependentService(latch));
		service.submit(new DependentService(latch));
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count down is zero now. Main thread can proceed.");
		//processing of main thread 

	}

}

final class DependentService implements Runnable {
	
	private CountDownLatch latch;
	
	DependentService(CountDownLatch latch) {
		this.latch=latch;
	}
	@Override
	public void run() {
		//processing db startup
		latch.countDown();
		//thread goes on processing forward
	}
}
