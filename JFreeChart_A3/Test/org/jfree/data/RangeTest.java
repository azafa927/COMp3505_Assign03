package org.jfree.data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class RangeTest {

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
	public void testWithNegativeLowerAndPositiveUpper() {
		 Range range = new Range(-4.0,3.0);
		 Range expected = new Range(-4.0,3.0);

		 assertEquals(expected, range);
	}
	
	@Test
	public void testWithPositiveLowerAndPositiveUpper() {
		 Range range = new Range(1.0,3.0);
		 Range expected = new Range(1.0,3.0);

		 assertEquals(expected, range);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithPositiveLowerAndNegativeUppeIllegalArgsr() {
		 Range range = new Range(1.0,-3.0);
		 Range expected = new Range(1.0,-3.0);

		 assertEquals(expected, range);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithHigherLowerAndLowerUpperIllegalArgs() {
		 Range range = new Range(3.0, 2.0);
		 Range expected = new Range(3.0, 2.0);

		 assertEquals(expected, range);
	}
	
	


}
