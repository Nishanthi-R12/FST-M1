# Calculate the sum of all the elements in a list

numbers = list(input("Enter the list of comma separated numbers ").split(", "))
sum = 0
for number in numbers:
    sum += int(number)
print(sum)

