# ISBN_validity_checker

Checks if the given ISBN number is valid or not.

An ISBN consists of 10 digits separated by "-" each 3 digits.
First 9 digits can assume any value between the range 0-10. 10 is represented as "X".
Each of this digit is assigned a "weight" which begins from "10" and decreases until it reaches "1" (left to right).

Each of this digit is multiplied with its corresponding weight. Next, all of these products are summed up.
The 10th digit is assigned in a way that sum of all these 10 digits is divisible by 11.

What this checker does is:
- check is invalid characters are given
- check if exactly 10 digits have been given. Informs if less or more digits have been given.
- If exactly 10 digits have been given, it assign and multiplies each of those digits with its corresponding weighs. All these products are summed up and checked its divisibility by 11. 
- If its divisible, its evaluated as a valid ISBN number. Otherwise, the right "10th digit" is suggested in order to make it a valid ISBN number.

Note that the code consists of hard-coded in char arrays to show how the output looks like.
Once acquainted with the output, user may try to input your own ISBN number to check its validity. That section is commented out. User may remove the comment slashes to begin checking the validity of their own ISBN number.

Inputs are limited to 13 characters, which means "-" should be included in the inputs given by user along with the digits in the ISBN number.










