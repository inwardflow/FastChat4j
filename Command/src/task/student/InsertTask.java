package task.student;

import database.DatabaseManager;
import task.AbstractTask;
import task.IArgsTask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertTask extends AbstractTask implements IArgsTask {

    @Override
    public String[] parseArgs(String command) {

        String regex = "(insert|INSERT)\\s+(\\d+)\\s+(\\S+)(\\s+(\\d+))?(\\s+(\\d+(-|年)\\d+(-|月)(\\d+)日?))?(\\s+([男女]|[10]))?(\\s+(.*))?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);

        int[] patternsIndex = {2, 3, 5, 7, 12, 14};
        List<String> result = new ArrayList<>();


        if (matcher.find()) {
            for (int index : patternsIndex) {
                result.add(matcher.group(index));
            }
            return result.toArray(new String[result.size()]);
        } else {
            return new String[] {""};
        }

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    }

    @Override
    public void run() {
        //  if (args.length < 2) return ;
        try {
            Arrays.stream(args).forEach(System.out::println);
            System.out.println(1);
            System.out.println(DatabaseManager.INSTANCE.executePreparedSQL("insert into student_info(id,name,age,birthday,sex,address) value(?,?,?,?,?,?)", args));
            System.out.println("-----tes------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
