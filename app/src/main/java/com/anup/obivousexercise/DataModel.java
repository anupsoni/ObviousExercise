package com.anup.obivousexercise;

//data model for recylerview
public class DataModel {
    String title = "";   // title of the note
    String content = "";  // content of the notes
    String timestamp = "";  // creation time of notes

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
