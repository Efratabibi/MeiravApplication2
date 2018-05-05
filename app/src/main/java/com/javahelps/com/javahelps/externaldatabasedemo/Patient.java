package com.javahelps.com.javahelps.externaldatabasedemo;

/**
 * Created by Admin on 11/04/2018.
 */

public class Patient {
    private String Id;
    private String FirstName;
    private String ZimonTime;
    private String EnterTime;
    private String Test;
    private String IsActive;
    boolean box;

    public Patient()
    {
    }
    public Patient(String Id,String FirstName,String ZimonTime,String EnterTime,String Test)
    {
        this.Id=Id;
        this.FirstName=FirstName;
        this.ZimonTime=ZimonTime;
        this.EnterTime=EnterTime;
        this.Test=Test;
        this.IsActive=IsActive;
        this.box=box;
    }
    public void setId(String id) {
        this.Id = id;
    }
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    public void setZimonTime(String ZimonTime) {
        this.ZimonTime = ZimonTime;
    }
    public void setEnterTime(String EnterTime) {
        this.EnterTime = EnterTime;
    }
    public void setTest(String Test) {
        this.Test = Test;
    }
    public void setIsActive(String IsActive) {
        this.IsActive = IsActive;
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
    public String getEnterTime() {
        return EnterTime;
    }
    public String getTest() {
        return Test;
    }
    public String getIsActive() {
        return IsActive;
    }
    public boolean getcheckbox() {return box;}
}