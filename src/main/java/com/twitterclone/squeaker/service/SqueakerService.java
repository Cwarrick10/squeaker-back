package com.twitterclone.squeaker.service;

import com.twitterclone.squeaker.repository.entity.Squeaker;
import com.twitterclone.squeaker.exception.InvalidPasswordException;
import com.twitterclone.squeaker.exception.SqueakerNotFoundException;
import com.twitterclone.squeaker.repository.SqueakerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class SqueakerService {
    private final SqueakerRepository squeakerRepository;

    public List<Squeaker> findAllSqueakers() {
        return squeakerRepository.findAll();
    }

    public Squeaker findSqueakerById(Long id) {
        Optional<Squeaker> maybeSqueaker = squeakerRepository.findById(id);

        if (maybeSqueaker.isEmpty()) {
            throw new SqueakerNotFoundException(String.format("Squeaker not found for id %s", id));
        }

        return maybeSqueaker.get();
    }

    public Squeaker findSqueakerByUsername(String username, String password) {
        Optional<Squeaker> maybeSqueaker = squeakerRepository.findSqueakerByUsername(username);

        if (maybeSqueaker.isEmpty()) {
            throw new SqueakerNotFoundException(String.format("Squeaker not found for id %s", username));
        }

        Squeaker squeaker = maybeSqueaker.get();

        if (!squeaker.getPassword().equals(password)) {
            throw new InvalidPasswordException("Username or Password does not match");
        }

        return squeaker;
    }

    public Squeaker saveSqueaker(Squeaker squeaker) {
        return squeakerRepository.save(squeaker);
    }


    public Squeaker updateSqueaker (Long id, Squeaker squeaker) {
        Squeaker oldSqueaker = findSqueakerById(id);

        oldSqueaker.setUsername(squeaker.getUsername());
        oldSqueaker.setPassword(squeaker.getPassword());

        squeakerRepository.save(oldSqueaker);

        return oldSqueaker;
    }
}
