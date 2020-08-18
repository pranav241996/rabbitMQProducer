package com.rabbitMQ.entity;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String subject;
	private String body;
	private String mailTo;

	private String mailFrom;
	
	public Message() {
	}
	
	public Message(String subject, String body, String mailTo, String mailFrom) {
		super();
		this.subject = subject;
		this.body = body;
		this.mailTo = mailTo;
		this.mailFrom = mailFrom;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	
	@Override
	public String toString() {
		return "Message [subject=" + subject + ", body=" + body + ", mailTo=" + mailTo + ", mailFrom=" + mailFrom + "]";
	}
}
