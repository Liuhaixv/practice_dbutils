package test.day09;

import day09.Dbutils;
import day09.Master;
import day09.Pet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Ignore;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Dbutils Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>1月 7, 2020</pre>
 */
public class DbutilsTest {
    @Test
    @Ignore
    public void updateTest() throws Exception {
        DataSource source = new DataSource() {
            @Override
            public Connection getConnection() throws SQLException {
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.144.230.152/day0104?useSSL=false&serverTimezone=UTC", "liuhaixv", "7483855@topc");
                return connection;
            }

            @Override
            public Connection getConnection(String username, String password) throws SQLException {
                return null;
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                return false;
            }

            @Override
            public PrintWriter getLogWriter() throws SQLException {
                return null;
            }

            @Override
            public void setLogWriter(PrintWriter out) throws SQLException {

            }

            @Override
            public void setLoginTimeout(int seconds) throws SQLException {

            }

            @Override
            public int getLoginTimeout() throws SQLException {
                return 0;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
            }
        };
        QueryRunner qr = new QueryRunner(source);
        int num = qr.update("insert into accounts (name,password) values ('刘海旭','7483855')");
        System.out.println(num);
    }

    @Test
    public void queryTest() throws Exception {
        QueryRunner qr = Dbutils.getQueryRunner();
        //获取数据库所有master记录
        List<Master> masters = qr.query("select * from master", new BeanListHandler<>(Master.class));
        for (Master master : masters) {
            //System.out.println(master);
            //获取所有该Master的宠物记录
            List<Pet> pets = qr.query(
                    "select * from pet where masterid=?",
                    new BeanListHandler<>(Pet.class),
                    master.getId());
            System.out.println("主人:" + master.getName());
            System.out.println("拥有的宠物:");
            for (Pet pet : pets) {
                System.out.print("\t\t");
                System.out.println(pet);
            }
        }
//        List<Account> accounts = qr.query("select * from accounts", new BeanListHandler<>(Account.class));
//        for (Account ac : accounts) {
//            System.out.println(ac);
//        }
    }
} 
