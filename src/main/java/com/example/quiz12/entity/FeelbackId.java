package com.example.quiz12.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
public class FeelbackId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int quizId;
	private String email;
	private int quesId;

	public int getQuizId() {
		return quizId;
	}

	public String getEmail() {
		return email;
	}

	public int getQuesId() {
		return quesId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

}
