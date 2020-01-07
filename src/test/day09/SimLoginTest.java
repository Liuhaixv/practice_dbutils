package test.day09;

import day09.SimLogin;
import org.junit.*;

import java.sql.Statement;

/**
 * SimLogin Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>1‘¬ 6, 2020</pre>
 */
public class SimLoginTest {
    public static SimLogin simLogin;
    Statement statement;

    @BeforeClass
    public static void beforeClass() throws Exception {
        simLogin = new SimLogin("192.144.230.152", "liuhaixv", "7483855@topc");
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getStatement()
     */
    @Ignore
    public void testGetStatement() throws Exception {
        statement = simLogin.getStatement();
//TODO: Test goes here... 
    }

    /**
     * Method: executeQuery(String query)
     */
    @Test
    public void testExecuteQuery() throws Exception {
        //simLogin.executeQuery("select * from emp");
    }

    @Test
    public void testExecuteUpdate() throws Exception {
        simLogin.executeUpdate(
                "insert into accounts (name,password)" +
                        "values" +
                        "(≤‚ ‘»À‘±1£¨123456)");
    }

    @Test
    @Ignore
    public void testHelloWorld() {
        String str = "HelloWorld";
    }

} 
