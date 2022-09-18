package com.eafonasyev.classes.entities;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "INSTRACTOR")
public class Instractor {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_gen")
    @SequenceGenerator(name = "id_gen",sequenceName = "instractor_seq")
    private int id;
    @Basic
    @Column(name = "FIRST_NAME", nullable = true, length = 200)
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME", nullable = true, length = 200)
    private String lastName;
    @OneToOne(cascade = {CascadeType.DETACH,
                         CascadeType.MERGE,
                         CascadeType.PERSIST,
                         CascadeType.REFRESH})
    @JoinColumn(name = "INSTRACTOR_DETAIL_ID")
    private InstractorDetail instractorDetail;

    @OneToMany(mappedBy = "instractor",
               cascade = {CascadeType.DETACH,CascadeType.MERGE,
                                                 CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Instractor() {
    }

    public Instractor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Instractor(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public InstractorDetail getInstractorDetail() {
        return instractorDetail;
    }

    public void setInstractorDetail(InstractorDetail instractorDetail) {
        this.instractorDetail = instractorDetail;
    }

    @Override
    public String toString() {
        return "Instractor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", instractorDetail=" + instractorDetail +
                '}';
    }
    public void add(Course course){
        if(courses==null){
            courses = new ArrayList<Course>();
        }
        courses.add(course);
        course.setInstractor(this);
    }
}


