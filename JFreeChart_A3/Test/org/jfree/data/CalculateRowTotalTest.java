package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculateRowTotalTest {
	private Values2D value;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		value = mock(Values2D.class);
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(3);
		when(value.getValue(0, 0)).thenReturn(1);
		when(value.getValue(0, 1)).thenReturn(2);
		when(value.getValue(0, 2)).thenReturn(3);
		when(value.getValue(0, 3)).thenReturn(4);
		when(value.getValue(1, 0)).thenReturn(5);
		when(value.getValue(1, 1)).thenReturn(6);
		when(value.getValue(1, 2)).thenReturn(5);
		when(value.getValue(1, 3)).thenReturn(4);
		when(value.getValue(2, 0)).thenReturn(3);
		when(value.getValue(2, 1)).thenReturn(2);
		when(value.getValue(2, 2)).thenReturn(1);
		when(value.getValue(2, 3)).thenReturn(5);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@CsvSource({"0,10","1,20","2,11","3,0"})
	void testRowSum(int row, double expected) {
		assertEquals(expected, DataUtilities.calculateRowTotal(value, row), .01d, "Sum should be " +expected);
		verify(value, times(4)).getValue(anyInt(), anyInt());
	}
	
	@Test
	void testNegRowsAndColsThrowException() {		
		Values2D v1 = mock(Values2D.class);
		when(v1.getColumnCount()).thenReturn(-1);
		when(v1.getRowCount()).thenReturn(-1);
		when(v1.getValue(-1, -1)).thenReturn(-3);
		
		assertThrows(InvalidParameterException.class, ()->{
			DataUtilities.calculateRowTotal(v1,-1);
		});
	}
	
	@Test
	void testOutOfRangeThrowException() {		
		assertThrows(InvalidParameterException.class, ()->{
			DataUtilities.calculateRowTotal(value,7);
		});
	}
	
	@Test
	void testThrowExceptionWhenNull() {		
		Values2D v1 = null;
		assertThrows(InvalidParameterException.class, ()->{
			DataUtilities.calculateRowTotal(v1, -6);
		});
	}
}
