import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    public static void main(String[] args) {
        String regex = "(insert|INSERT)\\s+(\\d+)\\s+(\\S+)(\\s+(\\d+))?(\\s+(\\d+(-|年)\\d+(-|月)(\\d+)日?))?(\\s+([男女]|[10]))?(\\s+(.*))?";
        //String regex = "(insert|INSERT)?\\s*(\\d+)?\\s*(\\S+)?\\s*?(\\d+)?\\s*?(\\d+(?:-|年)\\d+(?:-|月)(\\d+)日?)?\\s*?([男女]|[10])?\\s*?(.*)?";
        String input = "insert 132 admin123测试账号 18 2003-11-11 男 蔡徐坤村";
        //String input = "insert 233 132";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            System.out.println(matcher.group());
            String id = matcher.group(2);
            String username = matcher.group(3);
            String age = matcher.group(5);
            String birthday = matcher.group(7);
            String gender = matcher.group(12);
            String address = matcher.group(14);

            System.out.println("ID: " + id);
            System.out.println("Username: " + username);
            System.out.println("Age: " + age);
            System.out.println("Birthday: " + birthday);
            System.out.println("Gender: " + gender);
            System.out.println("Address: " + address);
        } else {
            System.out.println("No match found.");
        }

    }
}
