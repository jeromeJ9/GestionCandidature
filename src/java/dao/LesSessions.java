package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LesSessions {
    
    public static int getNombreSessions () throws SQLException{
            int nbSessions = 0;
            String sql = "SELECT count(distinct id_session) from candidature";
            Connection connection = DbAgrioteSP1.getConnection();
            Statement ordre = connection.createStatement();
            ResultSet rs = ordre.executeQuery(sql);
            while (rs.next())
               nbSessions = rs.getInt(1);
            connection.close();
            return nbSessions;
                 
    }
    
    /**
     * dit si un candidat a un etat de candidature valide sur plusieurs sessions
     * @param idCandidat
     * @return
     * @throws SQLException
     */
    public static boolean isCandidatStatutValidePlusieursSessions( int idCandidat) throws SQLException{
            boolean plusieurs = false;
            int resultat = 0;
            String sql = "SELECT count(id_session) FROM candidature\n" +
"				where id_personne = '"+idCandidat+"' AND id_etat_candidature = 2;";
            Connection connection = DbAgrioteSP1.getConnection();
            Statement ordre = connection.createStatement();
            ResultSet rs = ordre.executeQuery(sql);
            if (rs.next())
                resultat = rs.getInt(1);
            if (resultat > 1)
                plusieurs = true;
            connection.close();

            return plusieurs;
        
    }
}
