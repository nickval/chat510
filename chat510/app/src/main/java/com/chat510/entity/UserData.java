package com.chat510.entity;

import java.util.Date;

/**
 * Created by MoNyA on 23.12.2014.
 */
public class UserData {

    private String name;
    private String surname;
    private long phone;
    private String country;
    private String city;
    private String business;
    private Date birthDate;
    private String avatarLink;

    public UserData(String name, String surname, long phone, String country, String city, String business, Date birthDate, String avatarLink) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.business = business;
        this.birthDate = birthDate;
        this.avatarLink = avatarLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }
}
