package io.thingstream.nodered.service;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageCreator {
	
	private static final String METHOD_POST = "POST";
//	private static final String BODY = "{}";
	private static final String HEADER_CONTENT_TYPE = "Content-Type";
	private static final String CONTENT_TYPE_JSON = "application/json";
	
	private URL baseUrl;
	private static ObjectMapper mapper = new ObjectMapper();
	
	public MessageCreator(String componentType, NodeDefinition nd) {
		
		this(componentType, nd, 1880);
		
	}
	
	public MessageCreator(String componentType, NodeDefinition nd, int port) {
		
		try {
			
			baseUrl = new URL("http://127.0.0.1:" + port + "/" + componentType +"/");
			
		} catch (MalformedURLException e) {
			
			// if this fails, we'll swallow the exception here and report it when the createMessage() is called
			baseUrl = null;
			
		}
		
	}
	
	public void createMessage(String nodeId, Map<String, Object> msg) throws IOException {
		
		URL url = new URL(baseUrl, nodeId);
						
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod(METHOD_POST);
		conn.setRequestProperty(HEADER_CONTENT_TYPE, CONTENT_TYPE_JSON);
		
		try(PrintWriter pw = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()))) {
			
			mapper.writeValue(pw, msg);;
			pw.flush();
			
			int rc = conn.getResponseCode();
			if(rc != HttpURLConnection.HTTP_OK) {
				
				throw new IOException("Node-red returned SC: " + rc);
				
			}
		
		} catch(IOException ix) {
			
			throw new IOException("Message create failed", ix);
			
		}
		
	}

}
