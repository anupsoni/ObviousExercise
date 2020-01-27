package com.anup.obivousexercise;

public class DataModel {
    String title = "";
    String content = "";

    public DataModel(String title,String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
}
