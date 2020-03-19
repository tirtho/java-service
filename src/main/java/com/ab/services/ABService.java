/**
 * 
 */
package com.ab.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tibarar
 *
 */
public class ABService {
			
    private static final Logger logger = Logger.getLogger(ABService.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       
        logger.log(Level.INFO, "Starting ABService");

        ABConfiguration config = new ABConfiguration();
        
		try (Connection con = DriverManager.getConnection(config.getPostgresUrl(), config.getPostgresUser(), config
				.getPostgresPassword());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT name FROM AUTHORS")) {

            while (rs.next()) {
                logger.log(Level.INFO, rs.getString(1));
            }
            con.close();      
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
	}	
}
