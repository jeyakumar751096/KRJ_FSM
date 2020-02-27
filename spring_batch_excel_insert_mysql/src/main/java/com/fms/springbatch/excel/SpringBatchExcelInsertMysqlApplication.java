package com.fms.springbatch.excel;


import java.io.File;

import javax.sql.DataSource;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.excel.poi.PoiItemReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.fms.entity.OutReachEventInformation;
import com.fms.springbatch.excel.mapper.RowMapperImpl;
import com.fms.springbatch.excel.util.FileMoved;




@SpringBootApplication
@EnableBatchProcessing
@Configuration
@ComponentScan("com.fms.springbatch.excel,com.fms.entity")
public class SpringBatchExcelInsertMysqlApplication {

	
	/*	@Bean
		FlatFileItemReader<OutReachEventInformation> fileItemReader(@Value("${input}") Resource resource1) throws Exception {
		return new FlatFileItemReaderBuilder<OutReachEventInformation>()
				.name("file-reader")
				.resource(resource1)
				.targetType(OutReachEventInformation.class)
				.delimited().delimiter(",").names(new String[] {"firstname"})
				.build();	
		}*/
		
		@Bean
		ItemStreamReader<OutReachEventInformation> xlsxFileReader(@Value("${input}") Resource in){
			PoiItemReader<OutReachEventInformation> reader=new PoiItemReader<OutReachEventInformation>();
			reader.setResource(in);
			reader.setRowMapper(new RowMapperImpl());
			reader.setLinesToSkip(1);
			return reader;
		}
		
		@Bean
		JdbcBatchItemWriter<OutReachEventInformation> jobWriterSummary(DataSource ds){
			return new JdbcBatchItemWriterBuilder<OutReachEventInformation>()
					.dataSource(ds)
					.sql("INSERT INTO `outreacheventinformation`" + 
							"(`EventID`,`BaseLocation`,`BeneficiaryName`,`CouncilName`,`EventName`,`EventDescription`," + 
							"`EventDate`,`EmployeeID`,`EmployeeName`,`VolunteerHours`,`TravelHours`,`LivesImpacted`,`BusinessUnit`,`Status`," + 
							"`IIEPCategory`) VALUES" + 
							"(:EventID,:BaseLocation,:BeneficiaryName,:CouncilName,:EventName,:EventDescription,:EventDate," + 
							":EmployeeID,:EmployeeName,:VolunteerHours,:TravelHours,:LivesImpacted,:BusinessUnit,:Status,:iiepCategory)")
					.beanMapped()
					.build();
		}
		
		
	  @Bean 
	  Job jobSummary(JobBuilderFactory jobBuilderFactory,
			  StepBuilderFactory stepBuilderFactory,
			  ItemReader<? extends OutReachEventInformation> iReader,
			  ItemWriter<? super OutReachEventInformation> iWriter) {
	  
		  Step step = stepBuilderFactory.get("fb-db")
		  .<OutReachEventInformation,OutReachEventInformation> chunk(100)
		  .reader(iReader)
		  .writer(iWriter)
		  .build();
		  
		  Step stepMove=stepBuilderFactory.get("file-renamed-moved").tasklet(getFileRenameAndMoveTasket()).build();
	  
		 return jobBuilderFactory.get("etl") 
				 .incrementer(new RunIdIncrementer())
				 .start(step)
				 .next(stepMove)
				 .build();
	 }
	  
	  @Bean
		public FileMoved getFileRenameAndMoveTasket() {
			return new FileMoved(new FileSystemResource("D:\\Users\\751096\\excel\\Book1.xlsx"),new FileSystemResource("D:\\Users\\751096\\excel\\OLD\\Book1.xlsx"));
		}
	 
	
	
	public static void main(String[] args) {
		System.setProperty("input", "file:\\"+new File("D:\\Users\\751096\\excel\\Book1.xlsx").getAbsolutePath());
		System.setProperty("inputSummary", "file:\\"+new File("D:\\Users\\751096\\excel\\OutReachEventSummary.xlsx").getAbsolutePath());
		SpringApplication.run(SpringBatchExcelInsertMysqlApplication.class, args);
	}

}
