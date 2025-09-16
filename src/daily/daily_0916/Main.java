package daily.daily_0916;

public class Main {
	public static void main(String[] args) {
		Object lock = new Object();
		SharedData sharedData = new SharedData();

		NumberThread numberThread = new NumberThread(lock, sharedData);
		CharRunnable charRunnable = new CharRunnable(lock, sharedData);
		Thread charThread = new Thread(charRunnable);

		numberThread.start();
		charThread.start();

		try {
			numberThread.join();
			charThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("모든 스레드 종료" + sharedData.value);
	}
}
