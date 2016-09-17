/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demoinstitute.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Arunalu Hasakelum
 */

@Entity(name = "STUDENT_TAB")
@Table(name = "STUDENT_TAB")
public class Student extends Person{
    
    private String registrationId;
    private Set<Course> listOfCourses = new HashSet<>();
}
