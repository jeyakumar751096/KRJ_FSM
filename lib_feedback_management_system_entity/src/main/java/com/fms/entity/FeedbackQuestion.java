package com.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="FeedbackQuestion")
@Data
public class FeedbackQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FeedbackQuestionId")
	private Integer feedbackQuestionId;

	@Column(name="FeedbackTypeStaus")
	private  FeedbackType feedbackTypeStaus;
	
	@Column(name="QuestionTypeStaus")
	private TypeOfQuestions questionTypeStaus;
	

	@Column(name="Questions")
	private String questions;

}
