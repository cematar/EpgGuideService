package com.mobjob.epgguide.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestModel {
	
	private String kanalURL;
	
	public void setURL(String kanalURL) {
		
		this.kanalURL = kanalURL;
	}
	public String getURL() {
		
		return this.kanalURL;
	}

}
