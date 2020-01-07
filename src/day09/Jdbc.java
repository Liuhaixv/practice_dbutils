package day09;

import java.sql.*;
import java.util.Scanner;

public class Jdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动包
        Class.forName("com.mysql.cj.jdbc.Driver");
        //设置连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.144.230.152:3306/day0104?useSSL=false&serverTimezone=UTC", "liuhaixv", "7483855@topc");
        //创建会话
        Statement statement = connection.createStatement();
        //
        Scanner sc = new Scanner(System.in);
        String sql = "";
        ResultSet result;
        ResultSetMetaData resultSetMetaData;
        while (!sql.equals("end")) {
            sql = sc.nextLine();
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
    }
}
