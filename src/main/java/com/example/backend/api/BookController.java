package com.example.backend.api;

import com.example.backend.domain.Author;
import com.example.backend.domain.Book;
import com.example.backend.domain.Category;
import com.example.backend.service.ILibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@CrossOrigin(origins = "http://localhost:3000/")
public class BookController {
    private final ILibraryService libraryService;

    public BookController(ILibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    List<Book> getAll(){
        return libraryService.findAll();
    }
    @GetMapping("/{id}")
    Book getBook(@PathVariable Long id){
        return  libraryService.findBook(id);
    }
    @GetMapping("/categories")
    Category[] getCategories(){
        return Category.values();
    }
    @GetMapping("/authors")
    List<Author> getAuthors(){
        return libraryService.getAuthors();
    }
    @PostMapping("add")
    void addBook(@RequestBody BookDTO book){
        libraryService.addBook(book);
    }
    @DeleteMapping("delete/{id}")
    void deleteBook(@PathVariable Long id){
        libraryService.deleteBook(id);
    }
    @PostMapping("edit")
    void editBook(@RequestBody BookDTO book){
        libraryService.editBook(book);
    }
    @PutMapping("rent/{id}")
    void rentBook(@PathVariable Long id){
        libraryService.rentBook(id);
    }
}
