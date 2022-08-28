package com.twitterclone.squeaker.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "squeak")
public class Squeak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "content")
    String content;
//    @Lob
//    byte[] image;
    @ManyToOne
    Squeaker squeaker;
}
