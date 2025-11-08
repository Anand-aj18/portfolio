package com.example.portfolio.controller;

import org.springframework.web.bind.annotation.*;
import com.example.portfolio.model.About;
import com.example.portfolio.PortfolioService;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin
public class ProfileController {
    private final PortfolioService service;
    public ProfileController(PortfolioService service){ this.service = service; }

    @GetMapping
    public About profile(){ return service.getProfile(); }
}
