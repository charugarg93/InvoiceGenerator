package com.jwt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="USER")
public class User  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    //@Size(min=3, max=75)
    @Column(name = "NAME")
    private String name;
    
    //@NotEmpty
    @Column(name = "EMAIL", unique=true, nullable = false)
    private String email;

    //@NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "DUE_DATE")
    //@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private Date dueDate;

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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
