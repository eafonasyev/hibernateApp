package com.eafonasyev.classes.entities;

import javax.persistence.*;

@Entity
public class Instractor {
    private long id;
    private String firstName;
    private String lastName;
    private InstractorDetail instractorDetailByInstractorId;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instractor that = (Instractor) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "INSTRACTOR_ID", referencedColumnName = "ID")
    public InstractorDetail getInstractorDetailByInstractorId() {
        return instractorDetailByInstractorId;
    }

    public void setInstractorDetailByInstractorId(InstractorDetail instractorDetailByInstractorId) {
        this.instractorDetailByInstractorId = instractorDetailByInstractorId;
    }
}
