package com.batch.teste.teste.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.batch.teste.teste.model.TestTable;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Bean
	public Step getTest(ItemReader<TestTable> reader,
						ItemProcessor<TestTable, TestTable> processor,
						ItemWriter<TestTable> writer,
						JobRepository jobRepository,
						PlatformTransactionManager transactionManager) {
		return new StepBuilder("getTest", jobRepository)
					.<TestTable, TestTable>chunk(2, transactionManager)
					.reader(reader)
					.processor(processor)
					.writer(writer)
					.build();
	}
	
	@Bean
	public Job getTestJob(Step step, JobRepository jobRepository) {
		return new JobBuilder("getTestJob", jobRepository)
				.start(step)
				.build();
	}

}
