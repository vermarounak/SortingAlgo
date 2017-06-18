package com.numbersorting.controller;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.numbersorting.dto.InputOutputDetailsDTO;
import com.numbersorting.exception.CustomException;
import com.numbersorting.logging.LoggerFactory;
import com.numbersorting.logging.LoggerInterface;
import com.numbersorting.service.NumberSortingService;

/**
 * @author Rounak_Verma. This class plays the role of controller in Spring
 *         framework and routes the requests.
 */
@RestController
public class NumberSortingController {

	// Initializing logger to be used in the project
	private static final LoggerInterface ERRORLOG = LoggerFactory
			.getLogger("ERRORLOG");

	// Autowired Service Layer through interface.
	@Autowired
	private NumberSortingService numberSortingService;

	/**
	 * Method used for performing sort operation and store the results in the
	 * database.
	 */
	@RequestMapping(value = "/performSorting", method = RequestMethod.POST)
	public InputOutputDetailsDTO performSorting(@RequestBody String userInput,
			HttpServletRequest req) {
		Instant startTime = Instant.now();
		InputOutputDetailsDTO inputOutputDetailsDTO = null;
		try {

			ObjectMapper objMapper = new ObjectMapper();
			inputOutputDetailsDTO = objMapper.readValue(userInput,
					InputOutputDetailsDTO.class);
			inputOutputDetailsDTO = numberSortingService
					.performSorting(inputOutputDetailsDTO);
		} catch (CustomException | IOException e) {
			ERRORLOG.error("Exception in NumberSortingController | performSorting "
					+ e);
		}
		Instant endTime = Instant.now();
		inputOutputDetailsDTO.setProcessingTime(Duration.between(startTime,
				endTime).toMillis());
		return inputOutputDetailsDTO;
	}

	/**
	 * Method used for fetching results from the database and display to the
	 * user.
	 */
	@RequestMapping(value = "/fetchPreviousResults", method = RequestMethod.POST)
	public List<InputOutputDetailsDTO> fetchPreviousResults(
			HttpServletRequest req) {
		List<InputOutputDetailsDTO> previousResultsList = null;
		try {
			previousResultsList = numberSortingService.fetchPreviousResults();
		} catch (CustomException e) {
			ERRORLOG.error("Exception in NumberSortingController | fetchPreviousResults "
					+ e);
		}
		return previousResultsList;
	}

}