package sg.edu.c346.id21010771.problemstatementp09;

import java.io.Serializable;

public class Song implements Serializable {

    private int _id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(String title, String singers, int year, int stars) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStars() {
        return stars;
    }

    public void setTitle(String Title){
        this.title = Title;
    }

    public void setSinger(String Singer){
        this.singers = Singer;
    }

    public void setYear(int Year){
        this.year = Year;
    }

    public void setStars(int Stars){
        this.stars = Stars;
    }

    public String toString(){ return "ID: " + _id + ", " + "Title: " + title + ", " + "Singer: " + singers + ", " + "Year: " + year + ", " + "Stars: " + stars; }
}

