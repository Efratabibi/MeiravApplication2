package com.javahelps.com.javahelps.externaldatabasedemo;

/**
 * Created by Admin on 11/04/2018.
 */

public class Patient {
    private String Id;
    private String FirstName;
    private String ZimonTime;
    public Patient()
    {
    }
    public Patient(String Id,String FirstName,String ZimonTime)
    {
        this.Id=Id;
        this.FirstName=FirstName;
        this.ZimonTime=ZimonTime;
    }
    public void setId(String id) {
        this.Id = Id;
    }
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setZimonTime(String ZimonTime) {
        this.ZimonTime = ZimonTime;
    }
    public String getId() {
        return Id;
    }
    public String getZimonTime() {
        return ZimonTime;
    }
    public String getFirstName() {
        return FirstName;
    }
}