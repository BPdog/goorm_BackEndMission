package daily.daily_0916;

public class NumberThread extends Thread {
	private final Object lock;
	private SharedData sharedData;
	private final int sleepTime = 50;

	public NumberThread(Object lock, SharedData sharedData) {
		this.lock = lock;
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			synchronized (lock) { // synchronized 사용 공유 변수 안전 접근
				System.out.println(i + "공유 변수: " + sharedData.value);
				sharedData.value++;
			}
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int getSharedNumber() {
		return sharedData.value;
	}
}
