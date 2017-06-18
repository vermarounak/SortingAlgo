package com.numbersorting.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.numbersorting.dao.NumberSortingDAO;
import com.numbersorting.dto.InputOutputDetailsDTO;
import com.numbersorting.exception.CustomException;

/**
 * @author Rounak_Verma. This class provides implementation of interface and
 *         contains all business logic of the application.
 */

@Service
public class NumberSortingServiceImpl implements NumberSortingService {

	// Autowired DAO Layer through interface.
	@Autowired
	private NumberSortingDAO numberSortingDAO;

	/**
	 * Method implementation to perform sorting of user input.
	 */
	@Override
	public InputOutputDetailsDTO performSorting(
			InputOutputDetailsDTO inputOutputDetailsDTO) throws CustomException {

		int swapCount = 0;
		Map<String, Object> sortedMap = new HashMap<>();
		sortedMap.put("sortedNumbers", null);
		String stringUserInput = inputOutputDetailsDTO.getInputValues();

		long[] numberArray = Arrays
				.stream(stringUserInput.substring(0, stringUserInput.length())
						.split(",")).mapToLong(Long::valueOf).toArray();

		int inputLength = numberArray.length;
		int nextCount;
		for (int outerCount = inputLength; outerCount >= 0; outerCount--) {
			for (int innerCount = 0; innerCount < inputLength - 1; innerCount++) {
				nextCount = innerCount + 1;
				if (numberArray[innerCount] > numberArray[nextCount]) {
					swapCount = swapTwoNumbers(innerCount, nextCount,
							numberArray, swapCount);
				}
			}
		}
		inputOutputDetailsDTO.setSortedNumbers(Arrays.toString(numberArray));
		inputOutputDetailsDTO.setSwapCount(swapCount);
		try {
			storeSortedResult(stringUserInput, numberArray);
		} catch (DataAccessException e) {
			throw new CustomException(e);
		}
		return inputOutputDetailsDTO;
	}

	// Method to swap places of two numbers.
	private int swapTwoNumbers(int innerCount, int nextCount,
			long[] numberArray, int swapCount) {

		long temp;
		temp = numberArray[innerCount];
		numberArray[innerCount] = numberArray[nextCount];
		numberArray[nextCount] = temp;
		swapCount = swapCount + 1;

		return swapCount;
	}

	// Method to store sorted results in the database.
	private void storeSortedResult(String stringUserInput, long[] numberArray)
			throws CustomException {
		try {
			numberSortingDAO.storeSortedResult(stringUserInput, numberArray);
		} catch (DataAccessException e) {
			throw new CustomException(e);
		}
	}

	/** Method implementation for fetching previous results from the database. */
	@Override
	public List<InputOutputDetailsDTO> fetchPreviousResults()
			throws CustomException {
		List<InputOutputDetailsDTO> previousResultsList = null;
		try {
			previousResultsList = numberSortingDAO.fetchPreviousResults();
		} catch (DataAccessException e) {
			throw new CustomException(e);
		}
		return previousResultsList;
	}

}
