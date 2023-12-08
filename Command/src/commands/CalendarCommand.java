package commands;

import task.AbstractTask;
import task.CalendarTask;
import task.TaskFactory;

public class CalendarCommand extends AbstractCommand {
    public CalendarCommand() {
        super("/date.yyyy.mm", "输出 yyyy 年 mm 月的日历", TaskFactory.CALENDAR);
    }
}
