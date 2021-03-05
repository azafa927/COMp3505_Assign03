package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EqualsTest {
	private static Range testRange1;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testRange1 = new Range(5,16);
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
	
	@Test
	void testEqualRange() {
		Range testRange2 = new Range(5,16);
		assertTrue(testRange1.equals(testRange2), "Result should be True");
	}
	
	@Test
	void testNullRange() {
		Range testRange2 = null;
		assertFalse(testRange1.equals(testRange2), "Result should be False");
	}

	@ParameterizedTest
	@CsvSource({"2,8","0,0","-10,-5"})
	void testUnequalRange(double lower, double upper) {
		Range testRange2 = new Range(lower,upper);
		assertFalse(testRange1.equals(testRange2), "Result should be False");
	}
	
	
}
