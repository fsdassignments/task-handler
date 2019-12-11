package com.sbu.taskhandler.errors;

public class ParentNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3607712493184526366L;

	public ParentNotFoundException(Long id) {
		super("Parent Task not found for given id: " + id);
	}
}
