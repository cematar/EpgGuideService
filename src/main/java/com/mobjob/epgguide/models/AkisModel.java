package com.mobjob.epgguide.models;

import java.util.ArrayList;

public class AkisModel {

	private String imgSrc;
	private String prgName;
	private String prgTimeline;
	private String prgGenre;
	private String prgSummary;	
	private ArrayList<String> prgSmartSigns;
	
	public void setSmartSigns(ArrayList<String> signs) {
		
		this.prgSmartSigns = signs;
	}
	
	public ArrayList<String> getPrgSmartSigns(){
		
		return this.prgSmartSigns;
	}
	
	public void setImgSrc(String imgSrc) {
		
		this.imgSrc = imgSrc;	
	}
	public String getImgSrc() {
		
		return this.imgSrc;
	}
	public void setPrgName(String prgName) {
		
		this.prgName = prgName;	
	}
	public String getPrgName() {
		
		return this.prgName;
	}
	
	public void setPrgTimeline(String prgTimeline) {
		
		this.prgTimeline = prgTimeline;	
	}
	public String getPrgTimeline() {
		
		return this.prgTimeline;
	}
	public void setPrgSummary(String prgSummary) {
		
		this.prgSummary = prgSummary;	
	}
	public String getPrgSummary() {
		
		return this.prgSummary;
	}
	public void setPrgGenre(String prgGenre) {
		
		this.prgGenre= prgGenre;	
	}
	public String getPrgGenre() {
		
		return this.prgGenre;
	}

}
