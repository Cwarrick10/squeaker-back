package com.twitterclone.squeaker.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "squeaker")
public class Squeaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @OneToMany(mappedBy = "squeaker")
//    @JsonIgnoreProperties(value = {"squeaks"})
    @JsonIgnore
    Set<Squeak> squeaks;
}
