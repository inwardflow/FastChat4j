package task;

import commands.AbstractCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface IArgsTask {
    default String[] parseArgs(String command) {
        return command.substring(command.indexOf(" ") + 1).split(" ");
    }

}
