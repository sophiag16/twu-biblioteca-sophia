//has information about movie and displays it
package com.tw.biblioteca;

public class Movie {
    private String name;
    private String director;
    private String year;
    private String rating;

    public Movie(String name, String director, String year, String rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public void printInfo() {
        System.out.println(name + "\t" + director + "\t" + year + "\t" + rating);
    }

    @Override
    public boolean equals(Object that) {
        if (!(that instanceof Movie)) {
            return false;
        }
        if(this == that) {
            return true;
        }
        Movie thatMovie = (Movie) that;
        if(this.name.equals(thatMovie.name)) {
            return true;
        }
        return false;
    }
}