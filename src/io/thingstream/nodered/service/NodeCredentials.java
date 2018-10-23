package io.thingstream.nodered.service;

public class NodeCredentials {
	
	private String username;
	private String password;
	
	public NodeCredentials() {}
	
	public NodeCredentials(String username, String password) {
		
		this.username = username;
		this.password = password;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
