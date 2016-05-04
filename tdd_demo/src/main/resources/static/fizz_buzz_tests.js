var expect = chai.expect;

describe("Fizz Buzz", function() {
  it("should return 1 when supplied with 1", function() {
    var fizzBuzz = new FizzBuzz(1);
    expect(fizzBuzz.toString()).to.equal("1");
  });

  it("should return 2 when supplied with 2", function() {
	    var fizzBuzz = new FizzBuzz(2);
	    expect(fizzBuzz.toString()).to.equal("2");
	   });


  it("should return fizz when supplied with 3", function() {
	    var fizzBuzz = new FizzBuzz(3);
	    expect(fizzBuzz.toString()).to.equal("fizz");
	   });
});
