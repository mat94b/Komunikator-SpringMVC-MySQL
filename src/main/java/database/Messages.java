package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import containers.MessageHolder;

public class Messages {
	
	
	private String userNickname;
	private Connection conne;
	private Statement sta;
	private Statement sta2;
	private Statement staFullText;
	private Statement staFullText2;

	public Messages(String userNickname) {
		this.userNickname = userNickname;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conne = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/messagesdb", "root", "");
			sta = (Statement) conne.createStatement();
			sta2 = (Statement) conne.createStatement();
			staFullText = (Statement) conne.createStatement();
			staFullText2 = (Statement) conne.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public MessageHolder[] messagesReturner(){	
		String q = "SELECT * FROM messages WHERE recievingUser = '"+userNickname+"' ORDER BY messageDate;";
		try {
			ResultSet rs = sta.executeQuery(q);
			ResultSet rs2 = sta2.executeQuery(q);
			int c = 0;
			while (rs.next()){
				c++;
			}
			MessageHolder[] mh = new MessageHolder[c];
			MessageHolder myObject;
			c = 0;
			while (rs2.next()){
				myObject = new MessageHolder();
				myObject.setMessageDate(rs2.getDate("messageDate"));
				myObject.setMessageText(rs2.getString("messageText"));
				myObject.setMessageTitle(rs2.getString("messageTitle"));
				myObject.setSendingUser(rs2.getString("sendingUser"));
				mh[c] = myObject;
				++c;
			}
			return mh;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public MessageHolder[] fullTextReturner(String key){
		String qu = "SELECT * FROM messages WHERE MATCH(messageText) AGAINST('"+key+"') LIMIT 100;";
		try{
			ResultSet rs = staFullText.executeQuery(qu);
			ResultSet rs2 = staFullText2.executeQuery(qu);
			int c = 0;
			while (rs.next()){
				c++;
			}
			MessageHolder[] mh = new MessageHolder[c];
			MessageHolder myObject;
			c = 0;
			while (rs2.next()){
				myObject = new MessageHolder();
				myObject.setMessageDate(rs2.getDate("messageDate"));
				myObject.setMessageText(rs2.getString("messageText"));
				myObject.setMessageTitle(rs2.getString("messageTitle"));
				myObject.setSendingUser(rs2.getString("sendingUser"));
				mh[c] = myObject;
				++c;
			}
			return mh;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	

}
