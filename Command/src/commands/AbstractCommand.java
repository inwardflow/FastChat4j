package commands;

import task.AbstractTask;


import task.AbstractTask;
import task.IArgsTask;
import task.TaskFactory;
import task.TaskManager;


public abstract class AbstractCommand {
    private String flag;
    private String description;
    private TaskFactory factory;

    public String getFlag() {
        return flag;
    }

    public AbstractCommand(String flag, String description, TaskFactory factory) {
        this.flag = flag;
        this.description = description;
        this.factory = factory;
    }

    public String getDescription() {
        return description;
    }

    public void run(String command) {

        AbstractTask task = factory.create();

        if (task instanceof IArgsTask) {
            task.args = ((IArgsTask) task).parseArgs(command);
        }

        TaskManager.INSTANCE.execute(task);
    }


}
