package com.anup.obivousexercise;

public class DataModel {
    String title = "";
    String content = "";
    String timestamp = "";

    public DataModel(String title,String content,String timestamp){
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public String getTimestamp(){
        return timestamp;
    }
}
