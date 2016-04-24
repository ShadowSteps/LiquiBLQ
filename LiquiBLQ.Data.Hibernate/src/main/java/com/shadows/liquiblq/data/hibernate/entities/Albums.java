package com.shadows.liquiblq.data.hibernate.entities;

// default package
// Generated 09-Oct-2015 13:21:36 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Album generated by hbm2java
 */
@Entity
@Table(name = "album")
public class Albums implements java.io.Serializable {

    private UUID id;
    private Date date;
    private String name;
    public Albums() {
    }

    public Albums(UUID id, Date date, String name) {
            this.id = id;
            this.date = date;
            this.name = name;
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "uuid")
    @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
    public UUID getId() {
            return this.id;
    }

    public void setId(UUID id) {
            this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = true, length = 29)
    public Date getDate() {
            return this.date;
    }

    public void setDate(Date date) {
            this.date = date;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
            return this.name;
    }

    public void setName(String name) {
            this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.date);
        hash = 47 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Albums other = (Albums) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

	
}
