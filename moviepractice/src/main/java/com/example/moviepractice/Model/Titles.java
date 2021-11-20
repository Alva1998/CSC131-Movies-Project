package com.example.moviepractice.Model;

public class Titles {
    private String json;

    public Titles (String json){
        this.json = json;
    }

    public String getTitles () { return json;}
    public void setTitles (String json) { this.json = json; }
}
