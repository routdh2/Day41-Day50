package may_27;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserAsCyclicBarrier {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		Phaser phaser = new Phaser(4);
		service.submit(new Task(phaser));
		service.submit(new Task(phaser));
		service.submit(new Task(phaser));
		service.submit(new Task(phaser));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static class Task implements Runnable {
		
		private Phaser phaser;
		Task(Phaser phaser) {
			this.phaser=phaser;
		}
		@Override
		public void run() {
			//do something
			while(true) {
				phaser.arriveAndAwaitAdvance();
				//waits for other threads to come to the common execution point
			}
			
		}
	}

}
