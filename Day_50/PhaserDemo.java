package may_27;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserDemo {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		Phaser phaser = new Phaser(3);
		service.submit(new DependentService(phaser));
		service.submit(new DependentService(phaser));
		service.submit(new DependentService(phaser));
		phaser.awaitAdvance(1);
		System.out.println("All the initialization services completed.");
		//processes the main logic

	}
	
	private static class DependentService implements Runnable {
		
		private Phaser phaser;
		DependentService(Phaser phaser) {
			this.phaser=phaser;
		}
		@Override
		public void run() {
			//do some initialization
			phaser.arrive();
			//do some post processing
		}
	}

}
