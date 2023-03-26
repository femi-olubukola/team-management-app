package com.example.persistence.repository;

import com.example.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private IProjectRepository projectRepository;

    @Test
    public void whenSavingNewProject_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());

        assertThat(projectRepository.save(newProject), is(notNullValue()));
    }

    @Test
    public void givenProject_whenFindByID_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional <Project> retrievedProject = projectRepository.findById(newProject.getId());

        assertThat(retrievedProject.get(), is(equalTo(newProject)));
    }

    @Test
    public void givenProject_whenFindByName_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional <Project> retrievedProject = projectRepository.findByName(newProject.getName());

        assertThat(retrievedProject.get(), is(equalTo(newProject)));
    }

    @Test
    public void givenProject_whenFindByDateCreatedBetween_thenSuccess() {
        Project oldProject = new Project(randomAlphabetic(6), LocalDate.now().minusYears(1));
        projectRepository.save(oldProject);

        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Project newProject1 = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject1);

        List<Project> retrievedProjects = projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));

        assertThat(retrievedProjects, hasItems(newProject, newProject1));
    }
}
