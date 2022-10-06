package com.stdev.AgileWay.exceptions;

public class AlreadyExistException extends Exception{

	public AlreadyExistException(String entityName) {
		super("This " + entityName + " already exists");
	}
}
