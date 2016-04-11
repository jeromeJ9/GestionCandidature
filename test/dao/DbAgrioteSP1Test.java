
package dao;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;


public class DbAgrioteSP1Test {
    
    
    @Test
    public void testGetConnection() throws Exception {
    System.out.println("getConnection");
    Connection result = DbAgrioteSP1.getConnection();
    assertNotNull(result);
    }
    
}
