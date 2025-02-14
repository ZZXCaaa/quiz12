package com.example.quiz12.constants;

public enum ResMessage {
	// 列舉的項目
	SUCCESS(200, "Success!!"), //
	PARAM_NAME_ERROR(400, "Param name error!!"), //
	PARAM_DESCRIPTION_ERROR(400, "Param description error!!"), //
	PARAM_START_DATE_ERROR(400, "Param start date error!!"), //
	PARAM_END_DATE_ERROR(400, "Param end date error!!"), //
	PARAM_DATE_ERROR(400, "Param date error!!"), //
	PARAM_QUES_ID_ERROR(400, "Param question id error!!"), //
	PARAM_QUES_NAME_ERROR(400, "Param question name error!!"), //
	PARAM_TYPE_ERROR(400, "Param type error!!"), //
	PARAM_OPTIONS_ERROR(400, "Param options error!!"), //
	PARAM_QUES_LIST_ERROR(400, "Param question list error!!"),//;
	DATA_SAVE_ERRO(400,"data save error!!"),//
	QUES_TYPE_MISMATCH(400,"ques type mismatch"),//
	PARAM_QUIZ_ID_ERROR(400,"param quiz id error!!"),//
	QUIZ_NOT_FOUND(404,"quiz not found !"),
	QUIZ_ID_MISMATCH(400,"quiz id mismatch!"),//
	DATA_UPDATE_ERRO(400,"data update error!!"),//
	
	PARAM_USER_NAME_ERROR(400, "Param user name error!!"),//
	PARAM_USER_EMAIL_ERROR(400, "Param user email error!!"),//
	PARAM_USER_AGE_ERROR(400, "Param user age error!!"),
	ANSWER_PARSER_ERROR(400,"answer parser error!!"),//
	EMAIL_DUPLICATED(400,"Email duplicated"),//
	OUT_OF_FILLIN_DATE_RANGE(400, "Out of fillin date range!!"),//
	ONE_OPTION_IS_ALLOWED (400, "One option is allowed!!!"),//
	ANSWERI_IS_REQUIRED (400, "Answer is required!!"),//
	OPTIONS_ANSWER_MISMATCH(400,"Options answer mismatch !!"),//
	OPTIONS_PARSER_ERROE(400,"Options parser error !!"),//
	ANSWER_IS_REQUIRED(400, "answer is required!!"),//
	OPTION_ANSWER_MISMATCH(400,"option answer mismatch!!"),//;
	OPTIONS_PARSER_ERROR(400,"options parser error"),//
	PARAM_EMAIL_ERROR(400,"param email error"),//
	PARAM_AGE_ERROR(400,"param age error"),//
	OPTION_COUNT_ERROR(400, "options count error!!");//
	//OPTION_COUNT_ERROR(400,"option answer mismatch!!");//;
	
	
	
	private int code;

	private String message;

	private ResMessage(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
