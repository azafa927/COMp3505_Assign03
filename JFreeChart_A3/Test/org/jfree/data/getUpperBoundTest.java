package org.jfree.data;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class getUpperBoundTest {
	private static final int TIMEOUT = 5;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Timeout(TIMEOUT)
	void getUpperBoundBothPostiveNumber() {
		Range range1 = new Range(2.0, 5.0);
		Double actual = range1.getUpperBound();
		Double excepted = 5.0;
		assertEquals(excepted, actual);

	}

	@Test
	@Timeout(TIMEOUT)
	void getUpperBoundAllSameNumber() {
		Range range1 = new Range(4.0, 4.0);
		Double actual = range1.getUpperBound();
		Double excepted = 4.0;
		assertEquals(excepted, actual);

	}

	@Test
	@Timeout(TIMEOUT)
	void getUpperBoundBothNegNumber() {
		Range range1 = new Range(-4.0, -2.0);
		Double actual = range1.getUpperBound();
		Double excepted = -2.0;
		assertEquals(excepted, actual);

	}

	@Test
	@Timeout(TIMEOUT)
	void getUpperBoundBothNegNumberTwo() {
		Range range1 = new Range(-12.0, -4.0);
		Double actual = range1.getUpperBound();
		Double excepted = -4.0;
		assertEquals(excepted, actual);
	}

	@Test
	@Timeout(TIMEOUT)
	void getUpperBoundDecNumber() {
		Range range1 = new Range(0.7, 1.5);
		Double actual = range1.getUpperBound();
		Double excepted = 1.5;
		assertEquals(excepted, actual);
	}

	@Test
	@Timeout(TIMEOUT)
	void getUpperBoundNegDecNumber() {
		Range range1 = new Range(-2.7, -1.5);
		Double actual = range1.getUpperBound();
		Double excepted = -1.5;
		assertEquals(excepted, actual);
	}

	@Test
	@Timeout(TIMEOUT)
	void getUpperBoundPostiveNegNumber() {
		Range range1 = new Range(-2.0, 4.0);
		Double actual = range1.getUpperBound();
		Double excepted = 4.0;
		assertEquals(excepted, actual);

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
}