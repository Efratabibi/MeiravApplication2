package com.javahelps.com.javahelps.externaldatabasedemo;

public class Globals {
    private static Globals instance;

    // Global variable
    private String TechName;
    private String TechId;
    private String PatientId;
    private String Test;
    private String IsManager;
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

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }


}
