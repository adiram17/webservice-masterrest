/**
 * 
 */
package com.masterws.ws.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.masterws.ws.rest.service.HelloService;

/**
 * @author adi.ramadhan
 *
 */
@Path("/hello")
public class HelloResource {
	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
	private HelloService service=new HelloService();
	
	@GET
	@Path("/getHello")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHello(){
		return service.getHelloByService();
	}
	
	@GET
	@Path("/getHello/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getHello(@PathParam("param")String param){
		
		return service.getHelloByService()+", " + param;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/postHello")
	public void postHello(MultivaluedMap<String, String> params){
		String param1=params.getFirst("param1");
		String param2=params.getFirst("param2");
		String param3=params.getFirst("param3");
		Integer param4=Integer.parseInt(params.getFirst("param4")); //String to Integer
		
		System.out.println(param1);
		System.out.println(param2);
		System.out.println(param3);
		System.out.println(param4);
	}
	

}
