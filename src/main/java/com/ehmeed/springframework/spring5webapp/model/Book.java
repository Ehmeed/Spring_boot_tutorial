package com.ehmeed.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String publishser;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(){

    }
    public Book(String title, String isbn, String publishser) {
        this.title = title;
        this.isbn = isbn;
        this.publishser = publishser;
    }

    public Book(String title, String isbn, String publishser, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.publishser = publishser;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublishser(String publishser) {
        this.publishser = publishser;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublishser() {
        return publishser;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
