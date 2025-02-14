package com.example.quiz12.vo;

import java.lang.foreign.Linker.Option;
import java.util.List;

public class StatisticsRes extends BasicRes 
{
	private List<StatisticsVo> statisticsVoList;

	public StatisticsRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatisticsRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public StatisticsRes(int code, String message,List<StatisticsVo> statisticsVoList) {
		super(code, message);
		this.statisticsVoList = statisticsVoList;
	}

	public List<StatisticsVo> getStatisticsVoList() {
		return statisticsVoList;
	}
	
}
