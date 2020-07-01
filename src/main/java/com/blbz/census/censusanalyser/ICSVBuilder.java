package com.blbz.census.censusanalyser;

import java.io.Reader;
import java.util.Iterator;

import com.blbz.census.censusanalyser.exception.CensusAnalyserException;

public interface ICSVBuilder<E> {
	public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CensusAnalyserException;
}
