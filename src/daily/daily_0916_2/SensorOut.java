package daily.daily_0916_2;

import java.util.Random;

public class SensorOut implements Runnable {
	private final ParkingLot parkingLot;
	private final SimulationControl control;
	private final Random rand = new Random();
	private final int MIN_DELAY = 300;
	private final int MAX_DELAY = 900;

	public SensorOut(ParkingLot parkingLot, SimulationControl control) {
		this.parkingLot = parkingLot;
		this.control = control;
	}

	@Override
	public void run() {
		try {
			while (control.isRunning()) {
				Thread.sleep(MIN_DELAY + rand.nextInt(MAX_DELAY + 1 - MIN_DELAY)); // 300~900ms 대기

				synchronized (parkingLot.getLock()) {
					if (parkingLot.getOccupied().get() == 0) {
						System.out.println("출차 대기 (빈 차량 없음)");
					} else {
						int current = parkingLot.getOccupied().decrementAndGet();
						System.out.println("출차 완료 (" + current + "/" + parkingLot.getCapacity() + ")");
						parkingLot.getLock().notifyAll();
					}
				}
			}
		} catch (InterruptedException ignored) {
		}
	}
}
