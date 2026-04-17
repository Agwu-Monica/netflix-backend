package com.example.netflixbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
// Allowing your specific frontend URL to access the data
@CrossOrigin(origins = "https://monica-netflix-frontend.onrender.com")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping
    public List<Movie> getMovies() {
        return repository.findAll();
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return repository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) {
        repository.deleteById(id);
    }
}