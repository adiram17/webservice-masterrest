/**
 * 
 */
package com.masterws.ws.rest.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * @author adi.ramadhan
 *
 */
public class PropertiesUtil {
	
	public static void write(String filename, Properties properties){
		OutputStream output = null;
		try {
			output = new FileOutputStream(filename);
			// save properties to project root folder
			properties.store(output, null);
			System.out.println("File written");
	 
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	 
		}
	}
	
	
	public static Properties getProperties(String filename){
		Properties properties = new Properties();
		InputStream input = null;
		try {
	 
			input = new FileInputStream(filename);
	 
			// load a properties file
			properties.load(input);
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return properties;
	}

}
