package com.twitterclone.squeaker.controller;

import com.twitterclone.squeaker.exception.SqueakerNotFoundException;
import com.twitterclone.squeaker.repository.entity.Squeak;
import com.twitterclone.squeaker.service.SqueakService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/squeak")
public class SqueakController {
    private final SqueakService squeakService;

    @GetMapping("/all")
    public ResponseEntity<List<Squeak>> findAll() {
        return new ResponseEntity<>(squeakService.findAllSqueaks(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Object> findByUsername(@PathVariable String username) {
        try{
            return new ResponseEntity<>(squeakService.findSqueaksByUsername(username), HttpStatus.OK);
        } catch (SqueakerNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Squeak> save(@RequestBody Squeak squeak) {
        squeak.setPostedAt(LocalDateTime.now());
        return new ResponseEntity<>(squeakService.saveSqueak(squeak), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Squeak> update(@PathVariable Long id, @RequestBody Squeak squeak) {
        return new ResponseEntity<>(squeakService.updateSqueak(id, squeak), HttpStatus.OK);
    }
}
