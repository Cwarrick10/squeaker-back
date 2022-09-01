package com.twitterclone.squeaker.controller;

import com.twitterclone.squeaker.repository.entity.Comment;
import com.twitterclone.squeaker.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> findAll() {
        return new ResponseEntity<>(commentService.findAllComments(), HttpStatus.OK);
    }
}
