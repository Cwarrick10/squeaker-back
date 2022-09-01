package com.twitterclone.squeaker.service;

import com.twitterclone.squeaker.repository.CommentRepository;
import com.twitterclone.squeaker.repository.SqueakRepository;
import com.twitterclone.squeaker.repository.entity.Comment;
import com.twitterclone.squeaker.repository.entity.Squeak;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CommentService {

    private final CommentRepository commentRepository;
    private final SqueakRepository squeakRepository;

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> findCommentsBySqueak(Long id) {
        Optional<Squeak> squeak = squeakRepository.findById(id);
        return commentRepository.findAllBySqueakOrderById(squeak);
    }
}
