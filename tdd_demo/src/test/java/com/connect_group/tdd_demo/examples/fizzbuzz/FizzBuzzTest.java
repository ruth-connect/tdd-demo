package com.connect_group.tdd_demo.examples.fizzbuzz;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

	private FizzBuzz fizzBuzz;
	
	@Before
	public void setUp() {
		fizzBuzz = new FizzBuzz();
	}
	
	@Test
	public void shouldReturn1_When1IsPassedIn() {
		assertThat(fizzBuzz.fizzBuzz(1), equalTo("1"));
	}
}
