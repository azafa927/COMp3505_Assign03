package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class ExpandToIncludeTest {

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

	@Test
	public void testWithPositiveRangeAndValue() {
		Range expected = new Range (2.0, 10.0);
		double valueMustInclude = 10.0;
		Range actual = new Range(2.0, 5.0);
		Range rangeAfterExpand = Range.expandToInclude(actual, valueMustInclude);
		
		assertEquals(expected, rangeAfterExpand);
	}
	
	
	@Test
	public void testWithPositiveRangeAndNegativeValue() {
		Range expected = new Range (-1.0, 5.0);
		double valueMustInclude = -1.0;
		Range actual = new Range(2.0, 5.0);
		Range rangeAfterExpand = Range.expandToInclude(actual, valueMustInclude);
		
		assertEquals(expected, rangeAfterExpand);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithInvalidRangeAndNegativeValue() {
		double valueMustInclude = -1.0;
		Range actual = new Range(6.0, 5.0);
		Range.expandToInclude(actual, valueMustInclude);
	}
//--------------------------------------------------------------------------------------//New test case
	@Test
	public void testWithNullRange() {
		Range expected = new Range (5.0,5.0);
		double valueMustInclude = 5.0;
		Range actual = new Range(2.0, 5.0);
		actual = null;
		Range rangeAfterExpand = Range.expandToInclude(actual, valueMustInclude);
		
		assertEquals(expected, rangeAfterExpand);
	}
	@Test
	public void testWithPositiveRangeAndValueInsideCurrentRange() {
		Range expected = new Range (2.0, 10.0);
		double valueMustInclude = 5.0;
		Range actual = new Range(2.0, 10.0);
		Range rangeAfterExpand = Range.expandToInclude(actual, valueMustInclude);
		
		assertEquals(expected, rangeAfterExpand);
	}
}
