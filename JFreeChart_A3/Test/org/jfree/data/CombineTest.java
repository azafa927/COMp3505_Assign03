package org.jfree.data;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CombineTest {

	//private r1 Range;
	
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
	public void combineWithPositiveLowerAndUpperRangesOverlap() {
		Range r1 = new Range(1,3);
		Range r2 = new Range(2,6);
		Range actual = Range.combine(r1, r2);
		Range expected = new Range (1,6);
		assertEquals(expected, actual);	
	}
	
	@Test
	public void combineWithPositiveLowerAndUpperRangesNoOverlap() {
		Range r1 = new Range(1,3);
		Range r2 = new Range(4,6);
		Range actual = Range.combine(r1, r2);
		Range expected = new Range (1,6);
		assertEquals(expected, actual);
	}
	
	@Test
	public void combineWithPositiveLowerAndPostiveUpperRangesWithNoOverlap() {
		Range r1 = new Range(1,3);
		Range r2 = new Range(4,6);
		Range actual = Range.combine(r1, r2);
		Range expected = new Range (1,6);
		assertEquals(expected, actual);
	}
	@Test
	public void combineWithNegativeLowerAndPostiveUpperRangesWithOverlap() {
		Range r1 = new Range(-1,3);
		Range r2 = new Range(-4,6);
		Range actual = Range.combine(r1, r2);
		Range expected = new Range (-4,6);
		assertEquals(expected, actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void combineWithPositveLowerAndNegativeUpperRangesWithOverlap() {
		Range r1 = new Range(1,-3);
		Range r2 = new Range(4,-6);
		Range actual = Range.combine(r1, r2);
		Range expected = new Range (-4,6);
		assertEquals(expected, actual);
	}
	@Test
	public void combineWithNegativeLowerAndNegativeUpperRangesWithOverlap() {
		Range r1 = new Range(-5,-3);
		Range r2 = new Range(-4,-3);
		Range actual = Range.combine(r1, r2);
		Range expected = new Range (-5,-3);
		assertEquals(expected, actual);
	}
//-------------------------------------------------------New test cases--------------
	@Test
	public void combineWithBothRangesEqualToNull() {
		Range r1 = new Range(0,0);
		Range r2 = new Range(0,0);
		r1 = null;
		r2 = null;
		Range rangeShouldBeNull = Range.combine(r1, r2);
		
		assertEquals(null,rangeShouldBeNull);
	}
	@Test
	public void combineWitRange2EqualToNull() {
		Range r1 = new Range(-5,-3);
		Range r2 = new Range(-4,-3);
		r2 = null;
		Range actual = Range.combine(r1, r2);
		Range expected = null;
		assertEquals(null, actual);
	}
	@Test
	public void combineWitRange1EqualToNull() {
		Range r1 = new Range(-5,-3);
		Range r2 = new Range(-4,-3);
		r1 = null;
		Range actual = Range.combine(r1, r2);
		Range expected = r2;
		assertEquals(expected, actual);
	}
	
}
