package daily.daily_0916;

public class CharRunnable implements Runnable {
	private final Object lock;
	private SharedData sharedData;
	private final int sleepTime = 50;

	public CharRunnable(Object lock, SharedData sharedData) {
		this.lock = lock;
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		for (char c = 'A'; c <= 'J'; c++) {
			synchronized (lock) { // synchronized 사용 공유 변수 안전 접근
				System.out.println(c + "공유 변수: " + sharedData.value);
				sharedData.value++;
			}
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int getSharedChar() {
		return sharedData.value;
	}
}
