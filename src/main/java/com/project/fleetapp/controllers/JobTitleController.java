package com.project.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.fleetapp.models.JobTitle;
import com.project.fleetapp.services.JobTitleService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/jobtitle")
@AllArgsConstructor
public class JobTitleController {
	
	private final JobTitleService jobTitleService;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("jobTitles", jobTitleService.getAll());
		return "jobTitle";
	}
	
	@PostMapping("/addNew")
	public String addNew(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobtitle";
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public JobTitle findById(Long id) {
		return jobTitleService.findById(id);
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
	public String update(JobTitle jobTitle) {
		jobTitleService.update(jobTitle);
		return "redirect:/jobtitle";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		jobTitleService.delete(id);
		return "redirect:/jobtitle";
	}
}
