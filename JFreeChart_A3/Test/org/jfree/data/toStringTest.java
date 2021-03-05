package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class toStringTest {
	private static final int TIMEOUT = 5;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	@Test
	@Timeout(TIMEOUT)
	void toStingRangePostiveDecNumber() {
		Range range1 = new Range(0.2, 5.5);

		assertAll(() -> assertEquals("Range[0.2,5.5]", range1.toString(), "Testing toString"),
				  () -> assertEquals(0.2, range1.getLowerBound(), "Testing lower Bounds"),
				  () -> assertEquals(5.5, range1.getUpperBound(), "Testing upper Bounds"));
	}
	@Test
	@Timeout(TIMEOUT)
	void toStingRangePostiveNumber() {
		Range range1 = new Range(0.0, 10.0);

		assertAll(() -> assertEquals("Range[0.0,10.0]", range1.toString(), "Testing toString"),
				  () -> assertEquals(0.0, range1.getLowerBound(), "Testing lower Bounds"),
				  () -> assertEquals(10.0, range1.getUpperBound(), "Testing upper Bounds"));
	}
	@Test
	@Timeout(TIMEOUT)
	void toStringRangePostiveNegNumber() {
		Range range = new Range(-1.0, 10.0);
		assertAll(() -> assertEquals("Range[-1.0,10.0]", range.toString(), "Testing toString"),
				  () -> assertEquals(-1.0, range.getLowerBound(), "Testing lower Bounds"),
				  () -> assertEquals(10.0, range.getUpperBound(), "Testing upper Bounds"));
		}
	@Test
	@Timeout(TIMEOUT)
	void toStingRangeNegNumber() {
		Range range1 = new Range(-10.0, -1.0);

		assertAll(() -> assertEquals("Range[-10.0,-1.0]", range1.toString(), "Testing toString"),
				  () -> assertEquals(-10.0, range1.getLowerBound(), "Testing lower Bounds"),
				  () -> assertEquals(-1.0, range1.getUpperBound(), "Testing upper Bounds"));
	}
	@Test
	@Timeout(TIMEOUT)
	void toStingRangeNegDecNumber() {
		Range range1 = new Range(-3.5, -0.5);

		assertAll(() -> assertEquals("Range[-3.5,-0.5]", range1.toString(), "Testing toString"),
				  () -> assertEquals(-3.5, range1.getLowerBound(), "Testing lower Bounds"),
				  () -> assertEquals(-0.5, range1.getUpperBound(), "Testing upper Bounds"));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
