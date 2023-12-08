package task;


import java.util.Arrays;

public class CalendarTask extends AbstractTask implements IArgsTask{



    public CalendarTask() {

    }

    @Override
    public void run() {

            int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int year = Integer.parseInt(args[0]), month = Integer.parseInt(args[1]);
            int w;
            if (month == 1 || month == 2) {
                w = (1 + 2 * (month + 12) + 3 * (month + 12 + 1) / 5 + year - 1 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400) % 7 + 1;
            } else {
                w = (1 + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7 + 1;
            }

            System.out.print("日\t一\t二\t三\t四\t五\t六\n");

            // 补齐前置空格
            for (int i = 1; i <= w; i++) {
                System.out.print("\t");
            }

            for (int i = 1; i < 7 - (w - 1); i++) {
                System.out.printf("%d\t", i);
            }

            int cnt = 1;
            for (int i = 7 - (w - 1) + 1; i <= days[month]; i++) {
                if (cnt % 7 == 1) System.out.println();
                System.out.print(i + "\t");
                cnt++;
            }

            System.out.println();
    }

    @Override
    public String[] parseArgs(String command) {
        return command.substring(command.indexOf(".") + 1).split("\\.");
    }
}
