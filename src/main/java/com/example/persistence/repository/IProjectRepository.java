package com.example.persistence.repository;

import com.example.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save (Project project);
}
