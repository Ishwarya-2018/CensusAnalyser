package com.blbz.census.censusanalyser.exception;

public class CSVBuilderException extends Exception {
	public enum CsvExceptionType {
		DELIMITER_ISSUE, UNABLE_TO_PARSE, CENSUS_FILE_PROBLEM
	}

	public CsvExceptionType type;

	public CSVBuilderException(String message, CsvExceptionType type) {
		super(message);
		this.type = type;
	}
}