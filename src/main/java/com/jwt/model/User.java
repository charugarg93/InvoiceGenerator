package com.jwt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="USER")
public class User  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Size(min=1, max=90, message = "Please provide proper name")
	@NotNull(message = "Name cannot be empty")
	@Column(name = "NAME")
	private String name;

	@Size(min=3, message="Please provide proper Email")
	@NotNull(message = "Email cannot be empty")
	@Email(message="Please provide proper Email")
	@Column(name = "EMAIL", unique=true, nullable = false)
	private String email;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email +/* ", dueDate=" + dueDate +*/ "]";
	}

}
