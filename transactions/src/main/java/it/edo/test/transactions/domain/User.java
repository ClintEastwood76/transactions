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
	
	String username, password, firstName, lastName, token;

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

	@Override
	public String toString() {
		return "User [_id=" + _id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", token=" + token + "]";
	}

	
}
