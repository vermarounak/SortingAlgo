package com.numbersorting.constants;

/**
 * @author Rounak_Verma. This Class contains queries used in the project
 */
public class QueryConstants {

	// Private Constructor to avoid creation of object creation of this class.
	private QueryConstants() {

	}

	/** Query to store results in the database along with input values */
	public static final StringBuilder STORE_SORTED_NUMBERS = new StringBuilder(
			"insert into number_tbl (s_no, input_numbers, sorted_numbers) "
					+ "values (numbersorting_sno_seq.nextval, ?, ?)");

	/** Query to fetch data from the database */
	public static final StringBuilder FETCH_PREVIOUS_RESULTS = new StringBuilder(
			"select s_no, input_numbers, sorted_numbers from number_tbl order by s_no asc");
}
