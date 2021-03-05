package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ConstrainTest {
	private static Range testRange;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testRange = new Range(5,16);
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
	@ValueSource(doubles={
			17,18.5,50
	})
	void testInputsOutsideRangeNearUpperBound(double value) {
		assertEquals(16, testRange.constrain(value),"Result should be 16.0");
	}
	
	
	@ParameterizedTest
	@ValueSource(doubles={
		4,3.4,0,-2,-5,-16
	})
	void testInputsOutsideRangeNearLowerBound(double value) {
		assertEquals(5, testRange.constrain(value),"Result should be 5.0");
	}
	
	@ParameterizedTest
	@ValueSource(doubles={
		5,6,10,11,15,16
	})
	void testInputsWithinRange(double value) {
		assertEquals(value, testRange.constrain(value),"Result should be " + value);
	}
}
