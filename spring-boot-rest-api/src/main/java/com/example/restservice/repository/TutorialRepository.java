package com.example.restservice.repository;

import java.util.List;

import com.example.restservice.models.tutorial.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.models.tutorial.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);

}