package com.eafonasyev.classes.entities;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_gen")
    @SequenceGenerator(name = "id_gen",sequenceName = "review_seq")
    private int id;
    @Basic
    @Column(name = "NOTE", nullable = true, length = 500)
    private String note;


    public Review() {
    }

    public Review(String note) {
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != review.id) return false;
        if (note != null ? !note.equals(review.note) : review.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", note='" + note + '\'' +
                '}';
    }
}
