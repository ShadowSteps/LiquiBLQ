package com.shadows.liquiblq.data.hibernate.entities;

// default package
// Generated 09-Oct-2015 13:21:36 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Artist generated by hbm2java
 */
@Entity
@Table(name = "artist")
public class Artists implements java.io.Serializable {

	private UUID id;
	private String name;
	private String nickname;
	private Date dateofbirth;	

	public Artists() {
	}

	public Artists(UUID id, String name, String nickname,
			Date dateofbirth) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.dateofbirth = dateofbirth;
	}

	

	@Id
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "uuid")
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 55)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "nickname", nullable = false, length = 55)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateofbirth", nullable = false, length = 29)
	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
        
	
}