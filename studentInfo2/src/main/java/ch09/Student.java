package ch09;

import java.sql.Date;

//엔티티클래스는 DB와 대응된다. DO라고도 한다.  컬럼명 = 속성
//엔티티클래스에서 import할때는 .sql에 있는걸로.
public class Student {
	private int id;				// id number primary key,
	private String username;	// username varchar2(20),
	private String univ;		// univ varchar2(40),
	private Date birth;			// birth date,          //java.sql 을 import해야합니다.
	private String email;		// email varchar2(40)
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUniv() {
		return univ;
	}
	public void setUniv(String univ) {
		this.univ = univ;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}