package com.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="FeedbackQuestionAnswer")
@Data
public class FeedbackQuestionAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FeedbackQuestionAnswerId")
	private Integer feedbackQuestionAnswerId;
	
	@Column(name="FeedbackQuestionAnswer")
	private String feedbackQuestionAnswer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FeedbackQuestionId")
	private FeedbackQuestion feedbackQuestionId;
	
	@Column(name="EventID")
	private String eventID;

}
