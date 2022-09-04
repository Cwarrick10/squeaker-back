package com.twitterclone.squeaker.controller;

import com.twitterclone.squeaker.exception.InvalidPasswordException;
import com.twitterclone.squeaker.exception.SqueakerNotFoundException;
import com.twitterclone.squeaker.repository.entity.Squeaker;
import com.twitterclone.squeaker.service.SqueakerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/squeaker")
public class SqueakerController {
    private final SqueakerService squeakerService;

    @GetMapping("/all")
    public ResponseEntity<List<Squeaker>> findAll() {
        return new ResponseEntity<>(squeakerService.findAllSqueakers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Squeaker> findById(@PathVariable Long id) {
        return new ResponseEntity<>(squeakerService.findSqueakerById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Object> findByUsername(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            return new ResponseEntity<>(squeakerService.findSqueakerByUsername(username, password), HttpStatus.OK);
        } catch (SqueakerNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (InvalidPasswordException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Squeaker> save(@RequestBody Squeaker squeaker) {
        return new ResponseEntity<>(squeakerService.saveSqueaker(squeaker), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Squeaker> update(@PathVariable Long id, @RequestBody Squeaker squeaker) {
        return new ResponseEntity<>(squeakerService.updateSqueaker(id, squeaker), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    private ResponseEntity<Object> deleteSqueaker(@PathVariable("username") String username, @PathVariable("password") String password) {
        try {
            return new ResponseEntity<>(squeakerService.deleteSqueaker(username, password), HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
