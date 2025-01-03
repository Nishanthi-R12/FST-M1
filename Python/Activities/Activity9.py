"""Given a two list of numbers, create a new list such that 
new list should contain only odd numbers from the first list and even numbers from the second list."""

List1 = [10, 11,12,13,14]
List2 = [23,34,45,56,67]
#print the list of numbers
print("")
print("First list of numbers are: ", List1)
print("Second list of numbers are: ", List2)
print("")
List3 = []

#List for Odd Number
for num in List1:
    if(num % 2 == 1):
        List3.append(num)

# List for Even Number
for num in List2:
    if(num % 2 == 0):
        List3.append(num)

print("Result is: ", List3)
print("")
