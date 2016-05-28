/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Candidat;
import bean.UneSession;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jerom
 */
public class CandidatureTest extends DaoTest{
    
    public CandidatureTest() {
    }

   
    @Test
    public void testSetEtatCandidatureByIdPersonneAndIdSession() throws Exception {
        System.out.println("setEtatCandidatureByIdPersonneAndIdSession");
        int idPersonne = 2;
        int idSession = 2;
        int etatCandidature = 2;
        dao.Candidature.setEtatCandidatureByIdPersonneAndIdSession(idPersonne, idSession, etatCandidature);
        UneSession session = dao.Session.getSessionWithCandidats(idSession);
        boolean result = false;
        for (Candidat unCandidat : session.getListeDePersonnes()){
            if (unCandidat.getId() == idPersonne && unCandidat.getId_etatCandidature() == 2)
                result = true;
        }
        assertTrue(result);
    }
    
}
