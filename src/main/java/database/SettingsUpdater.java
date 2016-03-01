package database;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import containers.InformationHolder;

public class SettingsUpdater {
	
	private String username;
	private Connection con;
	private Statement sta;
	
	public SettingsUpdater(){
		username = InformationHolder.actualUsername;		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/komunikatordb", "root", "");
			sta = (Statement) con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void updateLanguage(String l){
		String q = "UPDATE personal SET languages='"+l+"' WHERE username='"+username+"';";
		try {
			sta.executeUpdate(q);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateReligion(String r){
		String q = "UPDATE personal SET religions='"+r+"' WHERE username='"+username+"';";
		try {
			sta.executeUpdate(q);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCellPhone1(String cp){
		String q = "UPDATE registration SET mobilephone='"+cp+"' WHERE nickname='"+username+"';";
		try {
			sta.executeUpdate(q);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCity(String c){
		String q = "UPDATE registration SET city='"+c+"' WHERE nickname='"+username+"';";
		try {
			sta.executeUpdate(q);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateDescription(String d){
		String q = "UPDATE personal SET description='"+d+"' WHERE username='"+username+"';";
		try {
			sta.executeUpdate(q);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
