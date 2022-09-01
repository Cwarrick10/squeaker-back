package com.twitterclone.squeaker.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    Set<Squeak> squeaks;
    //need to input OneToMany for comments
}
