package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieListManager {
    private Movie[] movies = new Movie[0];
    private int moviesListNumber = 10;

    public MovieListManager(Movie[] movies) {
        this.movies = movies;
    }

    public MovieListManager(Movie[] movies, int moviesListNumber) {
        this.movies = movies;
        this.moviesListNumber = moviesListNumber;
    }

    public int getMoviesListNumber() {
        return moviesListNumber;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public MovieListManager(int i) {

    }


    public void addToList(Movie movie) {

        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;

            movies = tmp;

        }


     public Movie[] pullMovieList() {
        if (movies.length < moviesListNumber) {
            moviesListNumber = movies.length;
        }


        Movie[] list = new Movie[moviesListNumber];
        for (int i = 0; i <moviesListNumber; i++) {
            int index = movies.length - i - 1;
            list[i] = movies[index];
        }
        return list;
    }

}
