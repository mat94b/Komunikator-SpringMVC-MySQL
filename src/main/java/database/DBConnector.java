

package database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.mysql.jdbc.Connection;

import containers.InformationHolder;

public class DBConnector {
	private Connection conn;
	private Statement st;

	public DBConnector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/komunikatordb", "root", "");
			st = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String passwordChecker(String username) {
		String result = null;
		String query = "SELECT * FROM userlogin WHERE nickname='" + username + "';";
		try {
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				result = rs.getString("password");
			}
		} catch (SQLException e) {
			result = null;
		}
		return result;
	}

	public String emailChecker(String emailadd) {
		String result = null;
		String query = "SELECT * FROM userlogin WHERE emailadress='" + emailadd + "';";
		try {
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				result = rs.getString("password");
			}
		} catch (SQLException e) {
			result = null;
		}
		return result;
	}

	public boolean checkAuthenticOfNewUser(String email, String name){
		String query = "SELECT * FROM userlogin WHERE nickname='"+name+"';";
		String query2 = "SELECT * FROM userlogin WHERE emailadress='"+email+"';";
		try {	
			int c = 0;
			ResultSet rs = st.executeQuery(query);		
			while(rs.next()){	
				c++;
			}		
			if (c>0) return true;
			c = 0;	
			rs = st.executeQuery(query2);		
			while(rs.next()){
				c++;
			}		
			if (c>0) return true;	
			
		} catch (SQLException e) {
		}
		return false;
	}
	
	public boolean registrationNewUser(String imie, String nazwisko, String nick, String em, String pass, String tel, String miasto){
		String query_reg="INSERT INTO registration (name, lastname, nickname, emailadress, password, mobilephone, city) values(?,?,?,?,?,?,?);";
		String query_log="INSERT INTO userlogin (nickname, emailadress, password) values(?,?,?);";
		String query_per="INSERT INTO personal (username, languages, religions, description) values(?,?,?,?);";
		String query_gi="INSERT INTO generalinformation (username, registrationDate, id) values(?,?,?);";
		String q_counter = "SELECT COUNT(username) FROM personal;";
		Calendar c = new GregorianCalendar();
		c.set(Calendar.DAY_OF_YEAR,0);
		c.set(Calendar.MONTH,0);
		c.set(Calendar.DAY_OF_MONTH,0);
		Date d = c.getTime();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String mD = formatter.format(d);
		Date myDate;
		try{
			myDate = formatter.parse(mD);
			java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
			PreparedStatement ps_r = conn.prepareStatement(query_reg);
			PreparedStatement ps_l = conn.prepareStatement(query_log);
			PreparedStatement ps_p = conn.prepareStatement(query_per);
			PreparedStatement ps_gi = conn.prepareStatement(query_gi);
			ResultSet rs = st.executeQuery(q_counter);
			int id = 0;
			while(rs.next()) id = rs.getInt(1); 
			
			ps_r.setString(1, imie);
			ps_r.setString(2, nazwisko);
			ps_r.setString(3, nick);
			ps_r.setString(4, em);
			ps_r.setString(5, pass);
			ps_r.setString(6, tel);
			ps_r.setString(7, miasto);
			ps_r.execute();

			ps_l.setString(1, nick);
			ps_l.setString(2, em);
			ps_l.setString(3, pass);
			ps_l.execute();
			
			ps_p.setString(1, nick);
			ps_p.setString(2, "(brak)");
			ps_p.setString(3, "(brak)");
			ps_p.setString(4, "(brak)");
			ps_p.execute();
			
			ps_gi.setString(1, nick);
			ps_gi.setDate(2, sqlDate);
			ps_gi.setInt(3, (id+1));
			ps_gi.execute();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public String returnNameAndSurname(String nickname){
		String q = "SELECT * FROM registration WHERE nickname='"+nickname+"';";
		String res = "";
		
		try{
			ResultSet rs = st.executeQuery(q);

			while(rs.next()){
				res="";
				res = res+rs.getString("name");
				res = res+" "+rs.getString("lastname");
			}	
		} catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
	
	public void changelastLogDate(){
		String name = InformationHolder.actualUsername;
		Calendar c = new GregorianCalendar();
		c.set(Calendar.DAY_OF_YEAR,0);
		c.set(Calendar.MONTH,0);
		c.set(Calendar.DAY_OF_MONTH,0);
		Date d = c.getTime();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String mD = formatter.format(d);
		Date myDate;
		try {
			myDate = formatter.parse(mD);
			java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
			String q = "UPDATE generalinformation SET lastOnline='"+sqlDate+"' WHERE username='"+name+"';";
			st.executeUpdate(q);	
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
