package com.GimmalMIR.core;

public class Testexception extends Exception {
	private String filedname;
	private String message;

	public Testexception(String filedname, String errormessage) {
		super(errormessage);
		this.filedname = filedname;
	}

	public Testexception(String errormessage) {
		super(errormessage);
	}

	public String getfiledname() {

		return filedname;
	}

	public void setfiledname(String filedname) {
		this.filedname = filedname;
	}

	public void setmessage(String message) {
		this.message = message;
	}

	public String getmessage() {
		return message;
	}
}
