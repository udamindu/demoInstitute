/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demoinstitute.console;

import com.demoinstitute.entity.Address;
import com.demoinstitute.entity.Course;
import com.demoinstitute.entity.Lecturer;
import com.demoinstitute.entity.Student;
import com.demoinstitute.service.CourseService;
import com.demoinstitute.service.LecturerService;
import com.demoinstitute.service.StudentService;

/**
 *
 * @author Arunalu Hasakelum
 */
public class DemoInstitute {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //-----  09 -----
        Student student1 = new Student();
        student1.setNicNo("927656351V");
        student1.setRegistrationId("DIT-13-M1-0056");
        student1.setFirstName("Jackie");
        student1.setLastName("Chan");
        student1.setDateOfBirth("05/27/1992");

        Address student1Address = new Address();
        student1Address.setHouseNo("65/33");
        student1Address.setRoadName("Kandy Road");
        student1Address.setCity("Malabe");
        student1Address.setCountry("Sri Lanka");

        student1.setAddress(student1Address);

        StudentService.createStudent(student1);

        
        Student student2 = new Student();
        student2.setNicNo("936724590V");
        student2.setRegistrationId("DIT-14-M1-0023");
        student2.setFirstName("Jet");
        student2.setLastName("Li");
        student2.setDateOfBirth("03/12/1993");

        Address student2Address = new Address();
        student2Address.setHouseNo("21/5");
        student2Address.setRoadName("Galle Road");
        student2Address.setCity("Mount Lavinia");
        student2Address.setCountry("Sri Lanka");

        student2.setAddress(student2Address);

        StudentService.createStudent(student2);

        
        Student student3 = new Student();
        student3.setNicNo("854524340V");
        student3.setRegistrationId("DIT-06-M1-0010");
        student3.setFirstName("Adrian");
        student3.setLastName("Monk");
        student3.setDateOfBirth("10/10/1985");

        Address student3Address = new Address();
        student3Address.setHouseNo("29/35");
        student3Address.setRoadName("Kandy Road");
        student3Address.setCity("Peradeniya");
        student3Address.setCountry("Sri Lanka");

        student3.setAddress(student3Address);

        StudentService.createStudent(student3);

        
        Student student4 = new Student();
        student4.setNicNo("903476126V");
        student4.setRegistrationId("DIT-11-M1-0009");
        student4.setFirstName("Patrick");
        student4.setLastName("Jane");
        student4.setDateOfBirth("09/09/1990");

        Address student4Address = new Address();
        student4Address.setHouseNo("11/32");
        student4Address.setRoadName("Galle Road");
        student4Address.setCity("Panadura");
        student4Address.setCountry("Sri Lanka");

        student4.setAddress(student4Address);

        StudentService.createStudent(student4);

        //----- 10 -----
        
        Lecturer lecturer1 = new Lecturer();
        lecturer1.setNicNo("401782987V");
        lecturer1.setSpecialities("Martial Arts");
        lecturer1.setFirstName("Bruce");
        lecturer1.setLastName("Lee");
        lecturer1.setDateOfBirth("11/27/1940");

        Address lecturer1Address = new Address();
        lecturer1Address.setHouseNo("99/99");
        lecturer1Address.setRoadName("Chinatown");
        lecturer1Address.setCity("San Francisco");
        lecturer1Address.setCountry("USA");

        lecturer1.setAddress(lecturer1Address);

        LecturerService.createLecturer(lecturer1);

        
        Lecturer lecturer2 = new Lecturer();
        lecturer2.setNicNo("541084368V");
        lecturer2.setSpecialities("Homicide Detective");
        lecturer2.setFirstName("Sherlock");
        lecturer2.setLastName("Holmes");
        lecturer2.setDateOfBirth("2/22/1950");

        Address lecturer2Address = new Address();
        lecturer2Address.setHouseNo("221B");
        lecturer2Address.setRoadName("Baker Street");
        lecturer2Address.setCity("London");
        lecturer2Address.setCountry("UK");

        lecturer2.setAddress(lecturer2Address);

        LecturerService.createLecturer(lecturer2);
        

        //----- 11 -----
        
        Course course1 = new Course();
        course1.setCourseId("MA-SHKU");
        course1.setCourseName("Shaolin Kung Fu");
        course1.setCourseDuration(100);

        CourseService.createCourse(course1);

        
        Course course2 = new Course();
        course2.setCourseId("MA-WUSH");
        course2.setCourseName("Wushu");
        course2.setCourseDuration(80);

        CourseService.createCourse(course2);

        
        Course course3 = new Course();
        course3.setCourseId("HO-INVE");
        course3.setCourseName("Homicide Investigation");
        course3.setCourseDuration(60);

        CourseService.createCourse(course3);
        

        //***----- 12 -----
        
        course1.setConductedLecturer(lecturer1);
        CourseService.updateCourse(course1);

        course2.setConductedLecturer(lecturer1);
        CourseService.updateCourse(course2);

        course3.setConductedLecturer(lecturer2);
        CourseService.updateCourse(course3);

        //----- 13 -----
        
        student1.getListOfCourses().add(course1);

        student2.getListOfCourses().add(course1);

        student2.getListOfCourses().add(course2);

        student3.getListOfCourses().add(course3);

        student4.getListOfCourses().add(course3);
        
        student4.getListOfCourses().add(course1);

        StudentService.updateStudent(student1);
        StudentService.updateStudent(student2);
        StudentService.updateStudent(student3);
        StudentService.updateStudent(student4);

        //----- 14 -----
        StudentService.listStudentsFollowingCourse("MA-SHKU");

    }
}
