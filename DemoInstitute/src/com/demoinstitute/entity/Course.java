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

@Entity(name = "COURSE_TAB")
@Table(name = "COURSE_TAB")
public class Course {
    
    private String courseId;
    private String courseName;
    private double courseDuration;
    private Set<Student> enrolledStudents = new HashSet<>();
    private Lecturer conductedLecturer;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    public Lecturer getConductedLecturer() {
        return conductedLecturer;
    }

    public void setConductedLecturer(Lecturer conductedLecturer) {
        this.conductedLecturer = conductedLecturer;
    }

    @Column(name = "COURSE_DURATION")
    public double getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(double courseDuration) {
        this.courseDuration = courseDuration;
    }

    @Id
    @Column(name = "COURSE_ID")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Column(name = "COURSE_NAME")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @ManyToMany(mappedBy = "listOfCourses", cascade = CascadeType.ALL)
    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
    
    @Override
    public String toString(){
        return getCourseName();
    }
    
}
