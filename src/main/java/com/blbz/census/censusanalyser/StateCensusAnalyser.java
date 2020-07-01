package com.blbz.census.censusanalyser;

import com.blbz.census.censusanalyser.exception.CSVBuilderException;
import com.blbz.census.censusanalyser.exception.CensusAnalyserException;
import com.blbz.census.censusanalyser.model.StateCensuCsv;
import com.blbz.census.censusanalyser.model.StateCodesCSV;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class StateCensusAnalyser {

	public StateCensusAnalyser() {
	}

	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			Iterator<StateCensuCsv> censusCSVIterator = csvBuilder.getCSVFileIterator(reader, StateCensuCsv.class);
			return this.getCount(censusCSVIterator);
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.CensusExceptionType.CENSUS_FILE_PROBLEM);
		} catch (CSVBuilderException e) {
			throw new CensusAnalyserException(e.getMessage(), e.type.name());
		}
	}

	public int loadStateCode(String STATECODES_CSVFILE) throws CensusAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(STATECODES_CSVFILE));) {
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			Iterator<StateCodesCSV> stateCSVIterator = csvBuilder.getCSVFileIterator(reader, StateCodesCSV.class);
			return this.getCount(stateCSVIterator);
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.CensusExceptionType.CENSUS_FILE_PROBLEM);
		} catch (CSVBuilderException e) {
			throw new CensusAnalyserException(e.getMessage(), e.type.name());

		}
	}

	private <E> int getCount(Iterator<E> iterator) {
		Iterable<E> csvIterable = () -> iterator;
		int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
		return numOfEntries;
	}
}