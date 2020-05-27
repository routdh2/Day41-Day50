package may_27;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(50);
		Semaphore semaphore = new Semaphore(3);
		for(int i=0;i<1000;i++) {
			service.submit(new Task(semaphore));
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		service.shutdown();
		if(!service.isShutdown()) {
			try {
				service.awaitTermination(1,TimeUnit.MINUTES);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		service.shutdownNow();
	}

}

class Task implements Runnable {
	
	private static Semaphore semaphore;
	
	Task(Semaphore _semaphore) {
		semaphore=_semaphore;
	}
	@Override
	public void run() {
		//doing some processing
		try {
			semaphore.acquireUninterruptibly();
			System.out.println(Thread.currentThread().getName());
			System.out.println(semaphore.availablePermits());
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//make IO connection to DB
		
		semaphore.release();
		//doing some post processing
	}
}
