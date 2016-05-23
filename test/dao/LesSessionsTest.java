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
public class LesSessionsTest {
    
    public LesSessionsTest() {
    }

    /**
     * Test of getNombreSessions method, of class LesSessions.
     */
    @Test
    public void testGetNombreSessions() throws Exception {
        System.out.println("getNombreSessions");
        int expResult = 0;
        int result = LesSessions.getNombreSessions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCandidatStatutValidePlusieursSessions method, of class LesSessions.
     */
    @Test
    public void testIsCandidatStatutValidePlusieursSessions() throws Exception {
        System.out.println("isCandidatStatutValidePlusieursSessions");
        int idCandidat = 0;
        boolean expResult = false;
        boolean result = LesSessions.isCandidatStatutValidePlusieursSessions(idCandidat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
