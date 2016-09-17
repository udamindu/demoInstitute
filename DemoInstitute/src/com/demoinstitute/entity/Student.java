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

@Entity(name = "STUDENT_TAB")
@Table(name = "STUDENT_TAB")
public class Student extends Person{
    
    private String registrationId;
    private Set<Course> listOfCourses = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    //@ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "STUDENT_ENROLLED_COURSES_TAB", 
            joinColumns = {@JoinColumn(name = "STUDENT_ID")}, 
            inverseJoinColumns = {@JoinColumn(name = "COURSE_ID")})
    public Set<Course> getListOfCourses() {
        return listOfCourses;
    }

    public void setListOfCourses(Set<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }

    @Column(name = "REGISTRATION_ID")
    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
    
    @Override
    public String toString() {
        return super.toString() +
                "\nRegistration ID : " + getRegistrationId() +
                "\nCourses : " + getListOfCourses().toString();
    }
}
