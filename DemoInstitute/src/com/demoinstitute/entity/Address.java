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

@Entity(name = "ADDRESS_TAB")
@Table(name = "ADDRESS_TAB")
public class Address {
    
    private int id;
    private String houseNo;
    private String roadName;
    private String city;
    private String country;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "HOUSE_NO")
    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
    
    @Column(name = "ROAD_NAME")
    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }
    
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    @Override
    public String toString(){
        return "Address: " +getHouseNo() + ", " + getRoadName() + ", " + getCity() + ", " + getCountry();
    }
    
}
