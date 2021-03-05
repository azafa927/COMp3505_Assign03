package org.jfree.data;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class createNumberArrayTest {
	private static final int TIMEOUT = 5;
	private double[] doubleData = {-10.0,-1.0,1.0,3.0,4.0,0.5,50.0,100.0,1000.0};

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	@Test 
	void createNumberArrayExceptionNull() {
		assertThrows(InvalidParameterException.class,()-> DataUtilities.createNumberArray(null));
		
	}
	@Test
	@Timeout(TIMEOUT)
	void createNumberArray() {
		Number[] numberData = DataUtilities.createNumberArray(doubleData);
		//assertEquals(numberData[0], doubleData[0]);
		//assertEquals(numberData[3], doubleData[3]);
		//assertEquals(numberData[7], doubleData[7]);
	
		assertAll(() -> assertEquals(numberData[0], doubleData[0]),
				  () -> assertEquals(numberData[3], doubleData[3]),
				  () -> assertEquals(numberData[2], doubleData[2]),
				  () -> assertEquals(numberData[4], doubleData[4]),
				  () -> assertEquals(numberData[8], doubleData[8]),
				  () -> assertEquals(numberData[7], doubleData[7]));
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}