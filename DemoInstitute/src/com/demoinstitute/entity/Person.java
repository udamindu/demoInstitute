/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demoinstitute.entity;

import javax.persistence.*;

/**
 *
 * @author Arunalu Hasakelum
 */

@Entity(name = "PERSON_TAB")
@Table(name = "PERSON_TAB")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    
    private int id;
    private String nicNo;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String age;
    private Address address;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(unique = true , name = "NIC_NO")
    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }
    
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name = "DATE_OF_BIRTH")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    @Transient
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Override
    public String toString(){
                return "NIC No : "+getNicNo()+
                "\nFull Name : "+getFirstName() + " " + getLastName()+
                "\nDate of Birth : "+getDateOfBirth()+
                "\n"+getAddress().toString();
    }
    
}
