
public class Clock implements Runnable {
	
	private void pause(double seconds) {
		try {
			Thread.sleep((int)(seconds*1000));
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
	public void run() {
		
	}

}
