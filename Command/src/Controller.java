import com.fastchat4j.core.enums.ErrorCode;
import commands.Commands;
import exception.UnknownException;

public enum Controller {

    INSTANCE;

    Controller() {
        // 可以在这里进行初始化操作
    }

    public void execute(String command) throws UnknownException {
        ErrorCode state = ErrorCode.NOT_FOUND;

        for (Commands commandEnum : Commands.values()) {
            if (commandEnum.getPattern().matcher(command).matches()) {
                state = ErrorCode.SUCCESS;
                commandEnum.getAbstractCommand().run(command);
                break;
            } else if (commandEnum.getAbstractCommand().getFlag().contains(command)) {
                state = ErrorCode.FORMAT_ERROR;
            }
        }

        if (state != ErrorCode.SUCCESS) {
            System.out.println(state);
            if (state == ErrorCode.NOT_FOUND)
                throw new UnknownException(command);
        }
    }
}
