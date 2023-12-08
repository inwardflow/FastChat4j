package task;

import commands.AbstractCommand;
import commands.Commands;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

public class HelpTask extends AbstractTask {
    public HelpTask(String... args) {
        this.args = args;
    }

    @Override
    public void run() {
        System.out.println("命令列表：");
        if (args.length == 0) {
            Arrays.stream(Commands.values()).forEach(command ->
                System.out.println(command.getAbstractCommand().getFlag() + " " +
                    command.getAbstractCommand().getDescription())
            );
        } else {
            // TODO 输出单个命令的描述信息
        }
        return;
    }
}
