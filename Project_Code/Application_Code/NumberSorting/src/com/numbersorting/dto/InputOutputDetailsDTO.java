package com.numbersorting.dto;

/**
 * @author Rounak_Verma. This class plays the role of Data Transfer Object and
 *         being used to transfer data from one layer to another.
 *
 */
public class InputOutputDetailsDTO {

	private String inputValues;

	private String sortedNumbers;

	private int swapCount;

	private long processingTime;

	private int serialNo;

	public String getInputValues() {
		return inputValues;
	}

	public void setInputValues(String inputValues) {
		this.inputValues = inputValues;
	}

	public String getSortedNumbers() {
		return sortedNumbers;
	}

	public void setSortedNumbers(String sortedNumbers) {
		this.sortedNumbers = sortedNumbers;
	}

	public int getSwapCount() {
		return swapCount;
	}

	public void setSwapCount(int swapCount) {
		this.swapCount = swapCount;
	}

	public long getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(long processingTime) {
		this.processingTime = processingTime;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
}
