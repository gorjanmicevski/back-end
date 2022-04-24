package com.example.backend.service;

import com.example.backend.api.BookDTO;
import com.example.backend.domain.Author;
import com.example.backend.domain.Book;
import com.example.backend.repository.AuthorRepository;
import com.example.backend.repository.BookRepository;
import com.example.backend.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService implements ILibraryService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;

    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
    }


    @Override
    public void addBook(BookDTO book) {
        authorRepository.findById(book.authorId).ifPresent(author ->
                bookRepository.save(new Book(book.name, book.category, author, book.availableCopies)));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.findById(id).ifPresent(bookRepository::delete);
    }

    @Override
    public void editBook(BookDTO book) {
        bookRepository.findById(book.id).ifPresent(b ->
            authorRepository.findById(book.authorId).ifPresent(author ->
                    {
                        b.setAuthor(author);
                        b.setName(book.name);
                        b.setAvailableCopies(book.availableCopies);
                        b.setCategory(book.category);
                        bookRepository.save(b);
                    }

            ));
    }

    @Override
    public void rentBook(Long id) {
       bookRepository.findById(id).ifPresent(book -> {
            if(book.getAvailableCopies()>0)
            {
                book.setAvailableCopies(book.getAvailableCopies()-1);
                bookRepository.save(book);
            }
        });

    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Book findBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
