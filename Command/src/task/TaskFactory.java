package task;

import task.student.InsertTask;

public enum TaskFactory {
    HELP,
    EXIT,
    DATE,
    CALENDAR,

    // 对数据库的增删改查
    INSERT,
    DELETE,
    UPDATE,
    SELECT;

    public AbstractTask create() {
        switch (this) {
            case HELP:
                return new HelpTask();
            case EXIT:
                return new ExitTask();
            case DATE:
                return new DateTask();
            case CALENDAR:
                return new CalendarTask();
            case INSERT:
                return new InsertTask();
            default:
                throw new IllegalArgumentException("不存在Task");
        }
    }
}
