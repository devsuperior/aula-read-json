package com.example.devsuperior.course.entities;

import java.time.Instant;

public class Lesson {

    private Long id;
    private String title;
    private String media;
    // private Instant timestamp;

    public Lesson() {
    }

    // public Lesson(Long id, String title, String media, Instant timestamp) {
    public Lesson(Long id, String title, String media) {
        this.id = id;
        this.title = title;
        this.media = media;
        // this.timestamp = timestamp;
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

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    // public Instant getTimestamp() {
    //     return timestamp;
    // }

    // public void setTimestamp(Instant timestamp) {
    //     this.timestamp = timestamp;
    // }

    @Override
    public String toString() {
        // return "Lesson [id=" + id + ", title=" + title + ", media=" + media + ", timestamp=" + timestamp + "]";
        return "Lesson [id=" + id + ", title=" + title + ", media=" + media + "]";
    }
}
