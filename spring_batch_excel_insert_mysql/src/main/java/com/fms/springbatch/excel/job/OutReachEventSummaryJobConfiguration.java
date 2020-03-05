package com.fms.springbatch.excel.job;

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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.fms.entity.OutreachEventsSummary;
import com.fms.springbatch.excel.mapper.OutReachEventSummaryMapperImpl;
import com.fms.springbatch.excel.util.FileMoved;


//@EnableBatchProcessing
@Configuration
public class OutReachEventSummaryJobConfiguration {
	
	
	@Bean
	ItemStreamReader<OutreachEventsSummary> xlsxFileReaderSummary(@Value("${inputSummary}") Resource in){
		PoiItemReader<OutreachEventsSummary> reader=new PoiItemReader<OutreachEventsSummary>();
		reader.setResource(in);
		reader.setRowMapper(new OutReachEventSummaryMapperImpl());
		reader.setLinesToSkip(1);
		return reader;
	}
	
	@Bean
	JdbcBatchItemWriter<OutreachEventsSummary> jobWriter(DataSource ds){
		return new JdbcBatchItemWriterBuilder<OutreachEventsSummary>()
				.dataSource(ds)
				.sql("INSERT INTO `outreacheventssummary`(`EventID`,`Months`,`BaseLocation`,`BeneficiaryName`,`VenueAddress`," + 
						"`CouncilName`,`Project`,`Category`,`EventName`,`EventDescription`,`EventDate`,`Totalnoofvolunteers`," + 
						"`TotalVolunteerHours`,`TotalTravelHours`,`OverallVolunteeringHours`,`LivesImpacted`,`ActivityType`," + 
						"`summary_Status`,`POCID`,`POCName`,`POCContactNumber`)VALUES" + 
						"(" + 
						":EventID,:Months,:BaseLocation,:BeneficiaryName,:VenueAddress," + 
						":CouncilName,:Project,:Category,:EventName,:EventDescription,:EventDate,:TotalNoOfVolunteers," + 
						":TotalVolunteerHours,:TotalTravelHours,:OverallVolunteeringHours,:LivesImpacted,:ActivityType," + 
						":Status,:PocID,:PocName,:PocContactNumber);")
				.beanMapped()
				.build();
	}
	
	@Bean 
	  Job job(JobBuilderFactory jobBuilderFactory,
			  StepBuilderFactory stepBuilderFactory,
			  ItemReader<? extends OutreachEventsSummary> iReader,
			  ItemWriter<? super OutreachEventsSummary> iWriter) {
	  
		  Step step = stepBuilderFactory.get("fb-db-summary")
		  .<OutreachEventsSummary,OutreachEventsSummary> chunk(100)
		  .reader(iReader)
		  .writer(iWriter)
		  .build();
		  
		  Step stepMove=stepBuilderFactory.get("file-renamed-moved").tasklet(getFileRenameAndMoveSummaryTasket()).build();
	  
		 return jobBuilderFactory.get("etl-summary") 
				 .incrementer(new RunIdIncrementer())
				 .start(step)
				 .next(stepMove)
				 .build();
	 }
	
	@Bean
	public FileMoved getFileRenameAndMoveSummaryTasket() {
		return new FileMoved(new FileSystemResource("D:\\Users\\751096\\excel\\OutReachEventSummary.xlsx"),new FileSystemResource("D:\\Users\\751096\\excel\\EXCEL_DONE"));
	}
 

}
