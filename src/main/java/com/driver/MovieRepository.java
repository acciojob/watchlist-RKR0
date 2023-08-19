package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	
  //HashMap<directorName,movieName>
	HashMap<String,List<String>> directorsMovies = new HashMap<>();

	HashMap<String,Movie> movies = new HashMap<>();
	
	HashMap<String,Director> directors = new HashMap<>();
	

	public boolean addMovie(Movie movie){
		if(movies.containsKey(movie.getName()))
				return false;
		
		movies.put(movie.getName(),movie);
		return true;
		
	}
	
	public boolean addDirector(Director director){
		if(directors.containsKey(director.getName()))
				return false;
		
		directors.put(director.getName(),director);
		return true;
		
	}
	
	public boolean addMovieDirectorPair(String director,String movie){
		if(directors.containsKey(director) && movies.containsKey(movie)) {
			if(directorsMovies.containsKey(director)) {
				directorsMovies.get(director).add(movie);
			}else {
				directorsMovies.put(director, new ArrayList<>());
				directorsMovies.get(director).add(movie);
			}
			return true;
		}
		return false;	
	}
	
	public Movie getMovieByName(String movie) {
		
		return movies.get(movie);
	}
	
	
	public Director getDirectorByName(String director) {
		
		return directors.getOrDefault(director,null);
	}
	
	
	public List<Movie> getMoviesByDirectorName(String director) {
		List<Movie> ans = new ArrayList<>();
		for(String m:directorsMovies.get(director))
			ans.add(movies.get(m));
		return ans;
	}
	
	
	public List<Movie> findAllMovies() {
		List<Movie> ans = new ArrayList<>();
		for(String m:movies.keySet())
			ans.add(movies.get(m));
		return ans;
	}
	
	public void deleteDirectorByName(String director) {
		for(String m:directorsMovies.get(director))
			movies.remove(m);
		directors.remove(director);
		directorsMovies.remove(director);
	}
	
	public void deleteAllDirectors() {
		for(String d:directors.keySet()) {
		for(String m:directorsMovies.get(d))
			movies.remove(m);
		directors.remove(d);
		directorsMovies.remove(d);
		}
	}
	
	
}
