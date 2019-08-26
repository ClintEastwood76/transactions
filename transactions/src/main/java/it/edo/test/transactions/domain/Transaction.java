package it.edo.test.transactions.domain;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Transaction {

	@Id
	public ObjectId _id;
	
	private Date date;
	private String desc;
	private String owner;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// ObjectId needs to be converted to string
	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Transaction [_id=" + _id + ", date=" + date + ", desc=" + desc + ", owner=" + owner + "]";
	}

	public Transaction(Date date, String desc, String owner) {
		super();
		this.date = date;
		this.desc = desc;
		this.owner = owner;
	}
	
	public Transaction() {
		super();
	}
	

	
}
