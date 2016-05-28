/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jerom
 */
public class LesSessionsTest extends DaoTest {
    
    public LesSessionsTest() {
    }

    /**
     * Test of getNombreSessions method, of class LesSessions.
     */
    @Test
    public void testGetNombreSessions() throws Exception {
        System.out.println("getNombreSessions");
        int expResult = 6;
        int result = LesSessions.getNombreSessions();
        assertEquals(expResult, result);
        
    }

   
    
}
