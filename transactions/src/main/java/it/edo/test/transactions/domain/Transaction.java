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
	private Float amount;
	private Integer numTickets;
	private ObjectId _shopId;
	private Shop shop;

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

	public ObjectId get_shopId() {
		return _shopId;
	}

	public void set_shopId(ObjectId _shopId) {
		this._shopId = _shopId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Integer getNumTickets() {
		return numTickets;
	}

	public void setNumTickets(Integer numTickets) {
		this.numTickets = numTickets;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Transaction [_id=" + _id + ", date=" + date + ", desc=" + desc + ", owner=" + owner + ", amount="
				+ amount + ", numTickets=" + numTickets + ", _shopId=" + _shopId + ", shop=" + shop + "]";
	}

	
	
}
