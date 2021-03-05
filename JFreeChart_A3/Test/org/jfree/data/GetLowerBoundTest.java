package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GetLowerBoundTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@CsvSource({"10,11,10","0,1,-1","-10,-9,-9","1,3,5","0,0,0","5,20,6"})
	void testGetLowerBound(double lower, double upper, double expected) {
		Range testRange = new Range (lower,upper);
		assertEquals(expected, testRange.getLowerBound(), "The range's lower value should be " + lower);
	}

}
