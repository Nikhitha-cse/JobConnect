package com.jobconnect.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobconnect.entity.Job;


public interface JobRepository extends JpaRepository<Job, Long> {
	
	List<Job> findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrLocationContainingIgnoreCase(
	        String title,
	        String company,
	        String location);

}
