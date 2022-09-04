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
    @Column(name = "username", unique = true)
    String username;
    @Column(name = "password")
    String password;
    @OneToMany(mappedBy = "squeaker")
    @JsonIgnore
    Set<Squeak> squeaks;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "profile_pic")
    String profileImg;
}
