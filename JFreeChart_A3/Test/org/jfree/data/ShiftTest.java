package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ShiftTest {
	private Range range;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//Range range = new Range(0,10); 
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
	void testShiftWithPositive() {
		Range baseRange = new Range(0,10);
		Range actual = Range.shift(baseRange, 2);
		Range expected = new Range(2,12);
		assertEquals(expected, actual);
	}
	@Test
	void testShiftWithNegativeZeroCrossingProhibited() {
		Range baseRange = new Range(1,10);
		Range actual = Range.shift(baseRange, -2);
		Range expected = new Range(0,10);
		assertEquals(expected, actual);
	}
	@Test
	void testShiftWithPositiveZeroCrossingProhibited() {
		Range baseRange = new Range(-3,-1);
		Range actual = Range.shift(baseRange, 2);
		Range expected = new Range(-1,0);
		assertEquals(expected, actual);
	}
	@Test
	void testShiftWithPositiveDouble() {
		Range baseRange = new Range(0,10);
		Range actual = Range.shift(baseRange, 2.5);
		Range expected = new Range(2.5,12.5);
		assertEquals(expected, actual);
	}
	@Test
	void testShiftWithNegativeDouble() {
		Range baseRange = new Range(3,10);
		Range actual = Range.shift(baseRange, -2.5);
		Range expected = new Range(0.5,7.5);
		assertEquals(expected, actual);
	}
	@Test
	public void testInvalidParameterException() {
		Assertions.assertThrows(InvalidParameterException.class, () -> {
			Range baseRange = null;
			Range actual = Range.shift(baseRange, -2.5);
			
		});
	}
	@Test
	void testShiftWithZeroCrossingTrue() {
		boolean allowZeroCrossing = true;
		Range baseRange = new Range(-3,-1);
		Range actual = Range.shift(baseRange, 2, allowZeroCrossing);
		Range expected = new Range(-1,1);
		assertEquals(expected, actual);
	}
	@Test
	void testShiftWithNegativeZeroCrossingTrue() {
		boolean allowZeroCrossing = true;
		Range baseRange = new Range(1,3);
		Range actual = Range.shift(baseRange, -2, allowZeroCrossing);
		Range expected = new Range(-1,1);
		assertEquals(expected, actual);
	}
	@Test
	void testShiftWithZeroCrossingFalse() {
		boolean allowZeroCrossing = false;
		Range baseRange = new Range(-3,-1);
		Range actual = Range.shift(baseRange, 2, allowZeroCrossing);
		Range expected = new Range(-1,0);
		assertEquals(expected, actual);
	}
	@Test
	void testShiftWithNegativeZeroCrossingFalse() {
		boolean allowZeroCrossing = false;
		Range baseRange = new Range(1,3);
		Range actual = Range.shift(baseRange, -2, allowZeroCrossing);
		Range expected = new Range(0,1);
		assertEquals(expected, actual);
	}
	
}
