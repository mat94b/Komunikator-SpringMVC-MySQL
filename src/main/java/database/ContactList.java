package database;

import java.sql.Date;
import java.util.GregorianCalendar;

public class ContactList {

	private String name;
	private String surname;
	private String nickname;
	private int isFavorite;
	private String em;
	private String tel;
	private Date addDay;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(int isFavorite) {
		this.isFavorite = isFavorite;
	}
	public String getEm() {
		return em;
	}
	public void setEm(String em) {
		this.em = em;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getAddDay() {
		return addDay;
	}
	public void setAddDay(Date addDay) {
		this.addDay = addDay;
	}
}
