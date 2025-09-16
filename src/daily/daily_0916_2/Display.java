package daily.daily_0916_2;

public class Display implements Runnable {
	private final ParkingLot parkingLot;
	private final SimulationControl control;
	private final int DISPLAY_DELAY = 1000;
	int simulationTime;

	public Display(ParkingLot parkingLot, SimulationControl control, int simulationTime) {
		this.parkingLot = parkingLot;
		this.control = control;
		this.simulationTime = simulationTime;
	}

	@Override
	public void run() {
		int seconds = 0;
		try {
			while (control.isRunning()) {
				synchronized (parkingLot.getLock()) {
					System.out.println("현재 현황: " + parkingLot.getOccupied().get() + " / " + parkingLot.getCapacity()
							+ "|시뮬레이션 시간 :" + seconds);
				}
				Thread.sleep(DISPLAY_DELAY);
				seconds++;
				if (seconds >= simulationTime) {
					control.stop();
					synchronized (parkingLot.getLock()) {
						parkingLot.getLock().notifyAll();
					}
				}
			}
		} catch (InterruptedException ignored) {
		}
	}
}
