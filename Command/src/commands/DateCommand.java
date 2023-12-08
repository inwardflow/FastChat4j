package commands;

import task.AbstractTask;
import task.DateTask;
import task.CalendarTask;
import task.TaskFactory;

public class DateCommand extends AbstractCommand {

    public DateCommand() {
        super("/date", "显示当前事件", TaskFactory.DATE);
        // this.setTask(new CalendarTask());
    }


}

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Main {
//    public static void main(String[] args) {
//        String text = "/date.2023.7";
//
//
//
//
//
//
//
//
//
//
//
//
//
//    }
//}
