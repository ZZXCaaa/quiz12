package com.example.quiz12.vo;

import java.util.List;

public class OptuonAnswer {
	private int quesId;
	private String quesName;
	private List<String> quesAnswer;

	public int getQuesId() {
		return quesId;
	}

	public String getQuesName() {
		return quesName;
	}

	public List<String> getQuesAnswer() {
		return quesAnswer;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public void setQuesName(String quesName) {
		this.quesName = quesName;
	}

	public void setQuesAnswer(List<String> quesAnswer) {
		this.quesAnswer = quesAnswer;
	}

}
