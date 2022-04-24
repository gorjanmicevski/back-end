package com.example.backend.service;

import com.example.backend.api.BookDTO;
import com.example.backend.domain.Author;
import com.example.backend.domain.Book;

import java.util.List;

public interface ILibraryService {
    void addBook(BookDTO boook);
    void deleteBook(Long id);
    void editBook(BookDTO book);
    void rentBook(Long id);
    List<Book> findAll();
    List<Author> getAuthors();
    Book findBook(Long id);
}
