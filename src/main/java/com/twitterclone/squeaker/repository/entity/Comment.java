package com.twitterclone.squeaker.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "content")
    String content;

    @Column(name = "postedAt")
    LocalDateTime postedAt;

    @ManyToOne
    Squeak squeak;

    @ManyToOne
    Squeaker author;
}
