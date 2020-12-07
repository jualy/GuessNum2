package guess;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Random random = new Random();
        {

            System.out.println("What is your name?");
            Scanner scanner = new Scanner(System.in);
            String userName = scanner.next();

            System.out.println("Hello, " + userName + "!");

            System.out.println("I want to play! Do you want to start?");
            if (scanner.next().equals("yes"))
                do {
                    int myNum = random.nextInt(100) + 1;
                    System.out.println("I am thinking a number from 1 to 100. Try to guess it");
                    boolean userWin = false;
                    for (int attempt = 1; attempt <= 10; attempt++) {
                        System.out.printf("Attempt #%d.", attempt);
                        int userNum = askNumber("Enter your number", 1, 100);
                        if (myNum > userNum) {
                            System.out.println("Your number is too low");

                        } else if (myNum < userNum) {
                            System.out.println("Your number is too high");
                        } else if (myNum == userNum) {
                            System.out.printf("You won! %d attempts were used.\n", attempt);
                            userWin = true;
                            break;

                        }
                    }
                    if (!userWin) {
                        System.out.printf("You lost! My number was %d\n", myNum);

                    }
                    System.out.println("Do you want to play again? (Yes/no)");

                } while (!scanner.next().equals("no"));
                System.out.println("Good bye " + userName + "!");
        }

    }
public void askYesOrNo(String msg) {
    System.out.println("Did you like the game? (Yes/no)");
    if (!scanner.next().equals("yes")) ;
    {
        System.out.println("Thank you!");

    }
    if (!scanner.next().equals("no")) ;
    {
        System.out.println("I am sorry!");

    }

}

public static int askNumber(String msg, int min, int max) {


        while (true) {

            System.out.print(msg + ":>");
            try {
                int result = scanner.nextInt();
                if (result < min) {
                    System.out.println("Number should not be less than " + min);
                    continue;
                }

                if (result > max) {
                    System.out.println("Number should not be greater than " + max);
                    continue;
                }
                return result;
            } catch (InputMismatchException e) {
                String input = scanner.next();

                System.out.println("This is not a number");
                return 0;

            }
        }
    }
}

