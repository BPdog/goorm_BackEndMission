package daily.daily_0916_2;

public class SimulationControl {
    private volatile boolean running;

    public SimulationControl(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }

    public void stop() {
        running = false;
    }
}
