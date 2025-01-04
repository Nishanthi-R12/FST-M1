"""Write a function sum() such that it can accept a list of elements and print the sum of all elements"""

#Calculate sum of numbers
def sum(numbers):
    x = 0
    for number in numbers:
        x+=number
    return x

#List of nnumbers
numList = [10, 23, 12,34, 11]
print("Elements in the list is: ", numList)
#Call the function with numlist as argument
result = sum(numList)

print("The sum of all the elements in the list is: ", result)
