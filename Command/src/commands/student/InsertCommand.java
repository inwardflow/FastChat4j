package commands.student;

import commands.AbstractCommand;
import task.TaskFactory;

public class InsertCommand extends AbstractCommand {

    public InsertCommand() {
        super("insert", "增加学生个人信息", TaskFactory.INSERT);
    }

}
