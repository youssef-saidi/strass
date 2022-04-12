package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
	private static String url = "jdbc:mysql://localhost:3308/strass";
	private static String user = "root";
	private static String passwd = "";
	private static Connection cn = null;
	private  ConnexionBD() {
	try { cn = DriverManager.getConnection(url, user, passwd);
	} catch ( Exception e ) { e.printStackTrace(); }
	}
	// Récupérer l’instance de la connexion
	public  static Connection getConnection() {
	if (cn == null) { new ConnexionBD();
	System.out.println("connexion reussite !");}
	return cn;
	}
	public static void Fermer() {
	if (cn != null) {
	try { cn.close();}
	catch (SQLException e) { e.printStackTrace(); }
	}
	}

}
