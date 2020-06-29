package com.googleplay.filmyab;

public class list_Data  {
    private String name;
    private String imgeurl;
    public list_Data(String name,String imgeurl){
        this.name=name;
        this.imgeurl=imgeurl;
    }
    public String getName(){
        return  name;
    }
    public String getImgeurl(){
        return imgeurl;
    }
}
