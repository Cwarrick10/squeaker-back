package com.twitterclone.squeaker.service;

import com.twitterclone.squeaker.repository.CommentRepository;
import com.twitterclone.squeaker.repository.SqueakRepository;
import com.twitterclone.squeaker.repository.SqueakerRepository;
import com.twitterclone.squeaker.repository.entity.Comment;
import com.twitterclone.squeaker.repository.entity.Squeak;
import com.twitterclone.squeaker.repository.entity.Squeaker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CommentService {

    private final CommentRepository commentRepository;
    private final SqueakRepository squeakRepository;
    private final SqueakerRepository squeakerRepository;

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> findCommentsBySqueak(Long id) {
        Squeak squeak = squeakRepository.findSqueakById(id);
        return commentRepository.findAllBySqueakOrderById(squeak);
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
