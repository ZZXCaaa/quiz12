package com.example.quiz12.service.impl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.quiz12.constants.QuesType;
import com.example.quiz12.constants.ResMessage;
import com.example.quiz12.dao.QuestionDao;
import com.example.quiz12.dao.QuizDao;
import com.example.quiz12.dao.feelbackDao;
import com.example.quiz12.entity.Feelback;
import com.example.quiz12.entity.Question;
import com.example.quiz12.entity.QuestionId;
import com.example.quiz12.entity.Quiz;
import com.example.quiz12.service.ifs.FeelbackSerevice;
import com.example.quiz12.vo.BasicRes;
import com.example.quiz12.vo.FeebackRes;
import com.example.quiz12.vo.FeebackVo;
import com.example.quiz12.vo.OptionCount;
import com.example.quiz12.vo.OptuonAnswer;
import com.example.quiz12.vo.StatisticsDto;
import com.example.quiz12.vo.StatisticsRes;
import com.example.quiz12.vo.StatisticsVo;
import com.example.quiz12.vo.feebackDto;
import com.example.quiz12.vo.fillinReq;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.asm.Advice.Return;

@Service
public class FeelbackSereviceImpl implements FeelbackSerevice {

//	@Autowired
//	private QuizDao quizDao;
//	@Autowired
//	private QuestionDao quesDao;
//	@Autowired
//	private feelbackDao feeDao;
//
//	private ObjectMapper mapper = new ObjectMapper();
//
//	@Override
//	public BasicRes fillin(fillinReq req) {
//		// 1.參數檢查
//		BasicRes checkRes = checkParam(req);
//		if (checkRes != null) {
//			return checkRes;
//		}
//		// 2.檢查是否存在已極是否已發布
//		if (quizDao.selectCountIspublished(req.getQuizId()) != 1) {
//			return new BasicRes(ResMessage.QUIZ_NOT_FOUND.getCode(), //
//					ResMessage.QUIZ_NOT_FOUND.getMessage());
//		}
//		// 3. 檢查問題
//		if(feeDao.selectCount(req.getQuizId(),req.getEmail())!= 0)
//		{
//			return new BasicRes(ResMessage.EMAIL_DUPLICATED.getCode(), //
//					ResMessage.EMAIL_DUPLICATED.getMessage());
//		}
//		// 4.檢查問題
//        // 利用 quizId 找出問卷(使用 JPA 方法):被 Optional 包起來主要用來提醒要判斷內容物是否有值
//		Optional<Quiz> op = quizDao.findById(req.getQuizId());
//		
//		// 判斷被 Optional 包起來的 Quiz 物件是否有值
//		// op.isEmpty() == true 時,表示從資料庫取回的 Quiz 沒有資料
//		if(op.isEmpty())
//		{
//			return new BasicRes(ResMessage.EMAIL_DUPLICATED.getCode(), //
//							ResMessage.EMAIL_DUPLICATED.getMessage());
//		}
//		// 將 Quiz 從 Optional 中取出
//		// 4.1 檢查填寫的日期是否在問卷可填寫的範圍內
//		Quiz quiz =op.get();
//		LocalDate strDate = quiz.getStartDate();
//		LocalDate endDate = quiz.getEndDate();
//		LocalDate fillinDate = req.getFillInDate();
//		// 判斷填寫時間是否在開始時間之前或者結束時間之後
//		if(fillinDate.isBefore(strDate)||fillinDate.isAfter(endDate))
//		{
//			return new BasicRes(ResMessage.OUT_OF_FILLIN_DATE_RANGE.getCode(), //
//					ResMessage.OUT_OF_FILLIN_DATE_RANGE.getMessage());
//		}
//		// 4.2 比對相同題號中填寫的答案(來自 req)與選項(來自資料庫)是否一樣(除了簡答之外)
//		List<Question> quesList = quesDao.getByQuizId(req.getQuizId());
//		//題號 ,答案(一到多個)
//		Map<Integer, List<String>>quesIdAnswerMap = req.getQuesIdAnswerMap();
//		for(Question item:quesList)
//		{
//			//比對題號
//			int quesNumber = item.getQuesId();
//			List<String> answerList = quesIdAnswerMap.get(quesNumber);
//			// 排除若該題是必填,但沒有答案
//			if(item.isRequired()&&CollectionUtils.isEmpty(answerList))
//			{
//				return new BasicRes(ResMessage.ANSWERI_IS_REQUIRED.getCode(), //
//						ResMessage.ANSWERI_IS_REQUIRED.getMessage());
//			}
//			//排除題目類型是text
//			String quesTypeString =item.getType();
//			if (quesTypeString.equalsIgnoreCase(quesTypeString))
//			{
//				continue;
//			}
//			// 題目是單選或簡答(文字)時
//			if(quesTypeString.equalsIgnoreCase(QuesType.SINGLE.getType())||quesTypeString.equalsIgnoreCase(QuesType.TEXT.getType()))
//			{
//				if (answerList.size() >1) {
//					return new BasicRes(ResMessage.ONE_OPTION_IS_ALLOWED.getCode(), //
//							ResMessage.ONE_OPTION_IS_ALLOWED.getMessage());
//				}
//			}
//			// 將選項字串轉成 list<String>: 要先確定當初創建問卷時，前端的多個選項是陣列，且使用 Stringify 轉成字串類型
//            // 前端選項原本格式(陣列): ["aa","bb","cc"]
//			try {
//				List<String> options = mapper.readValue(item.getOptions(), new TypeReference<>(){
//				});
//				// 比對相同題號中的懸項答案
//				for (String answer : answerList) 
//				{
//					if(!options.contains(answer))
//					{
//						return new BasicRes(ResMessage.OPTIONS_ANSWER_MISMATCH.getCode(), //
//								ResMessage.OPTIONS_ANSWER_MISMATCH.getMessage());
//					}
//				}
//				for (String option : options) 
//				{
//					for (String answer : answerList) 
//					{
//						
//					}
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//				return new BasicRes(ResMessage.OPTIONS_PARSER_ERROE.getCode(), //
//						ResMessage.OPTIONS_PARSER_ERROE.getMessage());
//			}
//			
//		}
//		//存資料
//		List<Feelback> feedBackList = new ArrayList<Feelback>();
//		for(Entry<Integer, List<String>>map:req.getQuesIdAnswerMap().entrySet())
//		{
//			Feelback feelback = new Feelback();
//			feelback.setQuizId(req.getQuizId());
//			feelback.setUserName(req.getUserName());
//			feelback.setEmail(req.getEmail());
//			feelback.setUserAge(req.getUserAge());
//			feelback.setQuesId(map.getKey());
//			// 將 List<String> 轉成 String
//			try {
//				String answString = mapper.writeValueAsString(map.getValue());
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//				return new BasicRes(ResMessage.OPTIONS_PARSER_ERROE.getCode(), //
//						ResMessage.OPTIONS_PARSER_ERROE.getMessage());
//			}
//			feelback.setFillInDate(req.getFillInDate());
//			feedBackList.add(feelback);
//		}
//		feeDao.saveAll(feedBackList);
//		
//		return new BasicRes(ResMessage.SUCCESS.getCode(),ResMessage.SUCCESS.getMessage());
//	}
//
//	private BasicRes checkParam(fillinReq req) {
//		// 排除法
//		if (req.getQuizId() <= 0) {
//			return new BasicRes(ResMessage.PARAM_QUIZ_ID_ERROR.getCode(), //
//					ResMessage.PARAM_QUIZ_ID_ERROR.getMessage());
//		}
//		if (!StringUtils.hasText(req.getUserName())) {
//			return new BasicRes(ResMessage.PARAM_USER_NAME_ERROR.getCode(), //
//					ResMessage.PARAM_USER_NAME_ERROR.getMessage());
//		}
//		if(!StringUtils.hasText(req.getEmail()))
//		{
//			return new BasicRes(ResMessage.PARAM_USER_NAME_ERROR.getCode(), //
//					ResMessage.PARAM_USER_NAME_ERROR.getMessage());
//		}
//		if (req.getUserAge() <= 0) 
//		{
//			return new BasicRes(ResMessage.PARAM_USER_AGE_ERROR.getCode(), //
//			ResMessage.PARAM_USER_AGE_ERROR.getMessage());
//		}
//
//		return null;
//	}
//
//	@Override
//	public FeebackRes feebackRes(int quizId) {
//		// TODO Auto-generated method stub
//		if (quizId <= 0) {
//			return new FeebackRes(ResMessage.PARAM_QUIZ_ID_ERROR.getCode(), //
//					ResMessage.PARAM_QUIZ_ID_ERROR.getMessage());
//		}
//		List<feebackDto> feebackList = feeDao.selectfeebackByQuizId(quizId);
//		List<FeebackVo> feebackVoList = new ArrayList<>();
//		for (feebackDto item : feebackList) 
//		{
//				//檢查是否同一位填寫者
//				//查看FeebackVoList中是否也有相同的email存在
//				FeebackVo resVo = getEmail(feebackVoList,item.getUserEmail());
//				if(resVo != null)
//				{
//					
//					
//					//取出optionAnsWerList 此 optuonAnswerList 已經包含之前新增的 optionAnswer
//					List<OptuonAnswer> optuonAnswerList = resVo.getOptuonAnswer();
//					//設定同一張問眷不同填寫者和答案
//					OptuonAnswer optuonanswer = new OptuonAnswer();
//					optuonanswer.setQuesId(item.getQuesId());
//					optuonanswer.setQuesName(item.getQuesName());
//					List<String> answerList = new ArrayList<String>();
//					// 把答案轉成list<Strig>
//					try 
//					{
//						answerList = mapper.readValue(item.getAnswer(), new TypeReference<>(){});
//					} 
//					catch (Exception e) 
//					{
//						return new FeebackRes(ResMessage.ANSWER_PARSER_ERROR.getCode(), //
//								ResMessage.ANSWER_PARSER_ERROR.getMessage());
//					}
//					optuonanswer.setQuesAnswer(answerList);
//					optuonAnswerList.add(optuonanswer);	
//					resVo.setOptuonAnswer(optuonAnswerList);		
//				}
//				else 
//				{//表示feebackVoList 中的feebackVo沒有相同Email
//					//取出optionAnsWerList 此 optuonAnswerList 已經包含之前新增的 optionAnswer
//					FeebackVo vo = new FeebackVo();
//					//設定同一張問絕合同一位填寫者的資料
//					vo.setQuizName(item.getQuizName());
//					vo.setQuizDescription(item.getQuizDescription());
//					vo.setUserName(item.getUserName());
//					vo.setUserEmail(item.getUserEmail());
//					vo.setUserAge(item.getUserAge());
//					vo.setFillinDate(item.getFillinDate());	
//					List<OptuonAnswer> optuonAnswerList = resVo.getOptuonAnswer();
//					//設定同一張問眷不同填寫者和答案
//					OptuonAnswer optuonanswer = new OptuonAnswer();
//					optuonanswer.setQuesId(item.getQuesId());
//					optuonanswer.setQuesName(item.getQuesName());
//					List<String> answerList = new ArrayList<String>();
//					// 把答案轉成list<Strig>
//					try 
//					{
//						answerList = mapper.readValue(item.getAnswer(), new TypeReference<>(){});
//					} 
//					catch (Exception e) 
//					{
//						return new FeebackRes(ResMessage.ANSWER_PARSER_ERROR.getCode(), //
//								ResMessage.ANSWER_PARSER_ERROR.getMessage());
//					}
//					
//					optuonanswer.setQuesAnswer(answerList);
//					optuonAnswerList.add(optuonanswer);	
//					resVo.setOptuonAnswer(optuonAnswerList);
//					
//					feebackVoList.add(resVo);
//				}
//			}
//		return new FeebackRes(ResMessage.SUCCESS.getCode(), //
//				ResMessage.SUCCESS.getMessage(),feebackVoList);
//	}
//	private FeebackVo getEmail(List<FeebackVo> feedbackVoList , String tagetEmail)
//	{
//		for( FeebackVo vo:feedbackVoList)
//		{
//			if (vo.getUserEmail().equalsIgnoreCase(tagetEmail)) 
//			{
//				
//				return vo;
//			}
//		}
//		return null;
//	}	
	//---------------------------------------------------------------------------
	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private QuizDao quizDao;

	@Autowired
	private QuestionDao questionDao;

	@Autowired
	private feelbackDao feedbackDao;

	@Override
	public BasicRes fillin(fillinReq req) {
		// 1. 檢查參數
		BasicRes checkRes = checkParam(req);
		if (checkRes != null) {
			return checkRes;
		}
		// 2. 檢查問卷是否存在以及已發佈
		if (quizDao.selectCountIspublished(req.getQuizId()) != 1) {
			return new BasicRes(ResMessage.QUIZ_NOT_FOUND.getCode(), //
					ResMessage.QUIZ_NOT_FOUND.getMessage());
		}
		// 3. 檢查同一個 email 是否有填過同一張問卷
		if (feedbackDao.selectCount(req.getQuizId(), req.getEmail()) != 0) {
			return new BasicRes(ResMessage.EMAIL_DUPLICATED.getCode(), //
					ResMessage.EMAIL_DUPLICATED.getMessage());
		}
		// 4. 檢查問題
		// 利用 quizId 找出問卷(使用 JPA 方法): 被 Optional 包起來主要用來提醒要判斷內容物是否有值
		Optional<Quiz> op = quizDao.findById(req.getQuizId());
		// 判斷被 Optional 包起來的 Quiz 物件是否有值
		if (op.isEmpty()) { // op.isEmpty() == true 時，表示從資料庫取回的 Quiz 沒有資料
			return new BasicRes(ResMessage.QUIZ_NOT_FOUND.getCode(), //
					ResMessage.QUIZ_NOT_FOUND.getMessage());
		}
		// 將 Quiz 從 Optional 中取出
		Quiz quiz = op.get();
		// 4.1 檢查填寫的日期是否在問卷可填寫的範圍內
		LocalDate startDate = quiz.getStartDate();
		LocalDate endDate = quiz.getEndDate();
		LocalDate fillinDate = req.getFillInDate();
		// 判斷填寫時間是否在開始時間之前或者結束時間之後
		if (fillinDate.isBefore(startDate) || fillinDate.isAfter(endDate)) {
			return new BasicRes(ResMessage.OUT_OF_FILLIN_DATE_RANGE.getCode(), //
					ResMessage.OUT_OF_FILLIN_DATE_RANGE.getMessage());
		}
		// 4.2 比對相同題號中填寫的答案(來自 req)與選項(來自資料庫)是否一樣(除了簡答之外)
		List<Question> quesList = questionDao.getByQuizId(req.getQuizId());
		// 題號, 答案(1~多個)
		Map<Integer, List<String>> quesIdAnswerMap = req.getQuesIdAnswerMap();
		
		for (Question item : quesList) {
			// 比對題號
			int quesNumber = item.getQuesId();
			List<String> answerList = quesIdAnswerMap.get(quesNumber);
			// 排除若該題是必填，但沒有答案
			if (item.isRequired() && CollectionUtils.isEmpty(answerList)) {
				return new BasicRes(ResMessage.ANSWER_IS_REQUIRED.getCode(), //
						ResMessage.ANSWER_IS_REQUIRED.getMessage());
			}
			// 排除題目類型是 text
			String quesType = item.getType();
			if (quesType.equalsIgnoreCase(QuesType.TEXT.getType())) {
				// 跳過當次
				continue;
			}
			// 題目是單選或簡答(文字)時			
			if (quesType.equalsIgnoreCase(QuesType.SINGLE.getType()) //
					|| quesType.equalsIgnoreCase(QuesType.TEXT.getType())) {
				// 答案不能有多個
				if (answerList.size() > 1) {
					return new BasicRes(ResMessage.ONE_OPTION_IS_ALLOWED.getCode(), //
							ResMessage.ONE_OPTION_IS_ALLOWED.getMessage());
				}
			}
			// 將選項字串轉成 List<String>: 要先確定當初創建問卷時，前端的多個選項是陣列，且使用 Stringify 轉成字串型態
			// 前端選項原本格式(陣列): ["aa","bb", "cc"]			
			try {
				List<String> options = mapper.readValue(item.getOptions(), new TypeReference<>() {
				});
				// 比對相同題號中的選項與答案
				for (String answer : answerList) {
					if (!options.contains(answer)) {
						return new BasicRes(ResMessage.OPTION_ANSWER_MISMATCH.getCode(), //
								ResMessage.OPTION_ANSWER_MISMATCH.getMessage());
					}
				}
			} catch (Exception e) {
				return new BasicRes(ResMessage.OPTIONS_PARSER_ERROR.getCode(), //
						ResMessage.OPTIONS_PARSER_ERROR.getMessage());
			}
		}
		// 存資料
		List<Feelback> feedbackList = new ArrayList<>();
		for(Entry<Integer, List<String>> map : req.getQuesIdAnswerMap().entrySet()) {
			Feelback feeback = new Feelback();
			feeback.setQuizId(req.getQuizId());
			feeback.setUserName(req.getUserName());
			feeback.setEmail(req.getEmail());
			feeback.setUserAge(req.getUserAge());
			feeback.setQuesId(map.getKey());
			// 將 List<String> 轉成 String
			try {
				String answerStr = mapper.writeValueAsString(map.getValue());
				feeback.setAnswer(answerStr);
			} catch (JsonProcessingException e) {
				return new BasicRes(ResMessage.OPTIONS_PARSER_ERROR.getCode(), //
						ResMessage.OPTIONS_PARSER_ERROR.getMessage());
			}
			feeback.setFillInDate(req.getFillInDate());
			feedbackList.add(feeback);
		}
		feedbackDao.saveAll(feedbackList);
		return new BasicRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage());
	}

	private BasicRes checkParam(fillinReq req) {
		// 排除法
		if (req.getQuizId() <= 0) {
			return new BasicRes(ResMessage.PARAM_QUIZ_ID_ERROR.getCode(), //
					ResMessage.PARAM_QUIZ_ID_ERROR.getMessage());
		}
		if (!StringUtils.hasText(req.getUserName())) {
			return new BasicRes(ResMessage.PARAM_USER_NAME_ERROR.getCode(), //
					ResMessage.PARAM_USER_NAME_ERROR.getMessage());
		}
		if (!StringUtils.hasText(req.getEmail())) {
			return new BasicRes(ResMessage.PARAM_EMAIL_ERROR.getCode(), //
					ResMessage.PARAM_EMAIL_ERROR.getMessage());
		}
		if (req.getUserAge() <= 0) {
			return new BasicRes(ResMessage.PARAM_AGE_ERROR.getCode(), //
					ResMessage.PARAM_AGE_ERROR.getMessage());
		}
		return null;
	}

	@Override
	public FeebackRes feebackRes(int quizId) {
		if(quizId <= 0) {
			return new FeebackRes(ResMessage.PARAM_QUIZ_ID_ERROR.getCode(), //
					ResMessage.PARAM_QUIZ_ID_ERROR.getMessage());
		}
		List<feebackDto> feedbackList = feedbackDao.selectfeebackByQuizId(quizId);
		// 整理資料
		List<FeebackVo> feedbackVoList = new ArrayList<>();
		for(feebackDto item : feedbackList) {
			// 查看 feedbackVoList 中是否已有相同 email 存在
			FeebackVo resVo = getEmail(feedbackVoList, item.getUserEmail());
			if(resVo != null) { // 表示 feedbackVoList 中的 FeedbackVo 已經存在相同的 email
				// 取出 optionAnswerList，此 optionAnswerList 已經有包含之前新增的 optionAnswer
				List<OptuonAnswer> optionAnswerList = resVo.getOptuonAnswer();
				// 新增並設定同一張問卷不同問題以及答案				
				OptuonAnswer optionAnswer = new OptuonAnswer();
				optionAnswer.setQuesId(item.getQuesId());
				optionAnswer.setQuesName(item.getQuesName());
				// 把答案字串轉成 List<String>
				List<String> answerList = new ArrayList<>();
				try {
					answerList = mapper.readValue(item.getAnswer(), new TypeReference<>() {});				
				} catch (Exception e) {
					return new FeebackRes(ResMessage.ANSWER_PARSER_ERROR.getCode(), //
							ResMessage.ANSWER_PARSER_ERROR.getMessage());
				}
				optionAnswer.setQuesAnswer(answerList);				
				optionAnswerList.add(optionAnswer);				
				resVo.setOptuonAnswer(optionAnswerList);
				// 取出的 FeedbackVo 早已經存在於 feedbackVoList 中，所以最後不需要再把 resVo 新增回去
			} else { // 表示 feedbackVoList 中的 FeedbackVo 沒有相同的 email
				FeebackVo vo = new FeebackVo();
				// 設定同一張問卷和同一位填寫者的資料
				vo.setQuizId(quizId);
				vo.setQuizName(item.getQuizName());
				vo.setQuizDescription(item.getQuizDescription());
				vo.setUserName(item.getUserName());
				vo.setUserEmail(item.getUserEmail());
				vo.setUserAge(item.getUserAge());
				vo.setFillinDate(item.getFillinDate());
				// 設定同一張問卷不同問題以及答案
				List<OptuonAnswer> optionAnswerList = new ArrayList<>();
				OptuonAnswer optionAnswer = new OptuonAnswer();
				optionAnswer.setQuesId(item.getQuesId());
				optionAnswer.setQuesName(item.getQuesName());
				// 把答案字串轉成 List<String>
				List<String> answerList = new ArrayList<>();
				try {
					answerList = mapper.readValue(item.getAnswer(), new TypeReference<>() {});				
				} catch (Exception e) {
					return new FeebackRes(ResMessage.ANSWER_PARSER_ERROR.getCode(), //
							ResMessage.ANSWER_PARSER_ERROR.getMessage());
				}
				optionAnswer.setQuesAnswer(answerList);
				optionAnswerList.add(optionAnswer);
				vo.setOptuonAnswer(optionAnswerList);
				
				feedbackVoList.add(vo);
			}			
		}
		return new FeebackRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(), feedbackVoList);
	}
	
	private FeebackVo getEmail(List<FeebackVo> feedbackVoList, String targetEmail) {
		for(FeebackVo vo : feedbackVoList) {
			if(vo.getUserEmail().equalsIgnoreCase(targetEmail)) {
				return vo;
			}
		}
		return null;
	}

	@Override
	public StatisticsRes statistics(int quizId) {
		if(quizId <= 0) {
			return new StatisticsRes(ResMessage.PARAM_QUIZ_ID_ERROR.getCode(), //
					ResMessage.PARAM_QUIZ_ID_ERROR.getMessage());
		}
		List<StatisticsDto> dtoList = feedbackDao.statistics(quizId);
		// 1. 集合每一題各自的所有答案 :Map<題號,答案>
		Map<Integer, List<String>> quesIdAnswerMap = gatherAnswer(dtoList);
		if(quesIdAnswerMap == null) {
			return new StatisticsRes(ResMessage.ANSWER_PARSER_ERROR.getCode(), //
					ResMessage.ANSWER_PARSER_ERROR.getMessage());
		}
		// 2. 蒐集每一題的選項(不直接從答案計算次數,是因為想到可能會有極端的情況:就是某個選項都沒人選)
		List<OptionCount> optionCountList =gatherOptions(dtoList);
		if(optionCountList == null) 
		{
			return new StatisticsRes(ResMessage.OPTIONS_PARSER_ERROE.getCode(), //
					ResMessage.OPTIONS_PARSER_ERROE.getMessage());
		}
		//3. 蒐集每一題沒個選項的次數
		optionCountList = statisticsCount(quesIdAnswerMap,optionCountList);
		if(optionCountList == null)
		{
			return new StatisticsRes(ResMessage.OPTION_COUNT_ERROR.getCode(), //
					ResMessage.OPTION_COUNT_ERROR.getMessage());
		}
		//4.設定結果
		List<StatisticsVo> statisticsVoList = new ArrayList<StatisticsVo>();
		for (StatisticsDto dto : dtoList) 
		{
			StatisticsVo vo  = new StatisticsVo();
			vo.setQuizName(dto.getQuizName());
			vo.setQuesId(dto.getQuesId());
			vo.setQuesName(dto.getQuesName());
			vo.setRequired(dto.isRequired());
			//把相同題號的 optionCount放在一起
			List<OptionCount> oList =new ArrayList<OptionCount>();
			for(OptionCount oc:optionCountList)
			{
				if(oc.getQuesId() == dto.getQuesId())
				{
					oList.add(oc);
				}
				
			}
			vo.setOptionCountList(oList);
			statisticsVoList.add(vo);
		}
		return new StatisticsRes(ResMessage.SUCCESS.getCode(), //
				ResMessage.SUCCESS.getMessage(),statisticsVoList);
	}
	
	private Map<Integer, List<String>> gatherAnswer(List<StatisticsDto> dtoList) {
		// 把每一題的答案放到 quesIdAnswerMap 中
        // 1. 若 quesIdAnswerMap 中已存在相同編號的 quesId //
        //--> 從 quesIdAnswerMap 中取出相同 quesId 對應的答案 List<String>, 
        //並把轉化後的答案加再一起後並放回到 quesIdAnswerMap 中 //
        // 2. 若 quesIdAnswerMap 中不存在相同編號的 quesId //
        //--> 把轉化後的答案 List<String> 放到 quesIdAnswerMap 中
		Map<Integer, List<String>> quesIdAnswerMap = new HashMap<>();
		for(StatisticsDto item : dtoList) 
		{
//			if(item.getType().equalsIgnoreCase(QuesType.TEXT.getType()))
//			{
//				
//			}
			// 將 Answer String 轉成 List<String>
			List<String> answerList = new ArrayList<>();
			try {
				answerList = mapper.readValue(item.getAnswer(), new TypeReference<>() {});
			} catch (Exception e) {
				return null;
			}
			// 若 quesIdAnswerMap 中已經存在相同編號的 List<String> answerList，就從 map 中取出
			if(quesIdAnswerMap.containsKey(item.getQuesId())) {
				List<String> answerListInMap = quesIdAnswerMap.get(item.getQuesId());
				// 把新的答案案已經存在的 answerList 加在一起
				answerList.addAll(answerListInMap);
			}
			quesIdAnswerMap.put(item.getQuesId(), answerList);
		}
		return quesIdAnswerMap;
	}
	private List<OptionCount> gatherOptions(List<StatisticsDto> dtoList)
	{
		List<OptionCount> optionCountList = new ArrayList<OptionCount>();
		//題號 是否已收集過的選項
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int targetQuesId =0;		
		for (StatisticsDto dto : dtoList) 
		{
			//跳過題型是 Text ,因為沒有選項可蒐集
			if(dto.getType().equalsIgnoreCase(QuesType.TEXT.getType()))
			{
				continue;
			}
			//targetQuesId == dto 為true的話 表示同一個選項已經收集過了
			Boolean boo = map.get(dto.getQuesId());
			if (boo != null && boo == true) 
			{
				continue;
			}
			if(map.get(dto.getQuesId())==true)
			{
				continue;
			}
			targetQuesId = dto.getQuesId();
			//轉換每一題的 String 為List<String>
			List<String> optionList = new ArrayList<String>();
			try {
				optionList = mapper.readValue(dto.getOption(),new TypeReference<>() {});
			} catch (Exception e) {
				return null;
			}
			//收幾題號和選項
			
			for (String str : optionList) 
			{
				//相同的題號下,每個不同的選項會有一個OptionCount
				OptionCount oc = new OptionCount();
				oc.setQuesId(dto.getQuesId());
				oc.setOptionString(str);
				optionCountList.add(oc);
			}
			map.put(dto.getQuesId(),true);
			
		}
		return optionCountList;
	}	
	//此方法只計算有選項的題型(單,多選)
	private List<OptionCount> statisticsCount(Map<Integer, List<String>> quesIdAnswerMap,List<OptionCount> Options)
	{
		
		for (OptionCount item : Options) 
		{
			
			for (OptionCount optionCount : Options)
			{
				//因為是以選項為主,所以外層的迴圈是<OptionCount>
				int quesId = item.getQuesId();
				String optionString =item.getOptionString();
				// 透過 quesId 從 quesIdAnswerMap 取得對應的答案 List
				List<String> ansList = quesIdAnswerMap.get(quesId);
				if (ansList == null) 
				{
					return null;
				}
				//把list<String>串成單一字串
				String ansStr = String.join("", ansList);
				//計算每個選項的次數
				int ansStrSize = ansStr.length(); //原本長度
				String newAnsString = ansStr.replace(optionString, "");//把謀個選項空字串代替
				int newStrSize = newAnsString.length(); //扣掉某個選項的長度
				//判斷該選項沒人選
				if(ansStrSize == newStrSize)
				{
					item.setCount(0);
				}
				else 
				{
					//選項可能會有多個字，所以要計算次數因該是要除以選項長度
					int count = (ansStrSize-newStrSize)/optionString.length();
					//將次數設定回到optionCount 中
					item.setCount(count);
				}
			}
		}
		return Options;
	}
}