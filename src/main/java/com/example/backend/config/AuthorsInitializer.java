package com.example.backend.config;

import com.example.backend.domain.Author;
import com.example.backend.domain.Country;
import com.example.backend.repository.AuthorRepository;
import com.example.backend.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class AuthorsInitializer {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorsInitializer(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    void init(){
        Country country1=new Country("England","Europe");
        Country country2=new Country("Russia","Europe/Asia");
        Country country3=new Country("America","North America");
        countryRepository.saveAll(List.of(country1,country2,country3));
        Author author1=new Author("William ","Shakespeare",country1);
        Author author2=new Author("Leo  ","Tolstoy",country2);
        Author author3=new Author("Stephen  ","King",country3);
        authorRepository.saveAll(List.of(author1,author2,author3));

    }
}
