package com.java8.optional;

import java.util.List;
import java.util.Optional;

public class Book {
    private List<Chapter> chapters;

    public Book(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public Optional<Chapter> getChapter(int index) {
        return Optional.ofNullable(chapters.get(index));
    }
}
