// fizzbuzz.js
(function(exports) {
  "use strict";

  function FizzBuzz(number) {
    this.number = number || 0;
  }
  exports.FizzBuzz = FizzBuzz;

  FizzBuzz.prototype = {
    toString: function() {
      return "" + this.number;
    }
  };

})(this);
