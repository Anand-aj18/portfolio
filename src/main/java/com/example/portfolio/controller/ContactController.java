package com.example.portfolio.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.portfolio.model.ContactMessage;
import com.example.portfolio.PortfolioService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactController {
    private final PortfolioService service;
    public ContactController(PortfolioService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<?> submit(@RequestBody ContactMessage msg){
        var saved = service.saveContact(msg);
        return ResponseEntity.ok(saved);
    }
}
