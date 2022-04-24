package com.example.backend.api;

import com.example.backend.domain.Author;
import com.example.backend.domain.Category;

public class BookDTO {
    public Long id;
    public String name;
    public Category category;
    public Long authorId;
    public Integer availableCopies;
}
