"""Write a program that asks the user how many Fibonnaci numbers to generate and then generates them.
The sequence looks like this: 1, 1, 2, 3, 5, 8, 13, …"""

def fibonnaci(number):
    if number <= 1:
        return number
    else:
        return fibonnaci(number-1) + fibonnaci(number-2)
    
n = int(input("Enter a number: "))

if n<=0:
    print("Please enter a positive number")
else:
    print("Fibonnaci series is: ")
    for i in range(n):
        print(fibonnaci(i))

