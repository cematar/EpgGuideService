package com.mobjob.epgguide.app.core;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mobjob.epgguide.constants.Constants;
import com.mobjob.epgguide.models.AkisModel;


public class ParseCore {

	// get HTML document from source, return null if can not fetch the source
		public Document getDocument(String sourceURL) {
					
			Document doc = null;
			
			try {
				
				doc = Jsoup.connect(sourceURL).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").get();
						
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return doc;
		}	
		//hurriyet yay�n ak��� bilgilerini ay�klar
		public ArrayList<AkisModel> parseAddAllInfo(Document document) {
			
			ArrayList<AkisModel> akisObjs = new ArrayList<AkisModel>();
			
			Elements elements = document.getElementsByClass(Constants.hurriyetElementClass);
			
			for(Element e : elements) {

				AkisModel akisObj = new AkisModel();
				
				akisObj.setImgSrc(parseImageURLS(e));
				akisObj.setPrgName(parseProgramNames(e));
				akisObj.setPrgSummary(parseSummaries(e));
				akisObj.setPrgTimeline(parseTimelines(e));
				akisObj.setPrgGenre(parseGenres(e));
				
				if(haveSmartSign(e)){
				
				akisObj.setSmartSigns(parseSmartSigns(e));
				
				}	
				
				akisObjs.add(akisObj);
			}
			return akisObjs;
		}
		
		private String parseImageURLS(Element e) {
			
			Elements imageDivs = e.getElementsByClass("image");
			Element imageDiv = imageDivs.get(0);
			Elements imgElements = imageDiv.getElementsByTag("img");
			Element imgElement = imgElements.get(0);
			
			return imgElement.attr("src");
						
		}
		private String parseProgramNames(Element e) {
				
			Elements nameDivs = e.getElementsByClass("TimelineName");
			Element nameDiv = nameDivs.get(0);
			
			return nameDiv.text();
			
		}
		private String parseTimelines(Element e) {
			
			Elements timelineDivs = e.getElementsByClass("TimelineDuration");
			Element timelineDiv = timelineDivs.get(0);
			
			return timelineDiv.text();
			
		}
		private String parseGenres(Element e) {
			
			Elements genreDivs = e.getElementsByClass("TimelineGenre");
			Element  genreDiv =  genreDivs.get(0);
			
			return genreDiv.text();
			
		}
		private String parseSummaries(Element e) {
		
			Elements summaryDivs = e.getElementsByClass("TimelineSummary");
			Element summaryDiv = summaryDivs.get(0);
			
			return summaryDiv.text();
		
		}
		public ArrayList<String> parseSmartSigns(Element signs) {
			
			ArrayList<String> signElements = new ArrayList<String>();
			
			Elements smartSignImgs = signs.select("img[src*=/smartsign/]");
			
			for(Element e : smartSignImgs) {
				
				signElements.add(e.attr("src"));
			}
				
			return signElements;
		}
		public boolean haveSmartSign(Element e) {
			
			boolean flag = false;
			
			Elements smartSignImgs = e.select("img[src*=/smartsign/]");
			
			if(smartSignImgs.size()!=0) {
				
				flag = true;
			}
			
			return flag;
		}
}
