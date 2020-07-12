package Connection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author FLD
 * @create 2020-05-20 16:56
 */
public class ConnectionTest {
    @Test
    public void testconnectionTest1() throws SQLException {
        Driver driver=null;
        String url=null;
        Properties info=null;
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }
}
