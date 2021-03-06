package com.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;


//@Document(collection = "patientid")

@Entity
@Table(name = "patientid")
public class PatientId {
    @Id
    @Column(name = "pid")
    private String pid;
    //@GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "age")
    private int age = 10;

    public PatientId(String pid) {
        this.pid = pid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
        
}
