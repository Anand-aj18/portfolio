package com.example.portfolio;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.portfolio.model.*;

@Service
public class PortfolioService {
    private final ProjectRepository projectRepo;
    private final ContactRepository contactRepo;
    private final AboutRepository aboutRepo;

    public PortfolioService(ProjectRepository projectRepo, ContactRepository contactRepo, AboutRepository aboutRepo){
        this.projectRepo = projectRepo;
        this.contactRepo = contactRepo;
        this.aboutRepo = aboutRepo;
    }
    public List<Project> getProjects(){ return projectRepo.findAll(); }
    public Project saveProject(Project p){ return projectRepo.save(p); }
    public void deleteProject(Long id){ projectRepo.deleteById(id); }
    public ContactMessage saveContact(ContactMessage m){ return contactRepo.save(m); }
    public About getProfile(){ return aboutRepo.findAll().stream().findFirst().orElse(new About("Anand Raj","Java Full Stack Developer","Building microservices and clean frontends.","/assets/avatar.jpg")); }
}
