
package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import containers.InformationHolder;

public class ContactReturner {

	private String userNickname;
	private Connection conne;
	private Statement sta;
	private Statement sta2;
	private Statement sta3;
	private Statement staP;
	private Statement staPr;

	public ContactReturner(String userNickname) {
		this.userNickname = userNickname;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conne = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/komunikatordb", "root", "");
			sta = (Statement) conne.createStatement();
			sta2 = (Statement) conne.createStatement();
			sta3 = (Statement) conne.createStatement();
			staP = (Statement) conne.createStatement();
			staPr = (Statement) conne.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ContactList[] contactListReturner() {
		String query = "SELECT * FROM contactlist WHERE person='" + userNickname + "';";
		ContactList[] cl, clHelper;

		try {
			ResultSet rs = sta.executeQuery(query);
			cl = new ContactList[0];
			while (rs.next()) {
				clHelper = Arrays.copyOf(cl, (cl.length)+1);
				cl = Arrays.copyOf(clHelper, clHelper.length);
				ContactList nObj = new ContactList();
				ResultSet rs2 = sta2.executeQuery("SELECT * FROM registration WHERE nickname='" + rs.getString("contactPerson")+ "';");
				while(rs2.next()){
					nObj.setEm(rs2.getString("emailadress"));
					nObj.setName(rs2.getString("name"));
					nObj.setSurname(rs2.getString("lastname"));
					nObj.setTel(rs2.getString("mobilephone"));
				}
				nObj.setNickname(rs.getString("contactPerson"));
				nObj.setAddDay(rs.getDate("addDate"));
				nObj.setIsFavorite(rs.getInt("favorite"));
				cl[cl.length-1] = nObj;
			}
			InformationHolder.actualContactAmound = cl.length;
			System.out.println(cl.length);
			return cl;
		} catch (SQLException e) {
			System.out.println("WYJATEK");
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ContactList[] contactListReturnerProcedure(String fu) {
		String query = "call findPersonP('" + fu + "');";
		ContactList[] cl, clHelper;

		try {
			ResultSet rs = staP.executeQuery(query);
			cl = new ContactList[0];
			while (rs.next()) {
				clHelper = Arrays.copyOf(cl, (cl.length)+1);
				cl = Arrays.copyOf(clHelper, clHelper.length);
				ContactList nObj = new ContactList();
				ResultSet rs2 = staPr.executeQuery("call registrationProcedure('" + rs.getString("contactPerson")+ "');");
				while(rs2.next()){
					nObj.setEm(rs2.getString("emailadress"));
					nObj.setName(rs2.getString("name"));
					nObj.setSurname(rs2.getString("lastname"));
					nObj.setTel(rs2.getString("mobilephone"));
				}
				nObj.setNickname(rs.getString("contactPerson"));
				nObj.setAddDay(rs.getDate("addDate"));
				nObj.setIsFavorite(rs.getInt("favorite"));
				cl[cl.length-1] = nObj;
			}
			InformationHolder.actualContactAmound = cl.length;
			System.out.println(cl.length);
			return cl;
		} catch (SQLException e) {
			System.out.println("WYJATEK");
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean isExist(){
		String query = "SELECT * FROM userlogin WHERE nickname='" + userNickname + "';";
		try{
			ResultSet result = sta3.executeQuery(query);
			int checker = 0;
			while(result.next()){
				++checker;
			}
			if (checker!=0) return true;
			else return false;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
