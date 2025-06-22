import java.util.Random;
import java.util.*;
public class NumberGame
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        final int lower_bound=1;
        final int upper_bound=100;
        final int max_attempts=7;
        int roundsWon=0;
        int roundsPlayed=0;
        System.out.println("Welcome to the Number Game!");
        System.out.println("Try to guess the number between " + lower_bound + " and " + upper_bound + ".");
        System.out.println("You have " + max_attempts + " attempts per round.");
        System.out.println();
        boolean playAgain=true;
        while(playAgain)
        {
            roundsPlayed++;
            int targetNumber=random.nextInt(upper_bound - lower_bound + 1) + lower_bound;
            int attempts=0;
            boolean guessedCorrectly=false;
            System.out.println("Round " + roundsPlayed + " begins!");
            while(attempts<max_attempts)
            {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int guess;
                if(sc.hasNextInt())
                {
                    guess=sc.nextInt();
                    if(guess<lower_bound||guess>upper_bound)
                    {
                        System.out.println("Please enter a number between " + lower_bound + " and " + upper_bound + ".");
                        attempts--;
                        continue;
                    }
                }
                else
                {
                    System.out.println("Invalid input. Please enter an integer.");
                    sc.next();
                    attempts--;
                    continue;
                }
                if(guess==targetNumber)
                {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } 
                else if(guess<targetNumber)
                {
                    System.out.println("Too low! Try a higher number.");
                }
                else
                {
                    System.out.println("Too high! Try a lower number.");
                }
            }
            if(!guessedCorrectly)
            {
                System.out.println("Sorry! You've used all your attempts. The correct number was: " + targetNumber);
            }
            System.out.println("Score: " + roundsWon + " wins out of " + roundsPlayed + " rounds played.");
            System.out.print("Do you want to play another round? (y/n): ");
            String response=sc.next();
            if(!(response.equalsIgnoreCase("y")||response.equalsIgnoreCase("yes")))
            {
                playAgain=false;
            }
            System.out.println();
        }
        System.out.println("Thanks for playing! Final score: " + roundsWon + " wins out of " + roundsPlayed + " rounds.");
        sc.close();
    }
}