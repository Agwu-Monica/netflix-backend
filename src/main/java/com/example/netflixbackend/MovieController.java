package com.example.netflixbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*")
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

    // --- ADDED THIS DELETE METHOD ---
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) {
        repository.deleteById(id);
    }
}
