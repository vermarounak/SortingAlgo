package com.numbersorting.dao;

import java.util.List;

import com.numbersorting.dto.InputOutputDetailsDTO;
import com.numbersorting.exception.CustomException;

/**
 * @author Rounak_Verma. This interface plays the role of DAO Layer in the
 *         project and is responsible for interacting with the database.
 */
public interface NumberSortingDAO {

	// Method used for storing user input and sorted results in the database.
	void storeSortedResult(String inputNumbers, long[] sortedNumbers)
			throws CustomException;

	// Method used for fetching previous results from the database.
	List<InputOutputDetailsDTO> fetchPreviousResults() throws CustomException;

}
