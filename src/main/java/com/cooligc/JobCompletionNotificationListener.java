/**
 * 
 */
package com.cooligc;


import java.util.UUID;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sitakant
 *
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
	
	@Autowired
	private CarRepo carRepo;

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("!!! JOB FINISHED! Time to verify the results");
			carRepo.findAll().forEach(action -> System.out.println(UUID.randomUUID().toString()+"\t :-> \t"+action));
		}
	}
}
