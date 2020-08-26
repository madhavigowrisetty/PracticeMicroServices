package com.udemy.rest.webservices.udemywebservices.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "This is a User who has id, name and dob details")
public class User {

    private Integer id;
    @ApiModelProperty(notes = "Name should atleast be minimun of 2 characters")
    @Size(min = 2, message = "Name should be atleast 2 characters")
    private String name;
    @Past
    @ApiModelProperty(notes = "Date of birth of the user should be a past date")
    private Date dob;

    public User(Integer id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
