package org.jfree.data;
import java.security.InvalidParameterException;
import java.util.*;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.mockito.Mockito.*;


class getCumulativePercentagesTest {
	private static final int TIMEOUT = 5;
	private KeyedValues keyedValues;
	private KeyedValues keyedValuesTwo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	@BeforeEach
	void setUp() throws Exception {
		keyedValues = mock(KeyedValues.class); 
		
		when(keyedValues.getItemCount()).thenReturn(3);
		
		when(keyedValues.getValue(0)).thenReturn(5);
		when(keyedValues.getValue(1)).thenReturn(9);
		when(keyedValues.getValue(2)).thenReturn(2);
		
		when(keyedValues.getKey(0)).thenReturn(0);
		when(keyedValues.getKey(1)).thenReturn(1);
		when(keyedValues.getKey(2)).thenReturn(2);
		
		when(keyedValues.getIndex(0)).thenReturn(0);
		when(keyedValues.getIndex(1)).thenReturn(1);
		when(keyedValues.getIndex(2)).thenReturn(2);
		
		ArrayList keyList = new ArrayList<>();
		keyList.add(0);
		keyList.add(1);
		keyList.add(2);

		when(keyedValues.getKeys()).thenReturn(keyList);
	      
	}
	@Test 
	void getCumulativePercentagesExceptionNull() {
		keyedValuesTwo = mock(KeyedValues.class); 
		
		when(keyedValuesTwo.getItemCount()).thenReturn(3);
		
		when(keyedValuesTwo.getValue(0)).thenReturn(5);
		when(keyedValuesTwo.getValue(1)).thenReturn(9);
		when(keyedValuesTwo.getValue(2)).thenReturn(null);
		
		when(keyedValuesTwo.getKey(0)).thenReturn(0);
		when(keyedValuesTwo.getKey(1)).thenReturn(1);
		when(keyedValuesTwo.getKey(2)).thenReturn(2);
		
		when(keyedValuesTwo.getIndex(0)).thenReturn(0);
		when(keyedValuesTwo.getIndex(1)).thenReturn(1);
		when(keyedValuesTwo.getIndex(2)).thenReturn(2);
			
		 	assertThrows(InvalidParameterException.class,()-> DataUtilities.getCumulativePercentages(null));
	}
	@Test 
	@Timeout(TIMEOUT)
	void getCumulativePercentagesWithValue() {
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyedValues);
		
		assertAll(() -> assertEquals(0.3125,actual.getValue(0).doubleValue(),0.1d),
				  () -> assertEquals(0.875,actual.getValue(1).doubleValue(),0.1d),
				  () -> assertEquals(1.0,actual.getValue(2).doubleValue(),0.1d)
				  
				 );
	}
	@Test 
	@Timeout(TIMEOUT)
	void getCumulativePercentagesWithKey() {
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyedValues);
		
		assertAll(() -> assertEquals(0.3125,actual.getKey(0)),
				  () -> assertEquals(0.875,actual.getKey(1)),
				  () -> assertEquals(1.0,actual.getKey(2))
				  
				 );
	}
	@Test 
	@Timeout(TIMEOUT)
	void getCumulativePercentagesWithIndex() {
		
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyedValues);
		
		assertAll(() -> assertEquals(0.3125,actual.getIndex(0)),
				  () -> assertEquals(0.875,actual.getIndex(1)),
				  () -> assertEquals(1.0,actual.getIndex(2))
				  
				 );
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	@AfterEach
	void tearDown() throws Exception {
	}


}
