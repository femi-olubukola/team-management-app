package com.example.service.impl;

import com.example.persistence.model.Project;
import com.example.persistence.repository.IProjectRepository;
import com.example.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectRepository projectRepo;

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }
}
