package sphe.solution.grouping;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class GroupingApplicationTests {

	@Autowired // field injection
	private  Number number;

	private final Collection<Integer> expected = Arrays.asList(1,2,3);
	private Collection<Integer> actual ;

	@Before
	public void setup(){
		actual = new ArrayList<>();
	}

	@Test
	@DisplayName("Test Valid input")
	void testCollect_1(){
		actual = number.collect("1,2,3");
		assertEquals(expected, actual);
	}
	@Test
	@DisplayName("Input with spaces --valid")
	void testCollect_2(){
		actual = number.collect(" 1 , 2 , 3 ");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Test with Non-numeric chars")
	void testCollect_3(){
		try {
			number.collect("1,a,2");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("a is not a valid integer", e.getMessage());
		}

		number.summarizeCollection(number.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31"));
	}

	@Test
	@DisplayName("Test With empty String")
	public void testCollect_4(){
		try {
			number.collect("");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Input must contain at least one number", e.getMessage());
		}
	}

	@Test
	@DisplayName("Test will null input")
	public void testCollect_5(){
		// Test null input
		try {
			number.collect(null);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Input cannot be null", e.getMessage());
		}
	}




}
