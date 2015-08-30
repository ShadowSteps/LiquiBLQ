package com.shadows.liquiblq.data.entitys;
// Generated 29-Aug-2015 23:25:15 by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Sessions generated by hbm2java
 */
@Entity
@Table(name = "sessions")
public class Sessions implements java.io.Serializable {

	private Serializable id;
	private Users users;
	private boolean active;
	private Date dateCreated;

	public Sessions() {
	}

	public Sessions(Serializable id, Users users, boolean active,
			Date dateCreated) {
		this.id = id;
		this.users = users;
		this.active = active;
		this.dateCreated = dateCreated;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Serializable getId() {
		return this.id;
	}

	public void setId(Serializable id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created", nullable = false, length = 29)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}