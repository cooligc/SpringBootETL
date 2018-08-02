package com.cooligc;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	JobCompletionNotificationListener jobCompletionNotificationListener;

	@Autowired
	@Qualifier("step1")
	Step step1;

	@Bean
	public Job job(JobBuilderFactory builderFactory, StepBuilderFactory stepBuilderFactory, ItemReader<Car> reader,
			ItemProcessor<Car, Car> itemProcessor, ItemWriter<Car> itemWriter) {
		Step step = stepBuilderFactory.get("car-loder-step")
				// Batch Size and the type are mandatory
				.<Car, Car>chunk(100).reader(reader).processor(itemProcessor).writer(itemWriter).build();

		return builderFactory.get("car-importer-etl")
				// Incrementer based on batch
				.incrementer(new RunIdIncrementer())
				// Post job execution. This listener will get trigger
				.listener(jobCompletionNotificationListener)
				// For one step use start . For multiple step use flow and next
				// .start(step).build();
				.flow(step1).next(step).end().build();
	}

	@Bean
	public FlatFileItemReader<Car> reader(@Value("${inputFile}") Resource resource) {
		FlatFileItemReader<Car> flatFileItemReader = new FlatFileItemReader<Car>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("car-csv-reader");
		// First line to be skipped as this would be header
		flatFileItemReader.setLinesToSkip(1);
		// Map the data to POJO
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}

	@Bean
	LineMapper<Car> lineMapper() {
		DefaultLineMapper<Car> defaultLineMapper = new DefaultLineMapper<>();

		// This will take the data with , delimited
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setDelimiter(",");
		delimitedLineTokenizer.setStrict(Boolean.FALSE);
		delimitedLineTokenizer.setNames(new String[] { "modelYear", "manufacturer", "mfrCode", "representedTest",
				"testVehicleId", "testConfiguration", "testVehicleDisplacement", "actualTestGroup", "power",
				"vehicleType", "noOfCylinder" });
		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

		// This will map the data from csv to java POJO
		BeanWrapperFieldSetMapper<Car> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(Car.class);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

		return defaultLineMapper;
	}
}
