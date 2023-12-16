package com.Facebook.FaceBookRest.Models;

public class Post {
    int ID;

    String Title;
    String Description;

    public Post(){
        ID = 0;
        Title = "No Title";
        Description = "No Description";
    }

    public Post(int ID, String title, String description) {
        this.ID = ID;
        Title = title;
        Description = description;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
