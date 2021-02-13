package model;

public class UserAccount {
	
	private String username;
	private String gender;
	private String career;
	private String birthday;
	private String browser;
	private String password;
	private String photoDirectory;
	
	
	public UserAccount(String username, String password, String photoDirectory, String gender, String career, String birthday, String browser) {

		this.username = username;
		this.password = password;
		this.photoDirectory= photoDirectory;
		this.gender = gender;
		this.career = career;
		this.birthday = birthday;
		this.browser = browser;
	}


	public String getUsername() {
		return username;
	}


	public String getGender() {
		return gender;
	}


	public String getCareer() {
		return career;
	}


	public String getBirthday() {
		return birthday;
	}


	public String getBrowser() {
		return browser;
	}


	public String getPassword() {
		return password;
	}


	public String getPhotoDirectory() {
		return photoDirectory;
	}
	
	
	
	
	

}
