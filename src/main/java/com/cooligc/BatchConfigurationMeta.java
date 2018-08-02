/**
 * 
 */
package com.cooligc;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * @author sitakant
 */
@Configuration
public class BatchConfigurationMeta {

	@Bean("step1")
	public Step step1(final StepBuilderFactory stepBuilderFactory, ItemReader<Meta> reader,
			ItemProcessor<Meta, Meta> itemProcessor, ItemWriter<Meta> itemWriter) {
		Step step = stepBuilderFactory.get("car-loder-meta")
				// Batch Size and the type are mandatory
				.<Meta, Meta>chunk(100).reader(reader).processor(itemProcessor).writer(itemWriter).build();
		return step;
	}

	@Bean
	public FlatFileItemReader<Meta> readerMeta(@Value("${inputMetaFile}") Resource resource) {
		FlatFileItemReader<Meta> flatFileItemReader = new FlatFileItemReader<Meta>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("meta-csv-reader");
		// First line to be skipped as this would be header
		flatFileItemReader.setLinesToSkip(1);
		// Map the data to POJO
		flatFileItemReader.setLineMapper(lineMapper2());
		return flatFileItemReader;
	}

	@Bean
	LineMapper<Meta> lineMapper2() {
		DefaultLineMapper<Meta> defaultLineMapper = new DefaultLineMapper<Meta>();

		// This will take the data with , delimited
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setDelimiter(",");
		delimitedLineTokenizer.setStrict(Boolean.FALSE);
		delimitedLineTokenizer.setNames(new String[] { "authToken" });
		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

		// This will map the data from csv to java POJO
		BeanWrapperFieldSetMapper<Meta> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(Meta.class);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

		return defaultLineMapper;
	}
}
