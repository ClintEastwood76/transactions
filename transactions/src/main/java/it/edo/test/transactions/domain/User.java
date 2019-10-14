package it.edo.test.transactions.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class User {
/*
	id: number;
	username: string;
	password: string;
	firstName: string;
	lastName: string;
	role: Role;
	token?: string;
*/
	
	@Id
	public ObjectId _id;
	
	private String code;

	String username;

	String password;

	String firstName;

	String lastName;

	String token;

	String companyName;

	String companyCode;

	String email;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "User [_id=" + _id + ", code=" + code + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", token=" + token + ", companyName="
				+ companyName + ", companyCode=" + companyCode + ", email=" + email + "]";
	}

	
}
