package com.twitterclone.squeaker.repository;

import com.twitterclone.squeaker.repository.entity.Squeaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SqueakerRepository extends JpaRepository<Squeaker, Long> {
    Optional<Squeaker> findSqueakerByUsername(String username);
}
