package com.project.fleetapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.JobTitle;
import com.project.fleetapp.repositories.JobTitleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobTitleService {
	
	private final JobTitleRepository jobTitleRepository;

	/*
	 * Return All JobTitle
	 */
	@Transactional
	public List<JobTitle> getAll() {
		return jobTitleRepository.findAll();
	}

	/*
	 * add a new JobTitle
	 */
	@Transactional
	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}

	/*
	 * find JobTitle by id
	 */
	@Transactional
	public JobTitle findById(Long id) {
		JobTitle jobTitle = jobTitleRepository.findById(id)
				.orElseThrow(() -> new FleetappException("jobTitle not found"));

		return jobTitle;
	}

	/*
	 * update JobTitle by id
	 */
	@Transactional
	public void update(JobTitle jobTitle) {

		jobTitleRepository.save(jobTitle);
	}

	/*
	 * delete JobTitle by id
	 */
	@Transactional
	public void delete(Long id) {
		jobTitleRepository.deleteById(id);
	}
}
