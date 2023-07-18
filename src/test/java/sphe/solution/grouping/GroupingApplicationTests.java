package sphe.solution.grouping;

import org.junit.Before;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Lazy
@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
class GroupingApplicationTests {

	@Autowired // field injection is not recommended, but I'm lazy
	private  Number number;


	private final Collection<Integer> expected = Arrays.asList(1,2,3);
	private Collection<Integer> actual ;

	@Before
	public void setup(){
		actual = new ArrayList<>();
	}

	@Test
	void testCollect_WithSpaces(){
		actual = number.collect(" 1 , 2 , 3 ");
		assertEquals(expected, actual);
	}

	@Test
	void testCollect_WithoutSpaces(){
		actual = number.collect("1,2,3");
		assertEquals(expected, actual);
	}

	@Test
	void testCollect_hasNonNumeric(){
		Collection<Integer> input = number.collect("1,a,2,3,b,5,6,8");
		String expected = "1-3,5-6,8";
		String actual = number.summarizeCollection(input);

		assertEquals(expected,actual);
	}

	@Test
	public void testCollect_EmptyInput_ThrowsException(){
		try {
			number.collect("");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Input must contain at least one number", e.getMessage());
		}
		assertThrows(IllegalArgumentException.class ,()-> number.collect(null));
	}

	@Test
	public void testCollect_Null_Input_ThrowException(){
		// Test null input
		try {
			number.collect(null);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Input cannot be Empty/Null", e.getMessage());
		}
		assertThrows(IllegalArgumentException.class ,()-> number.collect(null));
	}

	/*
	* Changed these Test to use the collect() method as a helper method
	* */

	@Test
	public void testSummarizeCollectionEmpty() {

		Collection<Integer> input = new ArrayList<>();

		assertNull(number.summarizeCollection(input));
	}

	@Test
	public void testSummarizeCollectionSingleNumber() {

		Collection<Integer> input = number.collect("1");
		var expected = "1";
		var actual = number.summarizeCollection(input);

		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void testSummarizeCollectionNoDuplicates() {
		Collection<Integer> input = number.collect("1, 2, 3, 4, 5");
		var expected = "1-5";
		var actual = number.summarizeCollection(input);

		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void testSummarizeCollectionMultipleAdjacentDuplicates() {
		Collection<Integer> input = number.collect("1, 2, 2, 3, 3, 3, 4, 5, 5, 6, 6, 6,9,10,11,13");
		var  expected = "1-6,9-11,13";
		var  actual = number.summarizeCollection(input);

		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void testSummarizeCollectionSimpleInput() {
		Collection<Integer> input = number.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
		var expected = "1,3,6-8,12-15,21-24,31";
		var actual = number.summarizeCollection(input);

		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	@Test
	public void testSummarizeCollectionUnorderedWithDuplicates() {
		Collection<Integer> input = number.collect("11,11,10,9,9,1,1, 2,2,2, 13,14,15, 4, 5,6,6,19,19");
		var expected = "1-2,4-6,9-11,13-15,19";
		var actual = number.summarizeCollection(input);

		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	@Test
	void testSummarizeCollectionUnorderedWithEmptyString(){

		assertNull(number.summarizeCollection(Collections.emptyList()));
		assertNull(number.summarizeCollection(null));

	}

}
