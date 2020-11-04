package com.arquitecturajava.batchbasico;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.arquitecturajava.batchbasico.pasos.Paso1;

@EnableBatchProcessing
public class JobConfiguration {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	
//	@Bean
//	public Step paso1() {
//		
//		return stepBuilderFactory.get("paso1").tasklet(new Tasklet() {
//
//			@Override
//			public RepeatStatus execute(StepContribution contribution, 
//					ChunkContext chunkContext) throws Exception {
//				
//				System.out.println("holas desde Spring Batch");
//				
//				return RepeatStatus.FINISHED;
//			}
//			
//		}).build();
//	}
	
	@Bean
	public Step paso1() {
		
		return stepBuilderFactory.get("paso1").tasklet(new Paso1()).build();
	}
	
	@Bean 
	Job job() {
		
		return jobBuilderFactory.get("primerTrabajo").start(paso1()).build();
		
	}
	
}
