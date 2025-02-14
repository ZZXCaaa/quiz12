package com.example.quiz12.vo;

import java.util.List;

import com.example.quiz12.entity.Question;

public class GetQuestionRes extends BasicRes
{
	private List<Question> quesList;

	public GetQuestionRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetQuestionRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public GetQuestionRes(List<Question> quesList,int code, String message) {
		super(code ,message);
		this.quesList = quesList;
	}

	public List<Question> getQuesList() {
		return quesList;
	}
	
	
}
