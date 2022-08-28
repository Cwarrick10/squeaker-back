package com.twitterclone.squeaker.repository;

import com.twitterclone.squeaker.repository.entity.Squeak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqueakRepository extends JpaRepository<Squeak, Long> {
}
