package com.connect_group.tdd_demo.examples.fizzbuzz;

public class FizzBuzz {

	public String fizzBuzz(int number) {
		if (number % 15 == 0) {
			return "fizz buzz";
		} else if (number % 3 == 0) {
			return "fizz";
		} else if (number % 5 == 0) {
			return "buzz";
		} else {
			return new Integer(number).toString();
		}
	}
}
