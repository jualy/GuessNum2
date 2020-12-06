package guess;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {

    }
    private static Scanner scanner = new Scanner(System.in);
          {

        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();

        System.out.println("Hello, " + userName + "!");

        System.out.println("I am thinking the number from 1 to 100, try to guess it! Do you want to start?");
        while (scanner.next().equals("yes")) {

            System.out.println("Enter number from 1 to 100");
            int userNum = askNumber("Enter your number", 1, 100);
            switch (userNum) {
                case 4:
                    System.out.println("You won!");
                    break;

                default:
                    System.out.println("You lost! Do you want to play again?");
                    while (scanner.next().equals("yes")) {
                        System.out.println("Enter number from 1 to 100");
                        int userNum2 = scanner.nextInt();
                        switch (userNum2) {
                            case 4:
                                System.out.println("You won!");
                                break;

                            default:
                                System.out.println("You lost! My number was 4. Good bye!");
                        }
                    }

            }
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






