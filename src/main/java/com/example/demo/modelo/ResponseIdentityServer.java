package com.example.demo.modelo;

public class ResponseIdentityServer {

	 	private String successful;
	    private ErrorResponseIdentityServer error;
	    private String data;
	    public String getSuccessful() { return successful; }
	    public void setSuccessful(String value) { this.successful = value; }

	    public ErrorResponseIdentityServer getError() { return error; }
	    public void setError(ErrorResponseIdentityServer value) { this.error = value; }

	    public String getData() { return data; }
	    public void setData(String value) { this.data = value; }
}
