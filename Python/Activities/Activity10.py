"""Tuple number checker
Given a tuple of numbers, iterate through it and print only those numbers which are divisible by 5"""

#Tuple
Tuple_num = (10, 15, 25, 32, 40, 56)
print("Tuple of numbers are: ", Tuple_num)
print("")
print("Numbers in the tuple that are divisible by 5 are: ")
for num in Tuple_num:
    if(num%5 == 0):
        print(num)
        
