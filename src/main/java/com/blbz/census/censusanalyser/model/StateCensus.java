package com.blbz.census.censusanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class StateCensus {
	@CsvBindByName(column = "State")
	private String stateName;

	@CsvBindByName(column = "Population", required = true)
	private String population;

	@CsvBindByName(column = "AreaInSqKm")
	private String areaInSqKm;

	@CsvBindByName(column = "DensityPerSqKm", required = true)
	private String densityPerSqKm;

	@CsvBindByName(column = "Tin")
	private int tin;

	public StateCensus() {
	}

	@Override
	public String toString() {
		return "stateName='" + stateName + '\'' + ", population='" + population + '\'' + ", areaInSqKm='" + areaInSqKm
				+ '\'' + ", densityPerSqKm='" + densityPerSqKm + '\'' + ", Tin='" + tin + '\'' + "\n";
	}
}