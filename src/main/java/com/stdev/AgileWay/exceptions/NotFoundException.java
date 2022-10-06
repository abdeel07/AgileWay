package com.stdev.AgileWay.exceptions;

public class NotFoundException extends Exception {

	public NotFoundException(String entityName) {
		super("This " + entityName + " not found !");
	}

}
