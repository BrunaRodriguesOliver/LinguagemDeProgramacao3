package Questao14;

public class Cedulas implements Runnable{
	public void repor(Thread t) {
		t.start();
	}
	
	@Override
	public void run() {
		try {
			for(int auxB=0; auxB< 4; auxB++) {
				System.out.println("Alimentando com mais cedulas...");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

