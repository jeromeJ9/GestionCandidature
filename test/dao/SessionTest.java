
package dao;

import bean.Candidat;
import bean.UneSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class SessionTest extends DaoTest{
    
    public SessionTest() {
    }

    /**
     * Test of getCandidatsBySession method, of class Session.
     */
    @Test
    public void testGetCandidatsBySession() throws Exception {
        System.out.println("getCandidatsBySession");
       
        List<Candidat> listePersonne = new ArrayList<Candidat>();
        Candidat p3 = new Candidat(6, "MOREAU", "Vincent", 3);
        Candidat p1 = new Candidat(12, "MOSHINE", "Hajar", 3);
        Candidat p2 = new Candidat(18, "DUPOND", "Dupond", 3);
        listePersonne.add(p3);
        listePersonne.add(p1);
        listePersonne.add(p2);
        Date debut = Date.valueOf( "2017-02-10" );
        Date debutIns = Date.valueOf( "2017-01-14" );
        Date finIns = Date.valueOf( "2017-02-01" );
        UneSession expResult = new UneSession(6, "Bac S.T.I. : génie mécanique, génie électrotechnique", listePersonne, 14, debut, debutIns,finIns );
        //System.out.println("expResult"+expResult.getListeDePersonnes().toString());
        UneSession result = null;
        result = dao.Session.getCandidatsBySession(6);
        //System.out.println("result"+result.getListeDePersonnes().toString());
        assertEquals(result, expResult );
    }

    
    
   
    
}
