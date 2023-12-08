package commands;

import task.ExitTask;
import task.TaskFactory;

public class ExitCommand extends AbstractCommand{
    public ExitCommand() {
        super("/exit", "退出", TaskFactory.EXIT);
    }

}
