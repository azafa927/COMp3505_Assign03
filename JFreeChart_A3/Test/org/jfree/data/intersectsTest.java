package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class intersectsTest {
	private static final int TIMEOUT = 5;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@ParameterizedTest
	@CsvSource({ "1.0,3.0,'The value is within the range'", 
				 "5.0,5.0,'The value for upper and lower bound is the same'",
			     "4.9, 50,'The value's are out of range'",
			     "-4.0, -2.0,'Both vulues are negatives'",
			     "1.0, 9.0,'The value's are  near the bound of the range'",
			     "-1.0, 11.0,'The value's are over the bound of the range'",
			     "0.0, 10.0,'The values are the same as the given range'"})
	@Timeout(TIMEOUT)
	void validIntersectsRangeTest(double lower, double upper) {
		Range validInter = new Range(0.0, 10.0);
		assertEquals(true, validInter.intersects(lower, upper));

	}
	
	@ParameterizedTest
	@CsvSource({ "1.0,10.0,'The value is within the range but is a invalid input this test'", 
		         "6.0,-6.0,'The value for upper and lower bound is the same'",
		         "0.0,30.0,'The values are the same as the given range'",
		         "4.0, 55.0,'Upper bounf is outside of the assigned range(30)'",
		         "1.0, 29.0,'Testing the  boundry values within the assigned range'",
		         "-1.0, 31.0,'Testing the boundry values outside the assigned range'",
		         "-4.0, -55.0,'Both vulues are negatives'",
		         "10.0,5.0,''" })
	@Timeout(TIMEOUT)
	void invalidIntersectsRangeTest(double lower, double upper) {
		Range validInter = new Range(0.0, 30.0);
		assertEquals(false, validInter.intersects(lower, upper));

	}
	 
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}