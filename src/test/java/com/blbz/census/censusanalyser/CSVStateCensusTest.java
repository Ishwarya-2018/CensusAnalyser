package com.blbz.census.censusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.blbz.census.censusanalyser.exception.CensusAnalyserException;
import com.blbz.census.censusanalyser.model.StateCensus;

import java.io.IOException;

public class CSVStateCensusTest {

	public static final String STATECODES_CSVFILE = "E:\\myCodingWorld\\CensusAnalyser\\csvfiles\\StateCode.csv";
	public static final String STATECENSUS_CSVFILE = "E:\\myCodingWorld\\CensusAnalyser\\csvfiles\\IndianCensusData.csv";
	public static final String WRONG_FILE_PATH = "/Wrongfile.txt";

	@Test
	public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
		try {
			int count = StateCensusAnalyser.openCsvBuilder(STATECENSUS_CSVFILE, StateCensus.class);
			System.out.println(count);
			Assert.assertEquals(29, count);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void GivenTheStateCensusCsvFile_IfDoesNotExist_ShouldThrowCensusAnalyserException() throws IOException {
		try {
			int count = StateCensusAnalyser.openCsvBuilder(WRONG_FILE_PATH, StateCensus.class);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			Assert.assertEquals(CensusAnalyserException.CensusExceptionType.NO_SUCH_FILE, e.type);
		}
	}

	@Test
	public void GivenTheStateCensusCsvFile_WhenCorrect_ButFileExtensionIncorrect_ShouldThrowCensusAnalyserException()
			throws IOException {
		try {
			int count = StateCensusAnalyser.openCsvBuilder(STATECODES_CSVFILE, StateCensus.class);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			Assert.assertEquals(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
		}
	}

	@Test
	public void GivenTheStateCensusCSVFile_WhenCorrect_ButDelimiterIncorrect_ReturnsCensusAnalyserException()
			throws IOException {
		try {
			int count = StateCensusAnalyser.openCsvBuilder(STATECENSUS_CSVFILE, StateCensus.class);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			Assert.assertEquals(CensusAnalyserException.CensusExceptionType.DELIMITER_ISSUE, e.type);

		}
	}

	@Test
	public void whenCorrectCensusCSVFile_ButHeaderIncorrect_ShouldReturnFalse() throws IOException {
		try {
			int count = StateCensusAnalyser.openCsvBuilder(STATECENSUS_CSVFILE, StateCensus.class);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			Assert.assertEquals(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
		}
	}
}