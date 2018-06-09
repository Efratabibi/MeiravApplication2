package com.javahelps.com.javahelps.externaldatabasedemo;

public class Globals {
    private static Globals instance;

    // Global variable
    private String TechName;
    private String TechId;
    private String PatientId;
    private String PatientName;
    private String Test;
    private String IsManager;
    private int Counter;
    // Restrict the constructor from being instantiated
    private Globals(){}

    public void setTechName(String TechName){
        this.TechName=TechName;
    }
    public String getTechName(){
        return this.TechName;
    }

    public void setTechId(String TechId){
        this.TechId=TechId;
    }
    public String getTechId(){
        return this.TechId;
    }

    public void setPatientId(String PatientId){
        this.PatientId=PatientId;
    }
    public String getPatientId(){
        return this.PatientId;
    }

    public void setPatientName(String PatientName){
        this.PatientName=PatientName;
    }
    public String getPatientName(){
        return this.PatientName;
    }

    public void setTest(String Test){
        this.Test=Test;
    }
    public String getTest(){
        return this.Test;
    }

    public void setIsManager(String IsManager){
        this.IsManager=IsManager;
    }
    public String getIsManager(){
        return this.IsManager;
    }

    public void setCounter(int Counter){
        this.Counter=Counter;
    }
    public int getCounter(){
        return this.Counter;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }


}
