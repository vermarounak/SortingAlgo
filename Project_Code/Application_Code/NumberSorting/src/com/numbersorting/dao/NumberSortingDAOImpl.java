package com.numbersorting.dao;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.numbersorting.constants.QueryConstants;
import com.numbersorting.dao.mapper.InputOutputDetailsDTORowMapper;
import com.numbersorting.dto.InputOutputDetailsDTO;
import com.numbersorting.exception.CustomException;

/**
 * @author Rounak_Verma. This class provides the implementation of interface and
 *         interacts with the database for storing and retrieving results.
 *
 */
@Repository
public class NumberSortingDAOImpl implements NumberSortingDAO {

	private JdbcTemplate jdbcTemplate;

	// Used to initialize JDBC Template from the data source.
	@Autowired
	public void setDataSource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	/** Method implementation to store user input in the database. */
	@Override
	public void storeSortedResult(String inputNumbers, long[] sortedNumbers)
			throws CustomException {
		try {
			jdbcTemplate
					.update(QueryConstants.STORE_SORTED_NUMBERS.toString(),
							new Object[] { inputNumbers,
									Arrays.toString(sortedNumbers) });
		} catch (DataAccessException e) {
			throw new CustomException(e);
		}
	}

	/** Method implementation to fetch previous results from the database. */
	@Override
	public List<InputOutputDetailsDTO> fetchPreviousResults()
			throws CustomException {
		List<InputOutputDetailsDTO> previousResultsList = null;
		try {
			previousResultsList = jdbcTemplate.query(
					QueryConstants.FETCH_PREVIOUS_RESULTS.toString(),
					new InputOutputDetailsDTORowMapper());
		} catch (DataAccessException e) {
			throw new CustomException(e);
		}
		return previousResultsList;
	}

}
