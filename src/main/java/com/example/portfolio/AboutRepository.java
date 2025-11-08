package com.example.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.portfolio.model.About;

public interface AboutRepository extends JpaRepository<About, Long> { }
