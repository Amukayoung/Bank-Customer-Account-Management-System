package com.example.BankAccountManager.Institution;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Institution {
    @Id
    private Long id;
    private String name;
    private String code;

    public Institution() {

    }

    public Institution(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Institution(String name, String code) {
        this.name = name;
        this.code = code;
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

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
