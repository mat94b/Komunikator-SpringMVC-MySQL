package database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import containers.InformationHolder;

public class Sending {

	private Connection conne;
	private Statement sta;
	private String mess;
	private String adress;
	private String title;
	
	private void justSendIt(){
		String q = "INSERT INTO messages (sendingUser,recievingUser,messageText,messageTitle,messageDate) values(?,?,?,?,?);";
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
			PreparedStatement r = conne.prepareStatement(q);
			r.setString(1, InformationHolder.actualUsername);
			r.setString(2, adress);
			System.out.println(adress);
			r.setString(3, mess);
			r.setString(4, title);
			r.setDate(5, sqlDate);
			r.execute();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Sending(String adress, String mess, String title) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conne = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/messagesdb", "root", "");
			sta = (Statement) conne.createStatement();
			this.mess = mess;
			this.adress = adress;
			this.title = title;
			this.justSendIt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
