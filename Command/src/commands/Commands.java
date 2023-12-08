package commands;

import commands.student.InsertCommand;

import java.util.regex.Pattern;

public enum Commands {

    HELP_COMMAND(Pattern.compile("/help"), new HelpCommand()),
    EXIT_COMMAND(Pattern.compile("/exit"), new ExitCommand()),
    DATE_COMMAND(Pattern.compile("/date"), new DateCommand()),
    CALENDAR_COMMAND(Pattern.compile("/date\\.(\\d{4})\\.(\\d{1,2})"), new CalendarCommand()),
    INSERT_COMMAND(Pattern.compile("(insert|INSERT)\\s+(\\d+)\\s+(\\S+)(\\s+(\\d+))?(\\s+(\\d+(-|年)\\d+(-|月)(\\d+)日?))?(\\s+([男女]|[10]))?(\\s+(.*))?"), new InsertCommand());
    private Pattern pattern;
    private AbstractCommand abstractCommand;

    Commands(Pattern pattern, AbstractCommand abstractCommand) {
        this.pattern = pattern;
        this.abstractCommand = abstractCommand;
    }


    public Pattern getPattern() {
        return pattern;
    }

    public AbstractCommand getAbstractCommand() {
        return abstractCommand;
    }


}
