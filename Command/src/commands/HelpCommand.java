package commands;

import task.HelpTask;
import task.TaskFactory;
import task.TaskManager;

public class HelpCommand extends AbstractCommand {
    public HelpCommand() {
        super("/help", "显示所有命令", TaskFactory.HELP);
    }



}
