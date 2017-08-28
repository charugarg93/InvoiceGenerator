package com.jwt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ORDER_DETAIL")
public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="due_date")
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	private Date dueDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return dueDate;
	}

	public void setDate(Date date) {
		this.dueDate = date;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", amount=" + amount + ", date=" + dueDate + "]";
	}
}
