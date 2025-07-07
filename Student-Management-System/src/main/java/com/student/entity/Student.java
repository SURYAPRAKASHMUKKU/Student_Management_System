package com.student.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stuId;
    private String stuName;
    private String stuEmail;
    private Long stuMobile;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public Long getStuMobile() {
        return stuMobile;
    }

    public void setStuMobile(Long stuMobile) {
        this.stuMobile = stuMobile;
    }
}


