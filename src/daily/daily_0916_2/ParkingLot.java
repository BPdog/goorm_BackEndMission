package daily.daily_0916_2;

import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {
	private final int capacity;
	private final AtomicInteger occupied = new AtomicInteger(0);
	private final Object lock = new Object();

	public ParkingLot(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public AtomicInteger getOccupied() {
		return occupied;
	}

	public Object getLock() {
		return lock;
	}
}
