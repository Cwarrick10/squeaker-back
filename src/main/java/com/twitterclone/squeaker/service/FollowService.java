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

    public void addFollow(Long currentSqueakerId, Long profileSqueakerId){
        Follow follow = new Follow();
        Squeaker follower = squeakerRepository.getReferenceById(currentSqueakerId);
        Squeaker followed = squeakerRepository.getReferenceById(profileSqueakerId);
        follow.setUserFollowed(followed);
        follow.setUserFollower(follower);
        followRepository.save(follow);
    }
}
