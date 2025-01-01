"""Ask the user for a number.
Depending on what number they enter, tell them if the number is an even or odd number."""

a = int(input("Enter a number: "))
if(a%2==1):
    print("The entered number is odd number")
else:
    print("The entered number is even number")
    