package com.example.quiz12.vo;

import java.util.List;

public class FeebackRes extends BasicRes 
{
	private List<FeebackVo> feebackVo;

	public FeebackRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeebackRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public FeebackRes(int code, String message ,List<FeebackVo> feebackVo) {
		super(code,message);
		this.feebackVo = feebackVo;
	}

	public List<FeebackVo> getFeebackVo() {
		return feebackVo;
	}
	
	
}
