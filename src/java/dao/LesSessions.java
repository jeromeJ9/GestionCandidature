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
            return nbSessions;
                 
    }
}
