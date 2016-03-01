/*
 * Klasa laczy sie z baza danych i pobiera informacje
 * ktore wklada do obiektow ktore nastepnie sa zwracane przez
 * funkcje.
 * 
 * Zastosowanie: glownie w tworzeniu profile.html
 * 
 * @return Profile
 * @return Statistic
 */

package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import containers.Profile;
import containers.Statistics;

public class ProfileReturner {

	private String u;
	private Connection conne;
	private Statement sta;
	private Statement sta2;
	private Statement stStati;
	private Statement stGene;
	private Statement stView;
	private Statement stFunc;
	
	public ProfileReturner(String u){
		this.u = u;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conne = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/komunikatordb", "root", "");
			sta = (Statement) conne.createStatement();
			sta2 = (Statement) conne.createStatement();
			stStati = (Statement) conne.createStatement();
			stGene = (Statement) conne.createStatement();
			stView = (Statement) conne.createStatement();
			stFunc = (Statement) conne.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Profile getProfilesInformation(){
		String q = "SELECT * FROM personal WHERE username='"+u+"';";
		String q2 = "SELECT * FROM registration WHERE nickname='"+u+"';";
		Profile resultObject = new Profile();
		
		try {
			ResultSet rs = sta.executeQuery(q);
			ResultSet rs2 = sta2.executeQuery(q2);
			
			while(rs.next()){
				resultObject.setInterests(rs.getString("description"));
				resultObject.setLanguages(rs.getString("languages"));
				resultObject.setReligion(rs.getString("religions"));
				resultObject.setBirthdate(rs.getDate("birthdate"));
			}
			
			while(rs2.next()){
				resultObject.setAdressEmail(rs2.getString("emailadress"));
				resultObject.setCity(rs2.getString("city"));
				resultObject.setPhone(rs2.getString("mobilephone"));
			}
			return resultObject;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Statistics getStatisticInformation(){
		String qS = "SELECT sendMessages,recievedMessages FROM stats WHERE username='"+u+"';";
		String qG = "SELECT id,registrationDate,lastOnline FROM generalinformation WHERE username='"+u+"';";
		Statistics resStat = new Statistics();
		try {
			ResultSet resS = stStati.executeQuery(qS);
			ResultSet resG = stGene.executeQuery(qG);
			while(resS.next()){
				resStat.setRecievedMessages(resS.getInt("recievedMessages"));
				resStat.setSendMessages(resS.getInt("sendMessages"));
			}
			while(resG.next()){
				resStat.setId(resG.getInt("id"));
				resStat.setRegistrationDate(resG.getDate("registrationDate"));
				resStat.setLastOnline(resG.getDate("lastOnline"));
			}
			return resStat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Statistics getStatisticInformationSec(String un){
		String qS = "SELECT sendMessages,recievedMessages FROM stats WHERE username='"+un+"';";
		String qG = "SELECT id,registrationDate,lastOnline FROM generalinformation WHERE username='"+un+"';";
		Statistics resStat = new Statistics();
		try {
			ResultSet resS = stStati.executeQuery(qS);
			ResultSet resG = stGene.executeQuery(qG);
			while(resS.next()){
				resStat.setRecievedMessages(resS.getInt("recievedMessages"));
				resStat.setSendMessages(resS.getInt("sendMessages"));
			}
			while(resG.next()){
				resStat.setId(resG.getInt("id"));
				resStat.setRegistrationDate(resG.getDate("registrationDate"));
				resStat.setLastOnline(resG.getDate("lastOnline"));
			}
			return resStat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int howManyRegistered(){
		String q = "SELECT * FROM from_general;";
		try{
			ResultSet rsv = stView.executeQuery(q);
			int c = 0;
			while (rsv.next()){
				++c;
			}
			return c;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int howManyTheSameName(String nn){
		String q="SELECT `theSameName`('"+nn+"') AS `theSameName`;";
		
		try{
			ResultSet rsv = stView.executeQuery(q);
			int c = 0;
			while (rsv.next()){
				c = rsv.getInt("theSameName");
			}
			return c;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	public int crative(){
		String q="SELECT name FROM registration UNION SELECT nickname FROM userlogin GROUP BY emailadress;";
		
		try{
			ResultSet rsv = stView.executeQuery(q);
			int c = 0;
			while (rsv.next()){
				c++;
			}
			return c;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int maxId(){
		String q = "SELECT MAX(id) FROM generalinformation";
		try{
			ResultSet rsv = stView.executeQuery(q);
			int c = 0;
			while (rsv.next()){
				c=rsv.getInt("MAX(id)");
			}
			return c;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int minId(){
		String q = "SELECT MIN(id) FROM generalinformation";
		try{
			ResultSet rsv = stView.executeQuery(q);
			int c = 0;
			while (rsv.next()){
				c=rsv.getInt("MIN(id)");
			}
			return c;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}
