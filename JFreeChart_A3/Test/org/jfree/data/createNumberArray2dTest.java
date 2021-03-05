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

class createNumberArray2dTest {
	private static final int TIMEOUT = 5;
	private double[][] doubleData = { { 1.0, 2.0, 3.0,50.0,100.0,1000.0 }, 
					                  { 4.0, 5.0, 6.0,4.0,0.5 }, 
					                  { 7.0,-10.0,-1.0,1.0,3.0} };

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

	}
	@Test 
	void  createNumberArray2dExceptionNull() {
		assertThrows(InvalidParameterException.class,()->DataUtilities.createNumberArray2D(null));
	}
	@Test
	@Timeout(TIMEOUT)
	void createNumberArray2D() {
		Number[][] numberData = DataUtilities.createNumberArray2D(doubleData);

		//assertEquals(numberData[0][0], doubleData[0][0]);
	
		assertAll(() -> assertEquals(numberData[0][0], doubleData[0][0]),
				  () -> assertEquals(numberData[1][2], doubleData[1][2]),
				  () -> assertEquals(numberData[0][5], doubleData[0][5]),
				  () -> assertEquals(numberData[1][2], doubleData[1][2]),
				  () -> assertEquals(numberData[0][3], doubleData[0][3]),
				  () -> assertEquals(numberData[2][2], doubleData[2][2]));

	} 

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
