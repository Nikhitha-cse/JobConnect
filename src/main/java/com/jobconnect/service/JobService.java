package com.jobconnect.service;
import org.springframework.stereotype.Service;
import java.util.List;
import com.jobconnect.entity.Job;
import com.jobconnect.repository.JobRepository;

@Service
public class JobService {
	private final JobRepository jobRepository;
	
	public JobService(JobRepository jobRepository)
	{
		this.jobRepository=jobRepository;
		
	}
	public List<Job> getAllJobs(){
		
	return jobRepository.findAll();	
	}
	
	public List<Job> searchJobs(String keyword) {
	    return jobRepository
	            .findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrLocationContainingIgnoreCase(
	                    keyword, keyword, keyword);
	}
	
	public Job getJobById(Long id) {
	    return jobRepository.findById(id).orElse(null);
	}

}
