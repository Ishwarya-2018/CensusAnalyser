package com.blbz.census.censusanalyser;

public class CSVBuilderFactory {
	public static ICSVBuilder createCSVBuilder() {
		return new OpenCSVBuildr();
	}
}
