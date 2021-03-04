package org.jfree.data;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;



public class ExpandTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
/*
	//expand(Range range, double lower, double upper) it should adjust the range of the passed range to the passed lower and upper.
	//if passed a range of(2,6) with the lower (0.25) and upper (0.5)
	//-> new range = [1,8] 
	//why?
	 * 6-2 = 4 
	 * 4 is the range
	 * now 4 * 0.25(LOWER) = 1
	 * 2 - 1 = 1 new lower
	 * now 4 * 0.50(UPPER) = 2 
	 * 6 + 2 = 8 new upper
*/	
	@Test
	public void testWithPositiveLowerAndUpper() {
		Range expected = new Range (1.0, 8.0);
		Range actual = new Range(2.0, 6.0);
		double lower = 0.25;
		double upper = 0.50;
		
		Range rangeAfterExpand = Range.expand(actual, lower, upper);
		
		assertEquals(expected, rangeAfterExpand);
	}
	
	@Test
	public void testWithNegativeLowerAndNegativeUpper() {
		Range expected = new Range (3.0, 4.0);
		Range actual = new Range(2.0, 6.0);
		double lower = - 0.25;
		double upper = - 0.50;
		Range rangeAfterExpand = Range.expand(actual, lower, upper);
		
		assertEquals(expected, rangeAfterExpand);
	}
	//----------------------------------------New test cases--------------------------
	@Test
	public void testWithNegativeLowerAndPositiveUpper() {
		Range expected = new Range(5, 35.0);
		double lower = -1.0;
		double upper = 10.0;
		Range actual = new Range(2.0, 5.0);
		Range rangeAfterExpand = Range.expand(actual, lower, upper);
		
		assertEquals(expected, rangeAfterExpand);
	}
	
	@Test
	public void testWithNullRange() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Range actual = new Range(2.0, 6.0);
			actual = null;
			double lower = 0.25;
			double upper = 0.50;
			
			Range rangeAfterExpand = Range.expand(actual, lower, upper);
		});

	}
}
