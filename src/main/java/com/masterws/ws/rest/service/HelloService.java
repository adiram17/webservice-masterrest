/**
 * 
 */
package com.masterws.ws.rest.service;

import com.masterws.ws.rest.dao.HelloDao;

/**
 * @author adi.ramadhan
 *
 */
public class HelloService {
	
	private HelloDao dao=new HelloDao();
	
	public String getHelloByService(){
		return dao.getHelloByDao();
	}

}
