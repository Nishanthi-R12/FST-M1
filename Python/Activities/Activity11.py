"""Create a Python dictionary that contains a bunch of fruits and their prices.

Write a program that checks if a certain fruit is available or not."""

fruit_shop = {
    "apple": 25, 
    "Banana": 10, 
    "Litchi": 30, 
    "Kiwi": 40}

To_be_checked = input("What are you looking for? ").lower()

if(To_be_checked in fruit_shop):
    print("Yes, the fruit is available")
else:
    print("No, the fruit is not available")
