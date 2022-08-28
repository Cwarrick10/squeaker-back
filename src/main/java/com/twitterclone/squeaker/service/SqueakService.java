package com.twitterclone.squeaker.service;

import com.twitterclone.squeaker.repository.SqueakRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class SqueakService {
    private final SqueakRepository squeakRepository;
}
