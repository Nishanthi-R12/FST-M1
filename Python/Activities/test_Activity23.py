"""Create a new test file and do the following:

Create a fixture that initializes a list containing numbers from 0-10.
Write a test method asserting that the sum of that list is 55
Once you confirm that the test passes, move the fixture into the conftest.py file and rerun the test."""

import pytest

#Create fixture
@pytest.fixture
def num_list():
    # Create list
    int_List = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    #alternative is, int_list = list(range(11))
    return int_List
#Writing test method
def test_sum(num_list):
    #initialize sum
    sum=0
    #Add number in the list
    for n in num_list:
        sum = sum + n
    #Assertion
    assert sum == 55