package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/movies")
public class MovieController {

	

	
	@Autowired
	MovieService movieService;


	
	
	@PostMapping("/add-movie")
	public ResponseEntity<String> addMovie(@RequestBody Movie movie){
		System.out.println("hrllrprprp");
		return new ResponseEntity<>(movieService.addMovie(movie),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/add-director")
	public ResponseEntity<String> addDirector(@RequestBody Director director){
		return new ResponseEntity<>(movieService.addDirector(director),HttpStatus.CREATED);
	}
	
	@PutMapping("/add-movie-director-pair")
	public ResponseEntity<String> addMovieDirectorPair(@RequestParam String director,@RequestParam String movie){
		return new ResponseEntity<>(movieService.addMovieDirectorPair(director, movie),HttpStatus.OK);
	}
	
	@GetMapping("/get-movie-by-name/{name}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
		//System.out.println(name);
		return  ResponseEntity.ok(movieService.getMovieByName(name));
	}
	
	@GetMapping("/get-director-by-name/{name}")
	public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
		return new ResponseEntity<>(movieService.getDirectorByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/get-movies-by-director-name/{director}")
	public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
		return new ResponseEntity<>(movieService.getMoviesByDirectorName(director),HttpStatus.OK);
	}
	
	
	@GetMapping("/get-all-movies")
	public ResponseEntity<List<String>> findAllMovies(){
		return ResponseEntity.ok(movieService.findAllMovies());
	}
	
	@DeleteMapping("/delete-director-by-name")
	public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
		return new ResponseEntity<>(movieService.deleteDirectorByName(director),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-all-directors")
	public ResponseEntity<String> deleteAllDirectors(  ){
		return new ResponseEntity<>(movieService.deleteAllDirectors(),HttpStatus.OK);
	}
	
	
	
	
	
	
}
