package com.twitterclone.squeaker.controller;
import com.twitterclone.squeaker.service.ApiResponse;
import com.twitterclone.squeaker.service.FollowService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@AllArgsConstructor(onConstructor_ = @Autowired)
public class FollowController {

    private FollowService followService;
    private ApiResponse apiResponse;

    @PostMapping("/follow")
    public ResponseEntity<Object> follow(@RequestBody Long squeakerId){
        followService.addFollow(squeakerId);

        return new ResponseEntity(apiResponse.getBodyResponse(), HttpStatus.OK);
    }
}
