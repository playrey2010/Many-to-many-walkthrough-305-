package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model) {
//        Start of input section
        Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealname("Sandra Mae Bullowski");

        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");

        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);
//        adding a second movie
        movie = new Movie();
        movie.setTitle("Emoji the Sequel");
        movie.setYear(2018);
        movie.setDescription("The sequel emoji movie...");

        movies.add(movie);
//        setting movies to actor
        actor.setMovies(movies);
//        saving actor/actress
        actorRepository.save(actor);
//        End of input section
        model.addAttribute("actors",actorRepository.findAll());
        return "index";
    }
}
