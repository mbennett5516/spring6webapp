package com.bennett.spring6webapp.service;

import com.bennett.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
