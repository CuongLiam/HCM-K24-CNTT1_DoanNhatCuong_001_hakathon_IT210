package com.example.service;

import com.example.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    private Long currentId = 1L;

    public List<Book> findAll(){
        return books;
    }

    public void save(Book book){
        book.setId(currentId++);
        books.add(book);
    }

    public Book findById(Long id){
        return books.stream().filter(book -> book.getId().equals(id))
                    .findFirst().orElse(null);
    }

    public void update(Book book){
        Book old = findById(book.getId());

        if (old != null){
            old.setTitle(book.getTitle());
            old.setAuthor(book.getAuthor());
            old.setQuantity(book.getQuantity());
            old.setCoverImage(book.getCoverImage());
        }
    }

    public void delete(Long id) {
        books.removeIf(b -> b.getId().equals(id));
    }

    public List<Book> search(String keyword) {

        if (keyword == null || keyword.isBlank()) {
            return books;
        }

        String lower = keyword.toLowerCase();

        return books.stream()
                .filter(b ->
                        b.getTitle()
                                .toLowerCase()
                                .contains(lower)
                                ||
                                b.getAuthor()
                                        .contains(lower)
                )
                .toList();
    }


}
