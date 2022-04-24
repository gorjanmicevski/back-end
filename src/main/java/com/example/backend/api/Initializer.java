package com.example.backend.api;

import com.example.backend.domain.Author;
import com.example.backend.domain.Country;
import com.example.backend.repository.AuthorRepository;
import com.example.backend.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializer {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public Initializer(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    void init(){
        Country c=new Country("continent","continent");
        Author a=new Author("name","surname",c);
        countryRepository.save(c);
        authorRepository.save(a);
    }
}
