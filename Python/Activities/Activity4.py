"""Enhance the previously written Rock-Paper-Scissors code so that it asks the user if they want to play another round.
If they say 'Yes', the game should begin again.
If they say 'No', the game should exit."""

# Get the name of the user
User1 = input("Enter the name of the first player: ")
User2 = input("Enter the name of the second player: ")

# While looping endlessly
while True:
    # Ask User1's choice
    User1_Response = input(User1 + ", do you want to choose rock, paper or scissors? ").lower()
    
    # Ask User2's choice
    User2_Response = input(User2 + ", do you want to choose rock, paper or scissors? ").lower()
    
    # Run the algorithm to see who wins
    if User1_Response == User2_Response:
        print("It's a tie.")
    elif User1_Response == 'rock':
        if User2_Response == 'scissors':
            print("Rock wins.")
        else:
            print("Paper wins.")
    elif User1_Response == 'scissors':
        if User2_Response == 'paper':
            print("Scissor wins.")
        else:
            print("Rock wins.")
    elif User1_Response == 'paper':
        if User2_Response == 'rock':
            print("Paper wins.")
        else:
            print("Scissor wins.")
    else:
        print("Invalid input! You should enter rock, paper or scissor to play this game, try again.")

    # Ask them if they want to play again
    repeat = input("Do you want to play another round? Yes/No: ").lower()
    
    # If they say yes, don't do anything
    if(repeat == "yes"):
        pass
    # If they say no, exit the game
    elif(repeat == "no"):
        raise SystemExit
    # If they say anything else, exit with an error message.
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit

