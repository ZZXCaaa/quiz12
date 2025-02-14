package com.example.quiz12.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "feeback")
@IdClass(value = FeelbackId.class)
public class Feelback {
	@Id
	@Column(name = "quiz_id")
	private int quizId;
	@Column(name = "user_name")
	private String userName;
	@Id
	@Column(name = "user_email")
	private String email;

	@Column(name = "user_age")
	private int userAge;

	@Id
	@Column(name = "ques_id")
	private int quesId;

	@Column(name = "answer")
	private String answer;
	@Column(name = "fell_in_date")
	private LocalDate fillInDate;
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
	public int getQuesId() {
		return quesId;
	}
	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public LocalDate getFillInDate() {
		return fillInDate;
	}
	public void setFillInDate(LocalDate fillInDate) {
		this.fillInDate = fillInDate;
	}

}
