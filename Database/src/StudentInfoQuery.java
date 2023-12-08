import java.sql.*;

public class StudentInfoQuery {
    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private Connection connection;

    private static final StudentInfoQuery INSTANCE = new StudentInfoQuery();

    private StudentInfoQuery() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to establish database connection.");
            throw new RuntimeException(e);
        }
    }

    public static StudentInfoQuery getInstance() {
        return INSTANCE;
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    // Other database operations and utility methods can be added here

    public static void main(String[] args) {
        StudentInfoQuery dbManager = StudentInfoQuery.getInstance();
        try (ResultSet rs = dbManager.executeQuery("SELECT * FROM student_info")) {
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString("name");

                Date birthday = rs.getDate("birthday");

                // String birthday = rs.getString("birthday");

                System.out.println(id + " " + name +((birthday != null) ? (" 生日：" + birthday) : ""));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
