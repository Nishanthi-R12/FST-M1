"""Write a Python program that throws a NameError."""

try:
    print(x)
except NameError:
    print("x is not yet defined")
