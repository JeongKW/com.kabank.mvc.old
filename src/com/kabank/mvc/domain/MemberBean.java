package com.kabank.mvc.domain;

public class MemberBean {
	private String id, pw, name, ssn, phone, email, profile, addr;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "회원정보 [ID: " + id + ", PW: " + pw + ", 이름: " + name + ", 주민번호(생년원일-첫째번호): " + ssn + ", 이메일: " + email
				+ ", 전화번호: " + phone + ", 프로필사진: " + profile + ", 주소: " + addr + "]";
	}
}
