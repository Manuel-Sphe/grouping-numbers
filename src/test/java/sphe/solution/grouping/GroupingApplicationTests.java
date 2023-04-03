package sphe.solution.grouping;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class GroupingApplicationTests {

	@Autowired // field injection
	private  Number number;


	@Test

	public void testCollect(){
		// Test Valid input

		Collection<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(2);
		expected.add(3);

		//
		Collection<Integer> actual = number.collect("1,2,3");
		assertEquals(expected, actual);

		// Test input with leading/trailing whitespace
		actual = number.collect(" 1 , 2 , 3 ");
		assertEquals(expected, actual);

		// Test input with non-numeric characters
		try {
			number.collect("1,a,2");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("a is not a valid integer", e.getMessage());
		}

		// Test empty input
		try {
			number.collect("");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Input must contain at least one number", e.getMessage());
		}

		// Test null input
		try {
			number.collect(null);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Input cannot be null", e.getMessage());
		}

	}




}
