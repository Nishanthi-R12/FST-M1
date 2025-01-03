# Given a list of numbers, return True if first and last number of a list is same.

ListOfNumbers = list(input("Enter the list of numbers ").split(", "))
# ListOfNumbers = ['10', '20', '30', '40']
print("Given list of numbers are " , ListOfNumbers)

firstElement = (ListOfNumbers[0])
lastElement = (ListOfNumbers[-1])
print("First element is ", firstElement)
print("Last element is ", lastElement)

if(firstElement == lastElement):
    print(True)
else:
    print(False)

