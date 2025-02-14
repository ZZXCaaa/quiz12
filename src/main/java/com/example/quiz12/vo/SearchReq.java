package com.example.quiz12.vo;

import java.time.LocalDate;

public class SearchReq 
{
	private String name;
	private LocalDate starLocalDate;
	private LocalDate endDate;
	
	public String getName() {
		return name;
	}
	public LocalDate getStarLocalDate() {
		return starLocalDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public SearchReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchReq(String name, LocalDate starLocalDate, LocalDate endDate) {
		super();
		this.name = name;
		this.starLocalDate = starLocalDate;
		this.endDate = endDate;
	}
	
	
}
