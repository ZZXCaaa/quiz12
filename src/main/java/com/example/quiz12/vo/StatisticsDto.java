package com.example.quiz12.vo;

public class StatisticsDto 
{	
	private String quizName;
	private int quesId;
	private String quesName;
	private boolean required;
	private String option;
	private String type;
	private String answer;

	public StatisticsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatisticsDto(String quizName, int quesId, String quesName, boolean required, String option, String type,
			String answer) {
		super();
		this.quizName = quizName;
		this.quesId = quesId;
		this.quesName = quesName;
		this.required = required;
		this.option = option;
		this.type = type;
		this.answer = answer;
	}

	public String getQuizName() {
		return quizName;
	}

	public int getQuesId() {
		return quesId;
	}

	public String getQuesName() {
		return quesName;
	}

	public boolean isRequired() {
		return required;
	}

	public String getOption() {
		return option;
	}

	public String getType() {
		return type;
	}

	public String getAnswer() {
		return answer;
	}
	
}
