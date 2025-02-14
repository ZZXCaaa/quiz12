package com.example.quiz12.service.ifs;

import com.example.quiz12.vo.BasicRes;
import com.example.quiz12.vo.CreateReq;
import com.example.quiz12.vo.DeleatReq;
import com.example.quiz12.vo.GetQuestionRes;
import com.example.quiz12.vo.QuizSearchRes;
import com.example.quiz12.vo.SearchReq;
import com.example.quiz12.vo.UpdateReq;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

public interface QuizService {
	
	public BasicRes create(CreateReq req);
	
	public QuizSearchRes getAllQuiz();
	public QuizSearchRes getQuiz(SearchReq req);
	public GetQuestionRes getQuesByQuizId(int quizId);
	public BasicRes deleate(DeleatReq req);
	public BasicRes Update(UpdateReq req);
}
