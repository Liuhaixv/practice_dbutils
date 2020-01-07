package day09;

import java.sql.*;

public class SimLogin {
    String address, user, password;
    String dataBase = "day0104";
    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    public SimLogin(String address, String user, String password) throws SQLException, ClassNotFoundException {
        //加载驱动包
        Class.forName("com.mysql.cj.jdbc.Driver");
        //设置连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + address + '/' + dataBase + "?useSSL=false&serverTimezone=UTC", user, password);
        //创建会话
        this.statement = connection.createStatement();
    }

    public Statement getStatement() {
        return statement;
    }

    public void executeQuery(String sql) {
        ResultSet result;
        ResultSetMetaData resultSetMetaData;
        try {
            result = statement.executeQuery(sql);
            resultSetMetaData = result.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSetMetaData.getColumnName(i) + "\t");
            }
            System.out.println();
            while (result.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(result.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void executeUpdate(String sql) {
        ResultSet resultSet;
        ResultSetMetaData resultSetMetaData;
        try {
            int num = statement.executeUpdate(sql);
            System.out.println(num);
            System.out.println("共有" + num + "条记录被更新");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}