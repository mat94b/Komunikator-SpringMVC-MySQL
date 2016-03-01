package containers;

import java.util.Date;

public class Profile {

	
	// 7 pol
	private String adressEmail;
	private String phone;
	private String city;
	private Date birthdate;
	private String religion;
	private String languages;
	private String interests;
	
	public Profile(){
	}
	
	public String getAdressEmail() {
		return adressEmail;
	}
	public void setAdressEmail(String adressEmail) {
		this.adressEmail = adressEmail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
}
