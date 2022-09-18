package com.eafonasyev.classes.entities;

import oracle.ucp.proxy.annotation.OnError;

import javax.persistence.*;

@Entity
@Table(name = "INSTRACTOR_DETAIL")
public class InstractorDetail {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
   // @SequenceGenerator(name = "id_Sequence", sequenceName = "INSTRACTOR_DETAILE_SEQ")
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "UTUBE_CHANELL", nullable = true, length = 200)
    private String utubeChanell;
    @Basic
    @Column(name = "HOBBY", nullable = true, length = 200)
    private String hobby;





    @OneToOne(mappedBy = "instractorDetail",
            cascade = {CascadeType.DETACH,
                       CascadeType.MERGE,
                       CascadeType.PERSIST,
                       CascadeType.REFRESH})
    private Instractor instractor;

    public Instractor getInstractor() {
        return instractor;
    }

    public void setInstractor(Instractor instractor) {
        this.instractor = instractor;
    }

    public InstractorDetail() {
    }

    public InstractorDetail(String utubeChanell, String hobby) {
        this.utubeChanell = utubeChanell;
        this.hobby = hobby;
    }

    public InstractorDetail(int id, String utubeChanell, String hobby) {
        this.id = id;
        this.utubeChanell = utubeChanell;
        this.hobby = hobby;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUtubeChanell() {
        return utubeChanell;
    }

    public void setUtubeChanell(String utubeChanell) {
        this.utubeChanell = utubeChanell;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

}
