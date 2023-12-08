package database;


import java.io.*;
import java.nio.file.Files;
import java.sql.*;
import java.util.Properties;



public enum DatabaseManager {

    INSTANCE;

    private Connection connection;

    DatabaseManager() {
        try {

            // 1. 加载配置文件
            File file = new File("database.properties");
            System.out.println(file.getAbsoluteFile());
            InputStream is = Files.newInputStream(new File("Database/resources/database.properties").toPath());

            Properties pr = new Properties();
            pr.load(is);



            // 2. 读取配置信息
            String user = pr.getProperty("user");
            String password = pr.getProperty("password");
            String url = pr.getProperty("url");
            String driverClass = pr.getProperty("driverClass");

            // 3. 加载驱动
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC", "root", "123456");
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException | IOException e) {
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

    public boolean executePreparedSQL(String sql, String... args) throws SQLException {
       // Statement statement = connection.createStatement();
       PreparedStatement statement = connection.prepareStatement(sql);
       for (int i = 1; i <= args.length; i++) {
           statement.setString(i, args[i - 1]);
       }
       boolean flag =statement.execute();
       connection.commit();
       return flag;
    }

}
