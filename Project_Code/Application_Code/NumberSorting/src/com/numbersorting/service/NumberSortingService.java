package com.numbersorting.service;

import java.util.List;

import com.numbersorting.dto.InputOutputDetailsDTO;
import com.numbersorting.exception.CustomException;

/**
 * @author Rounak_Verma. This interface plays the role of Service Layer in the
 *         project and is responsible for performing all business logic.
 */
public interface NumberSortingService {

	// Method used to perform sorting and storing user input and sorted results
	// in the database.
	InputOutputDetailsDTO performSorting(InputOutputDetailsDTO userInput)
			throws CustomException;

	// Method used for fetching previous results from the database.
	List<InputOutputDetailsDTO> fetchPreviousResults() throws CustomException;

}
