package com.twitterclone.squeaker.repository;

import com.twitterclone.squeaker.repository.entity.Comment;
import com.twitterclone.squeaker.repository.entity.Squeak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllBySqueakOrderById(Optional<Squeak> squeak);
}
