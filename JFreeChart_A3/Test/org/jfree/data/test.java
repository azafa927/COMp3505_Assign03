package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.security.InvalidParameterException;

/*
 * Eclipse has been acting wired and not running tests for Calculate Column Total Class. 
 * The only way I was able to solve it was by naming this test class "test". Sorry for the inconvenience
 */
class test {

	private Values2D value;
	private Values2D invalidData;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		value = mock(Values2D.class);
		invalidData =  mock(Values2D.class);
		
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(3);
		
		when(value.getValue(0, 2)).thenReturn(3);
		when(value.getValue(1, 2)).thenReturn(5);
		when(value.getValue(2, 2)).thenReturn(5);

		when(value.getValue(0, 3)).thenReturn(-3);
		when(value.getValue(1, 3)).thenReturn(-5);
		when(value.getValue(2, 3)).thenReturn(-5);

		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalcColTotalWithPositiveNumbers() {
		double actual = DataUtilities.calculateColumnTotal(value, 2);
		double expected = 13;
		assertEquals(expected, actual);
	}

	@Test
	void testCalcColTotalWithNegativeNumbers() {
		double actual = DataUtilities.calculateColumnTotal(value, 3);
		double expected = -13;
		assertEquals(expected, actual);
	}
	@Test
	void testCalcColTotalWithIndexOutOfRange() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
		double actual = DataUtilities.calculateColumnTotal(value, 8);
		double expected = 0;
		assertEquals(expected, actual);
		});
	}
	@Test
	void testCalcColTotalWithInvalidIndex() {
		
		double actual = DataUtilities.calculateColumnTotal(value, 8);
		double expected = 0;
		assertEquals(expected, actual);
		
	}
	@Test
	void testCalcColTotalWithInvalidData() {
		double actual = DataUtilities.calculateColumnTotal(invalidData, -1);
		double expected = 0;
		assertEquals(expected, actual);
		
	}
}
