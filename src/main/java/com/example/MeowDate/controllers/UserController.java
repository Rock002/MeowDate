package com.example.MeowDate.controllers;

import com.example.MeowDate.models.Photo;
import com.example.MeowDate.models.User;
import com.example.MeowDate.services.PhotoService;
import com.example.MeowDate.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final PhotoService photoService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PhotoService photoService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.photoService = photoService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {
        User user = userService.findByUsername(authentication.getName());

        var photos = photoService.getPhotosByUserId(user.getId());

        List<String> base64Images = new ArrayList<>();
        for (Photo photo : photos) {
            String base64Image = Base64.getEncoder().encodeToString(photo.getBytes());

            if (photo.getBytes() != null && photo.getBytes().length > 0) {
                base64Images.add("data:image/jpeg;base64," + base64Image);
            } else {
                base64Images.add("");
            }
        }

        model.addAttribute("user", user);
        model.addAttribute("photos", photos);
        model.addAttribute("base64Images", base64Images);

        return "profile";
    }

    @PostMapping("/postregistration")
    public String postRegistration(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("USER");
        userService.save(user);

        return "redirect:/login";
    }
}
