// fizzbuzz.js
(function(exports) {
  "use strict";

  function FizzBuzz(number) {
    this.number = number || 0;
  }
  exports.FizzBuzz = FizzBuzz;

  FizzBuzz.prototype = {
    toString: function() {
      if (this.number % 3 == 0) {
    	  return "fizz";
      } else {
      	return "" + this.number;
      }
    }
  };

})(this);
