package com.domain.services;

import com.domain.models.entities.Book;
import com.domain.models.repos.BookRepo;

import javax.persistence.EntityManager;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private BookRepo bookRepo;

    public Book create(Book book){
        return bookRepo.save(book);
    }

    public void remove(Long id){
        bookRepo.deleteById(id);
    }

    public Iterable<Book> findAll(boolean isDeleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedBookFilter");
        filter.setParameter("isDeleted", isDeleted);
        Iterable<Book> books = bookRepo.findAll();
        session.disableFilter("deletedBookFilter");
        return books;
    }
}
