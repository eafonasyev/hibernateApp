package com.eafonasyev.classes.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "INSTRACTOR_DETAIL", schema = "SPRINGSTUDENT", catalog = "")
public class InstractorDetail {
    private long id;
    private String utubeChanell;
    private String hobby;
    private Collection<Instractor> instractorsById;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UTUBE_CHANELL")
    public String getUtubeChanell() {
        return utubeChanell;
    }

    public void setUtubeChanell(String utubeChanell) {
        this.utubeChanell = utubeChanell;
    }

    @Basic
    @Column(name = "HOBBY")
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstractorDetail that = (InstractorDetail) o;

        if (id != that.id) return false;
        if (utubeChanell != null ? !utubeChanell.equals(that.utubeChanell) : that.utubeChanell != null) return false;
        if (hobby != null ? !hobby.equals(that.hobby) : that.hobby != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (utubeChanell != null ? utubeChanell.hashCode() : 0);
        result = 31 * result + (hobby != null ? hobby.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "instractorDetailByInstractorId")
    public Collection<Instractor> getInstractorsById() {
        return instractorsById;
    }

    public void setInstractorsById(Collection<Instractor> instractorsById) {
        this.instractorsById = instractorsById;
    }
}
