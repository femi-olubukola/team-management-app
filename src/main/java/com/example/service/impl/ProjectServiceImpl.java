package com.example.service.impl;

import com.example.persistence.repository.IProjectRepository;
import com.example.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectRepository projectRepo;

}
