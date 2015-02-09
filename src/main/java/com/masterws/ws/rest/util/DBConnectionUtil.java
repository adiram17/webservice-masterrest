/**
 * 
 */
package com.masterws.ws.rest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 * @author adi.ramadhan
 *
 */
public class DBConnectionUtil {
	
	
	/**
	 * digunakan untuk tes java app
	 * @return connection
	 */
	public static Connection getJDBCConnection() {
		
		Connection connection=null;
		try {
			//try get driver class
			Class.forName(Constant.DATABASE_DRIVER);
			String url=Constant.DATABASE_URL;
			String user=Constant.DATABASE_USERNAME;
			String password=Constant.DATABASE_PASSWORD;
			connection=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	/**
	 * digunakan untuk web server tomcat
	 * @return connection
	 */
	public static Connection getJNDIConnection(){
		Connection connection=null;
		try {
		      InitialContext context = new InitialContext();
		      DataSource dataSource = (DataSource) context.lookup(Constant.DATABASE_DATASOURCE);
		      connection = dataSource.getConnection();
		    } catch (NamingException e) {
		      e.printStackTrace();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		return connection;
	}

}
