package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.ConnexionBD;

import oo.Person;

public class PersonDAO {
	public static Person Ajouter(Person p) {
		Connection c = ConnexionBD.getConnection();
		if (c != null) {
		try { PreparedStatement ps = c.prepareStatement("insert into person (email,name,phone,password) values (?,?,?,?);");
		ps.setString(1,p.getEmail());
		ps.setString(2, p.getName());
		ps.setString(3, p.getPhone());
		ps.setString(4, p.getPassword());
		int res = ps.executeUpdate();
		if (res != 0) {
			System.out.println(p);
		return p;
		}
		} catch (SQLException e) { e.printStackTrace(); }
		}
		return null;

}
	
	public static Person RechercherParEmail(String email) {
		Person p = null;
		Connection c = ConnexionBD.getConnection();
		if (c != null) {
		try { PreparedStatement ps=c.prepareStatement("select * from person where email = ?; ");
		ps.setString(1, email);
		ResultSet r = ps.executeQuery();
		if (r.next())
		p = new Person( r.getString("id"), r.getString("name"),r.getString("email"),r.getString("phone"),r.getString("password"));
		} catch (SQLException e) { e.printStackTrace(); }
		}
		return p;
		}
}
