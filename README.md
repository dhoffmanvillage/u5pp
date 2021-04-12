# Unit 5 Programming Project

For this project, you will be writing three different classes: `Dice`, `Card`, and `MyMath`. Make sure to properly JavaDoc your code and to use proper data encapsulation.

## PART A - `Dice.java`

For **Part A** you are going to complete the class `Dice`. This class represents an *n*-sided dice. You will need to complete:

1. The constructors. You will write four, overloaded constructors. The constructors will set instance variables either to the default values or to value given by the parameter.
   - **Default Values:**
      - `numSides: 6`, `startingSide: 1`, `color: "green"`
   - **Constructors**
      - `Dice()`
      - `Dice(int numSides)`
      - `Dice(int numSides, int startingSide)`
      - `Dice(int numSides, int startingSide, String color)`
2. The accessors/getters. You will need to create the following methods to get the values in the instance variables.
   - `int getSides()` returns the number of sides the `Dice` has
   - `int getCurrentSide()` returns the current "face up" side of the `Dice`
   - `String getColor()` returns the color of the `Dice`
   - `String toString()` returns the phrase "The <`color`> <`numSides`>-sided dice is showing <`currentSide`>"
   - `boolean equals(Dice d)` returns `true` if both `this` `Dice` and `d` have the same `currentSide`, and `false` otherwise
3. The mutators/setters. You will need to create the following methods that will change/update the instance variables of your class.
   - `int roll()` Changes the `currentSide` to a random number between [`1`, `numSides`] and returns that number
   - `void changeSide(int num)` changes the `currentSide` to `num` if num is between [`1`, `numSides`], otherwise it does nothing
   - `void changeColor(String color)` changes the current `color` to the value in the parameter
   - `void changeNumSides(int num)` changes the number of sides on the `Dice` to `num`

You may include any other `private` methods and instance variables you think applicable. You should have nothing else that is `public` other than what is listed above.

## PART B - `Card.java`

For **Part B** you are going to complete the class `Card`. This class represents a playing card from a standard 52-Card deck. You will need to complete:

1. The constructors. You will write three, overloaded constructors. The constructors will set instance variables either to the default values or to value given by the parameter.
   - **Default Values:**
      - `value: 2`, `suit: clubs`
   - **Constructors**
      - `Card()`
      - `Card(String suit)`
      - `Card(String suit, String value)`
2. The accessors/getters. You will need to create the following methods to get the values in the instance variables.
   - `String getValue()` returns the value of the `Card`
   - `String getSuit()` returns the suit of the `Card`
   - `String toString()` returns the phrase "The <`value`> of <`suit`>"
   - `boolean equals(Card c)` returns `true` if both `this` `Card` and `c` have the same `suit` and `value`, and `false` otherwise
3. The mutators/setters. You will need to create the following methods that will change/update the instance variables of your class.
   - `void changeSuit(String suit)` changes the current `suit` to the `suit` in the parameter if that `suit` is a valid `suit` when capitalization is ignored. If that `suit` is invalid, the method does nothing. The method converts the parameter to lowercase before storing.
      - *Valid Inputs*: `clubs`, `diamonds`, `hearts`, or `spades`
   - `void changeValue(String value)` changes the current `value` to the `value` in the parameter if that `value` is a valid `value` when capitalization is ignored. If that `value` is invalid, the method does nothing. The method converts the parameter to lowercase before storing.
      - *Valid Inputs*: `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `jack`, `queen`, `king`, or `ace`

You may include any other `private` methods and instance variables you think applicable. You should have nothing else that is `public` other than what is listed above.

## PART C - `MyMath.java`

For **Part C** you are going to complete the class `MyMath`. This class simulates some of the methods of the `Math` class. You are not permitted to use the `Math` class at all (pretend it doesn't exist). You will need to complete:

- `static int abs(int x)` which returns the absolute value of the parameter.
- `static double abs(double x)` which returns the absolute value of the parameter.
- `static double pow(double base, int exponent)` which raises the base to the power of the exponent. You can assume that the exponent is greater than or equal to 0.
- `static int perfectSqrt(int x)` which returns the square root of x if there is a whole number that is a square root. It returns -1 otherwise.

You may include any other `private` methods and instance variables you think applicable. You should have nothing else that is `public` other than what is listed above.

## GRADING BREAKDOWN

- Attempted code in all **YOUR CODE HERE** areas: 20 points
- Correctly JavaDoc'ed all Code: 20 points
- Has no `public` members other than those specified: 10 points
- Passed all Test Cases: 50 points
