package com.example.model;


import jakarta.validation.constraints.*;

public class Book {

    private Long id;

    @NotBlank(message = "Ko được để trống")
    @Size(min = 3, max = 100, message = "tên từ 3-100 kí tự")
    private String title;

    @NotBlank(message = "ko được để trống")
    private String author;

    @Max(value = 2, message = "số lượng phải >= 0")
    @NotBlank(message = "ko được để trống")
    private Integer quantity;

    @NotBlank(message = "ko được để trống")
    private String coverImage;

    public Book() {
    }

    public Book(Long id, String title, String author, Integer quantity, String coverImage) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.coverImage = coverImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}
