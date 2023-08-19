package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieService {



	@Autowired
	MovieRepository movieRepository;
	
	
	

	
	public String addMovie(Movie movie){
		if(movieRepository.addMovie(movie))
		return movie.getName()+" Movie added Successfully!!";
		return "Movie Name already Exists!";		
	}
	
	public String addDirector(Director director){
		if(movieRepository.addDirector(director))
		return "Director "+director.getName()+ " added Successfully!!";
		return "Director Name already Exists!";		
	}
	
	public String addMovieDirectorPair(String director,String movie){
		if(movieRepository.addMovieDirectorPair(director, movie))
			return "Director and Movie Paried Successfully!!";
		return "Director or Movie Name not in  Repository!";		
	}
	
	public Movie getMovieByName(String movie){
		//System.out.println(movieRepository.getMovieByName(movie)+" hello");
		return movieRepository.getMovieByName(movie);
			
		
	}
	
	public Director getDirectorByName(String director){
		
		return movieRepository.getDirectorByName(director);
				
	}
	
	
	public List<Movie> findAllMovies(){
		
		return movieRepository.findAllMovies();
			
		
	}
	
	public List<String> getMoviesByDirectorName(String director){
		
		return movieRepository.getMoviesByDirectorName(director);
			
		
	}
	
	public String deleteDirectorByName(String director){
		
		movieRepository.deleteDirectorByName(director);
		
		return "Movies are Deleted Successfully!";		
	}
	
	
	public String deleteAllDirectors(){
		
		movieRepository.deleteAllDirectors();
		
		return "all Directors are Deleted Successfully!";		
	}
}
