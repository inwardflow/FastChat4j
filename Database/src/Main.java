import com.mysql.cj.protocol.Resultset;
import org.junit.jupiter.api.Test;

import java.sql.*;



public class Main {

    // static Connection conn;

    @Test
    public void connectCheck() {
        try (ResultSet rs = DatabaseManager.INSTANCE.executeQuery("SELECT id, name, birthday FROM student_info")){
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString("name");
                Date birthday = rs.getDate("birthday");
                System.out.println(id + " " + name +((birthday != null) ? (" 生日：" + birthday) : ""));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
