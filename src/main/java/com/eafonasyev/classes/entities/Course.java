package com.eafonasyev.classes.entities;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_gen")
    @SequenceGenerator(name = "id_gen",sequenceName = "courses_seq")
    private int id;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "INSTRACTOR_ID")
    private Long instracrorId;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
               CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "INSTRACTOR_ID",insertable = false,updatable = false)
    private Instractor instractor;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public Course(String title, Long instracrorId) {
        this.title = title;
        this.instracrorId = instracrorId;
    }
    public Course(int id, String title, Long instracrorId) {
        this.id = id;
        this.title = title;
        this.instracrorId = instracrorId;
    }


    public Instractor getInstractor() {
        return instractor;
    }

    public void setInstractor(Instractor instractor) {
        this.instractor = instractor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Long getInstracrorId() {
        return instracrorId;
    }

    public void setInstracrorId(Long instracrorId) {
        this.instracrorId = instracrorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (title != null ? !title.equals(course.title) : course.title != null) return false;
        if (instracrorId != null ? !instracrorId.equals(course.instracrorId) : course.instracrorId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (instracrorId != null ? instracrorId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
