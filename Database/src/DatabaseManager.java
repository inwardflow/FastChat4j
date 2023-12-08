import java.sql.*;

public enum DatabaseManager {

    INSTANCE;

    private Connection connection;

    DatabaseManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC", "root", "123456");
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean executeSQL(String sql) {
        // 这里可以使用 try-with-resources 这样就不用 close 了
        // try () {} catch () {}


        try (Statement statement = connection.createStatement()) {
            return statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeQuery(String sql, String... args) throws SQLException {
       // Statement statement = connection.createStatement();
       PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 1; i <= args.length; i++) {
            statement.setString(i, args[i]);
        }
       return statement.executeQuery(sql);
    }

}
