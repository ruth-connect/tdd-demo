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

	@Test
	public void shouldReturn2_When2IsPassedIn() {
		assertThat(fizzBuzz.fizzBuzz(2), equalTo("2"));
	}

	@Test
	public void shouldReturn3_When2IsPassedIn() {
		assertThat(fizzBuzz.fizzBuzz(3), equalTo("fizz"));
	}
	
	@Test
	public void shouldReturn5_When5IsPassedIn() {
		assertThat(fizzBuzz.fizzBuzz(5), equalTo("buzz"));
	}
	
	@Test
	public void shouldReturn6_When6IsPassedIn() {
		assertThat(fizzBuzz.fizzBuzz(6), equalTo("fizz"));
	}
	
	@Test
	public void shouldReturn10_When10IsPassedIn() {
		assertThat(fizzBuzz.fizzBuzz(10), equalTo("buzz"));
	}
	
	@Test
	public void shouldReturn15_When15IsPassedIn() {
		assertThat(fizzBuzz.fizzBuzz(15), equalTo("fizz buzz"));
	}
}
