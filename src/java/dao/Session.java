
package dao;

import bean.Candidat;
import bean.UneSession;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Session {
    
    public static UneSession getCandidatsBySession(int id_session) throws SQLException {
            UneSession result = null;
            List<Candidat> listePersonnes = new ArrayList<Candidat>();
            String intituleSession = null;
            int nbPlaces = 0;
            Date debutSession = null;
            Date debutInscription = null;
            Date finInscription = null;
            Connection connection = DbAgrioteSP1.getConnection();
            String sql = "SELECT f.intitule, c.id_personne, nom, prenom, c.id_etat_candidature, s.nb_places, s.date_debut, s.date_debut_inscription, s.date_fin_inscription FROM candidature c\n" +
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
                Candidat person = new Candidat(rs.getInt("c.id_personne"),rs.getString("nom"),rs.getString("prenom"), rs.getInt("id_etat_candidature"));
                listePersonnes.add(person);
                if (intituleSession == null ){
                    intituleSession = rs.getString("intitule");
                    nbPlaces = rs.getInt("s.nb_places");
                    debutSession = rs.getDate("s.date_debut");
                    debutInscription = rs.getDate("s.date_debut_inscription");
                    finInscription = rs.getDate("s.date_fin_inscription");
                }
            }
            result = new UneSession(id_session, intituleSession, listePersonnes, nbPlaces, debutSession, debutInscription, finInscription);
            connection.close();

            return result;
    }

   
}
