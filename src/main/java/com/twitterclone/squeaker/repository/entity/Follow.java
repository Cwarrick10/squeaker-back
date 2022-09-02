package com.twitterclone.squeaker.repository.entity;
import lombok.Data;
import javax.persistence.*;
@Entity
@Data
@Table(name = "follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "userFollowed")
    Squeaker userFollowed;

    @ManyToOne
    @JoinColumn(name = "userFollower")
    Squeaker userFollower;
}
