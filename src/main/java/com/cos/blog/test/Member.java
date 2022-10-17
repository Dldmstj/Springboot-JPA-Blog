package com.cos.blog.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
	private int id;
	private String userName;
	private String pw;
	private String eMail;
	
	@Builder
	public Member(int id, String userName, String pw, String eMail) {
		this.id = id;
		this.userName = userName;
		this.pw = pw;
		this.eMail = eMail;
	}
	
	
}
