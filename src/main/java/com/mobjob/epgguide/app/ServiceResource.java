package com.mobjob.epgguide.app;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mobjob.epgguide.app.core.ParseCore;
import com.mobjob.epgguide.models.AkisModel;
import com.mobjob.epgguide.models.RequestModel;

@Path("/Service")
public class ServiceResource {
	
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTestText() {

		return "Test Metni";
	}
	
    @POST
    @Path("/getAkisJSON")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<AkisModel> getAkisObjects(ArrayList<RequestModel> request) {
    	
    	System.out.println("Istenilen URL :"+request.get(0).getURL());
    	
    	ArrayList<AkisModel> akisObjects = new ArrayList<AkisModel>();
		ParseCore parseCore = new ParseCore();
	    akisObjects = parseCore.parseAddAllInfo(parseCore.getDocument(request.get(0).getURL()));
	    
	   
    	return akisObjects; 
    } 	
    
    @GET
    @Path("/getAkisStringGET")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String getAkisObjectsString() {

    	System.out.println("String Get Cagrildi");

    	return "GET STRING DATA"; 
    } 
    
    @POST
    @Path("/getAkisJsonArray")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<AkisModel> getAkisObjectsString1(ArrayList<RequestModel> request) {
    	
    	System.out.println("Istenilen URL :"+request.get(0).getURL());
    	
    	ArrayList<AkisModel> akisObjects;
		ParseCore parseCore = new ParseCore();
	    akisObjects = parseCore.parseAddAllInfo(parseCore.getDocument(request.get(0).getURL()));

    	return akisObjects; 
    }
}
