package com.fms.springbatch.excel.util;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;


//@Configuration
public class FileMoved implements Tasklet {

	Logger log=LoggerFactory.getLogger(FileMoved.class);
	
	//@Autowired(required = true)
	  private Resource sourcePath,destPath;
	  
	  public FileMoved( Resource sourcePath, Resource destPath) {
		  this.sourcePath=sourcePath; 
		  this.destPath=destPath; 
	}
	
	

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		log.info(" execute method ...");
		//fileMovedRename();
		
		log.info("Source Path :::"+sourcePath.getFile().getAbsolutePath());
		log.info("Dest Path :::"+destPath.getFile().getAbsolutePath());
		
		String splitRegex=Pattern.quote(System.getProperty("file.separator"));
		String[] splittedName=splitRegex.split(splitRegex);
		Stream.of(splittedName).forEach(i->{			
			log.info("splitted names ::"+i);
		});
		String fileName=sourcePath.getFile().getAbsoluteFile().getName();
		
		log.info("splittedName :::"+splittedName+" File name "+fileName);
		
		return RepeatStatus.FINISHED;
	}


	

}

