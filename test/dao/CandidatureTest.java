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
public class CandidatureTest {
    
    public CandidatureTest() {
    }

    /**
     * Test of setEtatCandidatureByIdPersonneAndIdSession method, of class Candidature.
     */
    @Test
    public void testSetEtatCandidatureByIdPersonneAndIdSession() throws Exception {
        System.out.println("setEtatCandidatureByIdPersonneAndIdSession");
        int idPersonne = 0;
        int idSession = 0;
        int etatCandidature = 0;
        Candidature.setEtatCandidatureByIdPersonneAndIdSession(idPersonne, idSession, etatCandidature);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
