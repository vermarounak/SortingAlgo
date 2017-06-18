package com.numbersorting.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.numbersorting.dto.InputOutputDetailsDTO;

/**
 * @author Rounak_Verma. This class used to map result columns with DTO
 *         attributes.
 */
public class InputOutputDetailsDTORowMapper implements RowMapper<InputOutputDetailsDTO> {

	// Method implementation to map every row in result set to DTO Object.
	@Override
	public InputOutputDetailsDTO mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		InputOutputDetailsDTO inputOutputDetailsDTO = new InputOutputDetailsDTO();
		inputOutputDetailsDTO.setSerialNo(rs.getInt("s_no"));
		inputOutputDetailsDTO.setInputValues(rs.getString("input_numbers"));
		inputOutputDetailsDTO.setSortedNumbers(rs.getString("sorted_numbers"));
		return inputOutputDetailsDTO;
	}

}
