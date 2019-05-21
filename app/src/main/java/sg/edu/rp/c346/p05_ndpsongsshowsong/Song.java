package sg.edu.rp.c346.p05_ndpsongsshowsong;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String title;
    private String singers;
    private int year;
    private int star;

    public Song(int id, String title, String singers, int year, int star) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.star = star;
    }
    public Song(String title, String singers, int year, int star) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.star = star;
    }

    public int getId() {
        return id;
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

    public int getStar() {
        return star;
    }
}
