package com.example.BankAccountManager.Branch;

import com.example.BankAccountManager.Institution.Institution;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Branch {
@Id
    private Long id;
    private  String name;
    private String code;
    private Long institutionID;
    @ManyToOne
    private Institution institution;


    public Branch() {
    }

    public Branch(Long id, String name, String code,Long institutionID) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.institutionID = institutionID;

    }

    public Branch(String name, String code,Long institutionID) {
        this.name = name;
        this.code = code;
        this.institutionID = institutionID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(Long institutionID) {
        this.institutionID = institutionID;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", institutionID='" + institutionID + '\'' +
                '}';
    }
}
