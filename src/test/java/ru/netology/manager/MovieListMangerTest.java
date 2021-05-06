package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieListManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class MovieListTest {
    private MovieListManager list = new MovieListManager(9);
    private Movie first = new Movie(1, 1, "Cinema", 1);
    private Movie second = new Movie(2, 1, "Cinema", 1);
    private Movie third = new Movie(3, 1, "Cinema", 1);
    private Movie fourth = new Movie(4, 1, "Cinema", 1);
    private Movie fifth = new Movie(5, 1, "Cinema", 1);
    private Movie sixth = new Movie(6, 1, "Cinema", 1);
    private Movie seventh = new Movie(7, 1, "Cinema", 1);
    private Movie eighth = new Movie(8, 1, "Cinema", 1);
    private Movie ninth = new Movie(9, 1, "Cinema", 1);
    private Movie tenth = new Movie(10, 1, "Cinema", 1);
    private Movie extra = new Movie(11, 1, "Cinema", 1);


    @BeforeEach
    public void setUp() {
        list.addToList(first);
        list.addToList(second);
        list.addToList(third);
        list.addToList(fourth);
        list.addToList(fifth);
        list.addToList(sixth);

    }

    @Test
    public void moviesListUnder10() {
        list.addToList(seventh);
        Movie[] actual = list.pullMovieList();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldCheckAdding() {
        Movie[] actual = list.pullMovieList();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShow10MoviesWith10Inputs() {
        list.addToList(seventh);
        list.addToList(eighth);
        list.addToList(ninth);
        list.addToList(tenth);

        Movie[] actual = list.pullMovieList();
        Movie[] expected = new Movie[]{tenth,ninth,eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldShow10MoviesWith11Inputs() {
        list.addToList(seventh);
        list.addToList(eighth);
        list.addToList(ninth);
        list.addToList(tenth);
        list.addToList(extra);
        Movie[] actual = list.pullMovieList();
        Movie[] expected = new Movie[]{extra, tenth,ninth,eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

}
