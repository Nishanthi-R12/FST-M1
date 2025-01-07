"""In the same file as the previous activity, do the following:

Apply the marker 'activity' to the last 2 test methods.
Run tests based on substring
Run tests based using the 'activity' marker."""

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
@pytest.mark.activity
def test_multiplication():
    #Initializing two numbers
    num1 = 45
    num2 = 2
    product = num1 * num2
    #Assertion
    assert product == 90

#test division
@pytest.mark.activity
def test_division():
    #Initializing two numbers
    num1 = 35
    num2 = 7
    div = num1/num2
    #Assertion
    assert div == 5
