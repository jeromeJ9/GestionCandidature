
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Candidature {
    
    /**
     * permet de sauvegarder l'etat d'un candidat 
     * @param idPersonne
     * @param idSession
     * @param etatCandidature
     * @throws SQLException
     */
    public static void setEtatCandidatureByIdPersonneAndIdSession(int idPersonne,int idSession, int etatCandidature) throws SQLException{
        String sql = "UPDATE candidature SET id_etat_candidature = ?\n" +
                        "where id_personne = ? and id_session = ?;";
        Connection connection = DbAgrioteSP1.getConnection();
        PreparedStatement ordre = connection.prepareStatement(sql);
        ordre.setInt(1, etatCandidature);
        ordre.setInt(2, idPersonne);
        ordre.setInt(3, idSession);
        ordre.executeUpdate();
        connection.close();

    }
}
