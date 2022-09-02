package com.twitterclone.squeaker.service;
import com.twitterclone.squeaker.repository.FollowRepository;
import com.twitterclone.squeaker.repository.SqueakerRepository;
import com.twitterclone.squeaker.repository.entity.Follow;
import com.twitterclone.squeaker.repository.entity.Squeaker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class FollowService {

    private FollowRepository followRepository;
    private SqueakerRepository squeakerRepository;

    public void addFollow(Long squeakerId){
        Follow follow = new Follow();
        Squeaker followed = squeakerRepository.getReferenceById(squeakerId);
        follow.setFollowed(followed);
        followRepository.save(follow);
    }
}
