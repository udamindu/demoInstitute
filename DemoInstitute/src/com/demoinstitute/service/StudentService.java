/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demoinstitute.service;

import com.demoinstitute.entity.Course;
import com.demoinstitute.entity.Student;
import com.demoinstitute.util.SessionFactoryUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Arunalu Hasakelum
 */
public class StudentService {
    
    public static void listStudents() {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try {
            tx = session.beginTransaction();
            List students = session.createQuery(
                    "select s from STUDENT_TAB as s").list();
            System.out.println("*** Content of the Student Table ***");
            System.out.println("*** Start ***");
            for (Iterator iter = students.iterator(); iter.hasNext();) {
                Student element = (Student) iter.next();
                System.out.println(element);
                System.out.println(" ");
                System.out.println(" ");
            }
            System.out.println("*** End ***");
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
    }

    public static void deleteStudent(Student student) {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.delete(student);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                // throw again the first exception
                throw e;
            }
        }
    }

    public static void createStudent(Student student) {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                // throw again the first exception
                throw e;
            }
        }
    }

    public static void updateStudent(Student student) {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.update(student);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                // throw again the first exception
                throw e;
            }
        }
    }

    public static void listStudentsFollowingCourse(String courseID) {

        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();

        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("select s from STUDENT_TAB as s JOIN s.listOfCourses c where c.courseId =:courseID");
            q.setString("courseID", courseID);

            Student fooStudent = new Student();
            Course fooCourse = new Course();
            fooCourse.setCourseId(courseID);
            fooStudent.getListOfCourses().add(fooCourse);

            q.setProperties(fooStudent);
            List students = q.list();

            if (!students.isEmpty()) {
                System.out.println(" ");
                System.out.println("*** Students who are following course " + courseID + " ***");
                System.out.println("*** Start ***");
                for (Iterator iter = students.iterator(); iter.hasNext();) {
                    Student element = (Student) iter.next();
                    System.out.print("NIC No = " + element.getNicNo());
                    System.out.print(" | ");
                    System.out.print("Registration No = " + element.getRegistrationId());
                    System.out.print(" | ");
                    System.out.print("Full Name = " + element.getFirstName() + " " + element.getLastName());
                    System.out.println(" ");
                    System.out.println(" ");
                }
                System.out.println("*** End ***");
            } else {
                System.out.println(" ");
                System.out.println("*** There are no students enrolled for the Course - " + courseID + " ***");
            }

            tx.commit();

        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                throw e;
            }
        }
    }
}
