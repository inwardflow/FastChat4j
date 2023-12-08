package task;

public class ExitTask extends AbstractTask {
    @Override
    public void run() {
        System.exit(0);
    }
}
