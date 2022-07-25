/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproj;

/**
 *
 * @author mateo
 */
public class Movie {
    
    private String movieTitle;
    private String director;
    private int duration;
    private int date;
    private String codeMovie;
    private String movieGenre;
    private String parentalGuide;
    private String protagonist;
    private String stars;

    public Movie() {
    }

    public Movie(String movieTitle, String director, int duration, int date, String codeMovie, String movieGenre,String parentalGuide ,String protagonist ,String stars) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.duration = duration;
        this.date = date;
        this.codeMovie = codeMovie;
        this.movieGenre = movieGenre;
        this.parentalGuide =parentalGuide;
        this.protagonist =protagonist;
        this.stars =stars;
    }

    public String getParentalGuide() {
        return parentalGuide;
    }

    public void setParentalGuide(String parentalGuide) {
        this.parentalGuide = parentalGuide;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(String protagonist) {
        this.protagonist = protagonist;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getCodeMovie() {
        return codeMovie;
    }

    public void setCodeMovie(String codeMovie) {
        this.codeMovie = codeMovie;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    @Override
    public String toString() {
        return movieTitle + "\t" + codeMovie + "\t" + movieGenre +"\t" + director +"\t"+ date + "\t" + duration + "\t"+protagonist+"\t"+stars+"\t"+parentalGuide ; 
    }
     
}
