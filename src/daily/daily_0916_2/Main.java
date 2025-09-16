package daily.daily_0916_2;

public class Main {
	static final int SIMULATION_TIME = 10;
	static final int CAPACITY = 10;
	
	public static void main(String[] args) throws InterruptedException {
		ParkingLot parkingLot = new ParkingLot(CAPACITY);
		SimulationControl control = new SimulationControl(true);

		Thread entryThread = new Thread(new SensorIn(parkingLot, control));
		Thread exitThread = new Thread(new SensorOut(parkingLot, control));
		Thread displayThread = new Thread(new Display(parkingLot, control, SIMULATION_TIME));

		entryThread.start();
		exitThread.start();
		displayThread.start();

		displayThread.join();

		entryThread.interrupt();
		exitThread.interrupt();

		entryThread.join();
		exitThread.join();
		System.out.println("\n==============================");
		System.out.println("\n            영업 종료            ");
		System.out.println("(최종 점유: " + parkingLot.getOccupied().get() + "/" + CAPACITY + ")");
		System.out.println("\n==============================");
	}
}
