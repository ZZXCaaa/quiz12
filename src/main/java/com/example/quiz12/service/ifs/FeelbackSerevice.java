package com.example.quiz12.service.ifs;
import com.example.quiz12.vo.BasicRes;
import com.example.quiz12.vo.FeebackRes;
import com.example.quiz12.vo.StatisticsRes;
import com.example.quiz12.vo.fillinReq;

public interface FeelbackSerevice 
{
	public BasicRes fillin(fillinReq req);
	public FeebackRes feebackRes (int quizId);
	 StatisticsRes statistics(int quizId);
	
}
