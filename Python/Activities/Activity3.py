"""Make a two-player Rock-Paper-Scissors game.
Remember the rules:
Rock beats scissors
Scissors beats paper
Paper beats rock"""

User1 = input("Enter the name of the first player: ")
User2 = input("Enter the name of the second player: ")
#Get the user choice
User1_Response = input(User1 + ", do you want to choose rock, paper or scissors?").lower()
User2_Response = input(User2 + ", do you want to choose rock, paper or scissors?").lower()

#Run the below algorithm to see who wins
if User1_Response == User2_Response:
    print("It is a tie!")
elif User1_Response == 'rock':
    if(User2_Response == 'scissor'):
        print("Rock wins")
    else:
        print("Paper wins")
elif User1_Response == 'scissor':
    if(User2_Response == 'paper'):
        print("Scissor wins")
    else:
        print("Rock wins")
elif User1_Response == 'paper':
    if(User2_Response == 'rock'):
        print("Paper wins")
    else:
        print("Scissor wins")
else:
    print("Invalid input. You have not entered rock, paper or scissor to play this game")



