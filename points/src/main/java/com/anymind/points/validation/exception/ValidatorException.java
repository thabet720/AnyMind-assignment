package com.anymind.points.validation.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidatorException extends RuntimeException {

	private static final long serialVersionUID = -983221507126554489L;
	private List<String> messageList = new ArrayList<String>();

	public ValidatorException(String message) {
		super(message);
		this.messageList = java.util.Collections.singletonList(message);
	}

	public ValidatorException(List<String> errors) {
		super(errors.get(0));
		this.messageList = errors;
	}

	public List<String> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}

}
