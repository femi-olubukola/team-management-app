package com.example.service;

import com.example.persistence.model.Project;

import java.util.Optional;

public interface IProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);


}