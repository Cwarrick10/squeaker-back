package com.twitterclone.squeaker.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @Column(name = "postedAtDate")
    LocalDate postedAtDate;

    @Column(name = "postedAtTime")
    LocalTime postedAtTime;

    @Column(name = "content")
    String content;

    @Column(name = "image")
    String image;

    @ManyToOne
    Squeaker squeaker;
    @OneToMany(mappedBy = "squeak")
    Set<Comment> comments;
}
