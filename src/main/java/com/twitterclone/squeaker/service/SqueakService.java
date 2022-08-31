package com.twitterclone.squeaker.service;

import com.twitterclone.squeaker.exception.SqueakNotFoundException;
import com.twitterclone.squeaker.exception.SqueakerNotFoundException;
import com.twitterclone.squeaker.repository.SqueakRepository;
import com.twitterclone.squeaker.repository.SqueakerRepository;
import com.twitterclone.squeaker.repository.entity.Squeak;
import com.twitterclone.squeaker.repository.entity.Squeaker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class SqueakService {
    private final SqueakerRepository squeakerRepository;
    private final SqueakRepository squeakRepository;


    public List<Squeak> findAllSqueaks() {
        return squeakRepository.findAll();
    }

    public Squeak findSqueakById(Long id) {
        Optional<Squeak> maybeSqueak = squeakRepository.findById(id);

        if (maybeSqueak.isEmpty()) {
            throw new SqueakNotFoundException(String.format("squeak not found for id %s", id));
        }

        return maybeSqueak.get();
    }

    public List<Squeak> findSqueaksByUsername(String username) {
        Optional<Squeaker> maybeSqueaker = squeakerRepository.findSqueakerByUsername(username);

        if (maybeSqueaker.isEmpty()) {
            throw new SqueakerNotFoundException(String.format("Squeaker not found for username %s", username));
        }

        return squeakRepository.findAllBySqueakerOrderById(maybeSqueaker.get());
    }

    public Squeak saveSqueak(Squeak squeak) {
        return squeakRepository.save(squeak);
    }


    public Squeak updateSqueak (Long id, Squeak squeak) {
        Squeak oldSqueak = findSqueakById(id);

        oldSqueak.setContent(squeak.getContent());

        squeakRepository.save(oldSqueak);

        return oldSqueak;
    }
}
