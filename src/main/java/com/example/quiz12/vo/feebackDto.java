package com.example.quiz12.vo;

import java.time.LocalDate;

// 用於將多張表資料撈回來後的裝載容器
public class feebackDto {
	private String quizName;

	private String quizDescription;

	//
	private String userName;
	private String userEmail;
	private int userAge;

	// 回答& 時間
	private String answer;
	private LocalDate fillinDate;

	// 問題ID &名稱
	private int quizId;
	private int quesId;
	private String quesName;

	public feebackDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public feebackDto(String quizName, String quizDescription, String userName, String userEmail, int userAge,
			String answer, LocalDate fillinDate, int quizId, int quesId, String quesName) {
		super();
		this.quizName = quizName;
		this.quizDescription = quizDescription;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAge = userAge;
		this.answer = answer;
		this.fillinDate = fillinDate;
		this.quizId = quizId;
		this.quesId = quesId;
		this.quesName = quesName;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public LocalDate getFillinDate() {
		return fillinDate;
	}

	public void setFillinDate(LocalDate fillinDate) {
		this.fillinDate = fillinDate;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public String getQuesName() {
		return quesName;
	}

	public void setQuesName(String quesName) {
		this.quesName = quesName;
	}

}
