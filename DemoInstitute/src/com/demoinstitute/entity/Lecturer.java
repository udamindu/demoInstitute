/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demoinstitute.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Arunalu Hasakelum
 */

@Entity(name = "LECTURER_TAB")
@Table(name = "LECTURER_TAB")
public class Lecturer {
    
    private String specialities;
    private Set<Course> listOfCourses = new HashSet<>();

    @OneToMany(mappedBy = "conductedLecturer", cascade = CascadeType.ALL)
    public Set<Course> getListOfCourses() {
        return listOfCourses;
    }

    public void setListOfCourses(Set<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }

    @Column(name = "SPECIALITIES")
    public String getSpecialities() {
        return specialities;
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }
    
    @Override
    public String toString(){
        return super.toString()
                + "\nSpecialities : " + getSpecialities()
                + "\nCourses : " + getListOfCourses().toString();
    }
    
}
