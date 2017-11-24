/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ag
 */
@Entity
@Table(name = "COURSE")
public class Course {

    private String code;
    private String title;

    public Course() {
    }

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    @Id
    @Column(name = "CODE", nullable = false, length = 4)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "TITLE", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.code);
        hash = 61 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Course{" + "code=" + code + ", title=" + title + '}';
    }

}
