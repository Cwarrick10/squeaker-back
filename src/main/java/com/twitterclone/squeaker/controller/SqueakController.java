package com.twitterclone.squeaker.controller;

import com.twitterclone.squeaker.service.SqueakService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/squeak")
public class SqueakController {
    private final SqueakService squeakService;
}
