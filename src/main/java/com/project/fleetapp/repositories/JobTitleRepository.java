package com.project.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.fleetapp.models.JobTitle;

public interface JobTitleRepository extends JpaRepository<JobTitle, Long> {

}
