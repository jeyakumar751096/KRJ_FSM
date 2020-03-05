package com.fms.springbatch.excel.util;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
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
		
		String srcFilePath = sourcePath.getFile().getAbsolutePath();
		String destFilePath = destPath.getFile().getAbsolutePath();

		log.info("Source Path :::" + sourcePath.getFile().getAbsolutePath());
		log.info("Dest Path :::" + destPath.getFile().getAbsolutePath());

		String srcFileName = sourcePath.getFilename();
		String fileExt = srcFileName.split("\\.")[1];

		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
		String formatDateTime = now.format(format);
		log.info("After Formatting: :::" + formatDateTime);

		String renamedFile = srcFileName.split("\\.")[0].concat("-").concat(formatDateTime).concat("." + fileExt);
		log.info("RenameFile " + renamedFile);
		
		File srcFile = new File(srcFilePath);
		File mvFile = new File(destFilePath +"\\"+ renamedFile);	
		boolean moved = false;
				moved = srcFile.renameTo(mvFile);
			 if (!moved) {
					throw new RuntimeException("File Path is not Correct!");
				}

		log.info("File Moved " + moved);
		
		return RepeatStatus.FINISHED;
	}


	

}

