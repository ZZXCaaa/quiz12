package com.example.quiz12.vo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.quiz12.entity.Feelback;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class fillinReq {

	private int quizId;

	private String userName;

	private String email;

	private int userAge;

	// 問題編號 (quesId) ,答案 (Answer)
	private Map<Integer, List<String>> quesIdAnswerMap;
	// 給予預設值(當前日期) , 千端送過來的欄位是空的話 就給預設值
	private LocalDate fillInDate =LocalDate.now();

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public Map<Integer, List<String>> getQuesIdAnswerMap() {
		return quesIdAnswerMap;
	}

	public void setQuesIdAnswerMap(Map<Integer, List<String>> quesIdAnswerMap) {
		this.quesIdAnswerMap = quesIdAnswerMap;
	}

	public LocalDate getFillInDate() {
		return fillInDate;
	}

	public void setFillInDate(LocalDate fillInDate) {
		this.fillInDate = fillInDate;
	}

}
