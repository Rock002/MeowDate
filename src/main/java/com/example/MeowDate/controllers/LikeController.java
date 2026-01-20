package com.example.MeowDate.controllers;

import com.example.MeowDate.models.Like;
import com.example.MeowDate.models.User;
import com.example.MeowDate.services.LikeService;
import com.example.MeowDate.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LikeController {

    private final LikeService likeService;
    private final UserService userService;

    public LikeController(LikeService likeService, UserService userService) {
        this.likeService = likeService;
        this.userService = userService;
    }

    @PostMapping("/like/{id}")
    public String sendLike(@PathVariable Long id, Authentication authentication) {
        String senderUsername = authentication.getName();
        User sender = userService.findByUsername(senderUsername);
        User receiver = userService.findById(id);

        Like like = new Like(
                sender,
                receiver
        );
        likeService.save(like);

        return "redirect:/";
    }
}
