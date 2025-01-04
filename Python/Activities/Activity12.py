"""Write a recursive function to calculate the sum of numbers from 0 to 10"""

#Function to calculate sum
def calculateSum(num):
    if num:
        # Recursive function call
        return (num + calculateSum(num-1))
    else:
        return 0
#Call the function
result = calculateSum(10)
print("The sum of 10 numbers from 0 to 10 is: ", result)
