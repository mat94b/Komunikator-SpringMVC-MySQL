package database;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DeleteAll {

	private String userNickname;
	private Connection conne;
	private Connection conne2;
	private Statement sta;
	private Statement sta2;
	private Statement sta3;

	public DeleteAll(String userNickname) {
		this.userNickname = userNickname;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conne = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/komunikatordb", "root", "");
			conne2 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/messagesdb", "root", "");
			sta = (Statement) conne.createStatement();
			String q2 ="DELETE FROM personal WHERE username='"+userNickname+"';";
			String q3 ="DELETE FROM messages WHERE recievingUser='"+userNickname+"';";
			String q4 ="DELETE FROM userlogin WHERE nickname='"+userNickname+"';";
			java.sql.PreparedStatement ps2 =conne.prepareStatement(q2);
			java.sql.PreparedStatement ps3 =conne2.prepareStatement(q3);
			java.sql.PreparedStatement ps4 =conne.prepareStatement(q4);
			ps2.execute();
			ps3.execute();
			ps4.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
