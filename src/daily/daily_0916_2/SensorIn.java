package daily.daily_0916_2;

import java.util.Random;

public class SensorIn implements Runnable {
	private final ParkingLot parkingLot;
	private final SimulationControl control;
	private final Random rand = new Random();
	private final int MIN_DELAY = 200;
	private final int MAX_DELAY = 700;

	public SensorIn(ParkingLot parkingLot, SimulationControl control) {
		this.parkingLot = parkingLot;
		this.control = control;
	}

	@Override
	public void run() {
		try {
			while (control.isRunning()) {
				Thread.sleep(MIN_DELAY + rand.nextInt(MAX_DELAY + 1 - MIN_DELAY)); // 200~700ms

				synchronized (parkingLot.getLock()) {
					while (parkingLot.getOccupied().get() == parkingLot.getCapacity()) {
						System.out.println("만차, 입차 대기");
						parkingLot.getLock().wait();
						if (!control.isRunning())
							return;
					}
					int current = parkingLot.getOccupied().incrementAndGet();
					System.out.println("입차 성공 (" + current + "/" + parkingLot.getCapacity() + ")");
				}
			}
		} catch (InterruptedException ignored) {
		}
	}
}
