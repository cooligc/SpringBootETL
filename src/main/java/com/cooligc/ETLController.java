/**
 * 
 */
package com.cooligc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sitakant
 *
 */
@RestController
public class ETLController {

	@Autowired
	JobLauncher jobLuncher;
	
	@Autowired
	Job job;
	
	@GetMapping("/load")
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException{
		Map<String, JobParameter> maps = new HashMap<String, JobParameter>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(maps );
		JobExecution jobExecution = jobLuncher.run(job, jobParameters);
		
		while(jobExecution.isRunning()){
			System.out.println("Running ...");
		}
		
		System.out.println("JobExecution: "+jobExecution.getStatus());
		return jobExecution.getStatus();
	}
	
}
