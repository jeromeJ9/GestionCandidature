
package dao;

import bean.Personne;
import bean.SessionCandidate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Session {
    
    public static SessionCandidate getCandidatsBySession(int id_session) throws SQLException {
            SessionCandidate result = null;
            List<Personne> listePersonnes = new ArrayList<Personne>();
            String intituleSession = null;
            int nbPlaces = 0;
            Connection connection = DbAgrioteSP1.getConnection();
            String sql = "SELECT f.intitule, c.id_personne, nom, prenom, c.id_etat_candidature, s.nb_places FROM candidature c\n" +
"                                INNER JOIN personne p\n" +
                        "        ON p.id_personne = c.id_personne\n" +
                        "        INNER JOIN session s\n" +
                        "        ON s.id_session = c.id_session\n" +
                        "        INNER JOIN formation f\n" +
                        "        ON f.id_formation = s.id_formation\n" +
                        "        WHERE (c.id_session = '"+id_session+"');";
            Statement ordre = connection.createStatement();
            ResultSet rs = ordre.executeQuery(sql);
            while (rs.next()) {
                Personne person = new Personne(rs.getInt("c.id_personne"),rs.getString("nom"),rs.getString("prenom"), rs.getInt("id_etat_candidature"));
                listePersonnes.add(person);
                intituleSession = rs.getString("intitule");
                nbPlaces = rs.getInt("s.nb_places");
            }
            result = new SessionCandidate(id_session, intituleSession, listePersonnes, nbPlaces);
            return result;
            
            
       
    }
}
