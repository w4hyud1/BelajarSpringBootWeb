package com.masthacode.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Complain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 5)
    private Integer id;

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_co ;
    private Integer user_id_co;
    private String user_name_co;

    public Date getDate_co() {
        return date_co;
    }

    public void setDate_co(Date date_co) {
        this.date_co = date_co;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id_co() {
        return user_id_co;
    }

    public void setUser_id_co(Integer user_id_co) {
        this.user_id_co = user_id_co;
    }

    public String getUser_name_co() {
        return user_name_co;
    }

    public void setUser_name_co(String user_name_co) {
        this.user_name_co = user_name_co;
    }
}
