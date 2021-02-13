package model;

import java.util.*;

public class Classroom {

	private List<UserAccount> userAccount;
	
	public Classroom() {
		userAccount= new ArrayList<>();
	}
	
	public void addUserAccount(String us, String pas, String dPhoto, String ge, String ca, String bi, String br) {
		userAccount.add(new UserAccount(us, pas, dPhoto, ge, ca, bi , br));
	}
	
	public List<UserAccount> getUserAccount(){
		return userAccount;
	}
}
