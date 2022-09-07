package com.twitterclone.squeaker.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Entity
@Data
@Table(name = "squeak")
public class Squeak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "postedAt")
    LocalDateTime postedAt;

    @Column(name = "content")
    String content;

    @Column(name = "image")
    String image;

    @ManyToOne
    Squeaker squeaker;
    @OneToMany(mappedBy = "squeak")
    Set<Comment> comments;
}
