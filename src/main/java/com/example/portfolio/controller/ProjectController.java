package com.example.portfolio.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.portfolio.model.Project;
import com.example.portfolio.PortfolioService;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin
public class ProjectController {
    private final PortfolioService service;
    public ProjectController(PortfolioService service){ this.service = service; }

    @GetMapping
    public List<Project> list(){ return service.getProjects(); }

    @PostMapping
    public Project create(@RequestBody Project p){ return service.saveProject(p); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ service.deleteProject(id); }
}
