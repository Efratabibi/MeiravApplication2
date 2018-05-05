package com.javahelps.com.javahelps.externaldatabasedemo;

public class Globals {
    private static Globals instance;

    // Global variable
    private String tech;
    private String PatientId;
    private String Test;

    // Restrict the constructor from being instantiated
    private Globals(){}

    public void setTech(String tech){
        this.tech=tech;
    }
    public String getTech(){
        return this.tech;
    }

    public void setPatientId(String PatientId){
        this.PatientId=PatientId;
    }
    public String getPatientId(){
        return this.PatientId;
    }

    public void setTest(String tech){
        this.Test=Test;
    }
    public String getTest(){
        return this.Test;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}
