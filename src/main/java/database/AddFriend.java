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

public class AddFriend {
	
	
	private String aF;
	private Connection conne;
	private Statement sta;
	private Statement sta2;
	private Statement sta3;

	public AddFriend(String addedFriend) {
		this.aF = addedFriend;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conne = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/komunikatordb", "root", "");
			sta = (Statement) conne.createStatement();
			String query = "INSERT INTO contactlist (person, contactPerson, addDate, exchangeMessages, favorite) values(?,?,?,?,?);";
			Calendar c = new GregorianCalendar();
			c.set(Calendar.DAY_OF_YEAR,0);
			c.set(Calendar.MONTH,0);
			c.set(Calendar.DAY_OF_MONTH,0);
			Date d = c.getTime();
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String mD = formatter.format(d);
			Date myDate;
			myDate = formatter.parse(mD);
			java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
			PreparedStatement r = conne.prepareStatement(query);
			r.setString(1, InformationHolder.actualUsername);
			r.setString(2, aF);
			r.setDate(3, sqlDate);
			r.setInt(4, 0);
			r.setInt(5, 0);;
			r.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
