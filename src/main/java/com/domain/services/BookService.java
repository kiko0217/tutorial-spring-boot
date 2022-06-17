package com.domain.services;

import com.domain.models.entities.Book;
import com.domain.models.repos.BookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    private BookRepo bookRepo;

    public Book create(Book book){
        return bookRepo.save(book);
    }

    public void remove(Long id){
        bookRepo.deleteById(id);
    }

    public Iterable<Book> findAll() {
        return bookRepo.findAll();
    }
}
