package agh.ii.prinjava.proj2;

import java.util.*;
import java.util.stream.Collectors;

import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.model.Movie;

import agh.ii.prinjava.proj2.utils.Utils;

interface PlayWithMovies {

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    static Set<String> ex01(String director) {
        final Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.orElseThrow().stream()
                .filter(movie -> movie.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the movies (only titles) in which an actor played
     */
    static Set<String> ex02(String actor) {
        final Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.orElseThrow().stream()
                .filter(movie -> movie.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toSet());
    }

    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {
        final Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.orElseThrow().stream()
                .map(m -> Utils.oneToManyByDirector(m))
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(m -> m.directors().get(0),Collectors.counting()));
    }

    /**
     * Returns the 10 directors with the most films on the list
     */
    static Map<String, Long> ex04() {
        Map<String, Long> directors = ex03();
        return directors.entrySet()
                .stream()
                .sorted((d1, d2)-> Long.compare(d2.getValue(), d1.getValue()))
                .limit(10).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    static Map<String, Set<String>> ex05() {
        Map<String, Long> directors = ex04();
        return directors.entrySet()
                .stream().collect(Collectors.toMap(m -> m.getKey(), m -> ex01(m.getKey())));
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {
        final Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.orElseThrow().stream()
                .map(m -> Utils.oneToManyByActor(m))
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(m -> m.actors().get(0),Collectors.counting()));
    }

    /**
     * Returns the 9 actors with the most films on the list
     */
    static Map<String, Long> ex07() {
        Map<String, Long> acrots = ex06();
        return acrots.entrySet()
                .stream()
                .sorted((d1, d2)-> Long.compare(d2.getValue(), d1.getValue()))
                .limit(9).collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static Map<String, Set<String>> ex08() {
        Map<String, Long> actors = ex07();
        return actors.entrySet()
                .stream().collect(Collectors.toMap(m -> m.getKey(), m -> ex02(m.getKey())));
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static Map<String, Long> ex09() {
        final Optional<List<Movie>> movies = ImdbTop250.movies();
        return movies.orElseThrow().stream()
                .map(m -> Utils.oneToManyByActorDuo(m))
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(m -> m.actors().get(0), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((d1, d2)-> Long.compare(d2.getValue(), d1.getValue()))
                .limit(5).collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {
        Map<String, Long> michel = ex09();
        return michel.entrySet()
                .stream()
                .collect(Collectors.toMap(m -> m.getKey(), m -> movieList(m.getKey())));
    }

    /**
     * Returns the list of movies of the two actors
     */
    private static Set<String> movieList(String pair) {
        Set<String> actor1 = ex02(pair.substring(0,pair.indexOf(',')));
        Set<String> actor2 = ex02(pair.substring(pair.indexOf(',')+2));
        return actor1.stream().filter(actor2::contains).collect(Collectors.toSet());
    }

}