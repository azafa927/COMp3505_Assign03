package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ContainsTest {
	private static Range testRange;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testRange = new Range (5,16);
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
		5,6,10,11,15,16
	})
	void testRangeContainsValue(double value) {
		assertTrue(testRange.contains(value), value + " is outside the Range of (5,16)");
	}
	
	@ParameterizedTest
	@ValueSource(doubles={
		4,17,18,3,-3
	})
	void testRangeDoesNotContainValue(double value) {
		assertFalse(testRange.contains(value), value + " is within the Range of (5,16)");
	}

}
