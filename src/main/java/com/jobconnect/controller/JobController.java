package com.jobconnect.controller;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jobconnect.service.JobService;
import com.jobconnect.service.UserService;

import jakarta.servlet.http.HttpSession;

import java.util.List;

import com.jobconnect.entity.Application;
import com.jobconnect.service.ApplicationService;
import com.jobconnect.entity.Job;
import com.jobconnect.entity.User;

import org.springframework.ui.Model;


@Controller
public class JobController {
	private final JobService jobService;
	private final ApplicationService applicationService;
	private final UserService userService;
	
	public JobController(JobService jobService,
            ApplicationService applicationService,
            UserService userService) {

this.jobService = jobService;
this.applicationService = applicationService;
this.userService = userService;
}
	

	
	@GetMapping("/jobs")
	public String showJobs(@RequestParam(required=false) String keyword, Model model)
	{
		List<Job> jobs;

		if (keyword == null || keyword.isBlank()) {
		    jobs = jobService.getAllJobs();
		} else {
		    jobs = jobService.searchJobs(keyword);
		}

		model.addAttribute("jobs", jobs);
		model.addAttribute("keyword", keyword);
		return "jobs";
	}
	
	@GetMapping("/jobs/{id}")
	public String showJobDetails(@PathVariable Long id, Model model) {

	    Job job = jobService.getJobById(id);

	    model.addAttribute("job", job);

	    return "job-details";
	}
	
	@GetMapping("/jobs/{id}/apply")
	public String showApplyForm(@PathVariable Long id, Model model) {

	    Job job = jobService.getJobById(id);

	    model.addAttribute("job", job);

	    return "apply";
	}
	
	@PostMapping("/apply")
	public String submitApplication(Application application) {

	    applicationService.saveApplication(application);

	    return "redirect:/jobs";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegisterForm() {
	    return "register";
	}

	@PostMapping("/register")
	public String registerUser(User user) {

	    userService.saveUser(user);

	    return "redirect:/";
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
	    return "login";
	}
	
	@PostMapping("/login")
	public String loginUser(
	        @RequestParam String email,
	        @RequestParam String password,HttpSession session) {

	    User user = userService.loginUser(email, password);

	    if (user != null) {
	        return "redirect:/";
	    }

	    return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {

	    session.invalidate();

	    return "redirect:/";
	}

}
