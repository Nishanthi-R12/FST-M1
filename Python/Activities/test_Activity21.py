"""Create a new test file and write test to validate the following cases:

Sum of two numbers
Difference of two numbers
Product of two numbers
Quotient of two numbers"""

import pytest

#test addition
def test_addition():
    #Initializing two numbers
    num1 = 10
    num2 = 15
    #Adding above numbers
    sum = num1 + num2
    #Assertion
    assert sum == 25

#test subtraction
def test_subtraction():
    #Initializing two numbers
    num1 = 55
    num2 = 25
    #Subtracting above numbers
    diff = num1 - num2
    #Assertion
    assert diff == 30

#test multiplication
def test_multiplication():
    #Initializing two numbers
    num1 = 45
    num2 = 2
    product = num1 * num2
    #Assertion
    assert product == 90

#test division
def test_division():
    #Initializing two numbers
    num1 = 35
    num2 = 7
    div = num1/num2
    #Assertion
    assert div == 5

