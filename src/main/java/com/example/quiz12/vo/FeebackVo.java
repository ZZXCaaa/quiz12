package com.example.quiz12.vo;

import java.time.LocalDate;
import java.util.List;

public class FeebackVo {

	
	private int quizId;
	private String quizName;

	private String quizDescription;

	//
	private String userName;
	private String userEmail;
	private int userAge;

	// 回答& 時間
	private LocalDate fillinDate;

	private List<OptuonAnswer> optuonAnswer;

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public String getQuizDescription() {
		return quizDescription;
	}

	public void setQuizDescription(String quizDescription) {
		this.quizDescription = quizDescription;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public LocalDate getFillinDate() {
		return fillinDate;
	}

	public void setFillinDate(LocalDate fillinDate) {
		this.fillinDate = fillinDate;
	}

	public List<OptuonAnswer> getOptuonAnswer() {
		return optuonAnswer;
	}

	public void setOptuonAnswer(List<OptuonAnswer> optuonAnswer) {
		this.optuonAnswer = optuonAnswer;
	}
	
}
