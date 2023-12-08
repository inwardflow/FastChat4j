package task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum TaskManager {

    INSTANCE;

    private ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
    public void execute(AbstractTask task) {
        scheduledExecutorService.execute(task);
    }


}
