package guess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class GuessNumber {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<GameResult> leaderboard = new ArrayList<>();
    private static File leaderboardFile = new File("leaderboard.txt");
    private static ArrayList<GameResult> Records = new ArrayList<>();
    private static File RecordsFile = new File ("Records.txt");

    public static void main(String[] args) {
        leaderboard();
        Records();

        String name;
        Random random = new Random();
        do {

            System.out.println("Enter your name:");
            name = scanner.next();

            int myNum = random.nextInt(100) + 1;
            System.out.println(myNum);
            System.out.println("I'm thinking a number from 1 to 100. Try to guess it!");
            long startTime = System.currentTimeMillis();
            boolean userWin = false;
            for (int attempt = 1; attempt <= 10; attempt++) {
                System.out.printf("Attempt #%d\n", attempt);
                int userNum = askNumber("Enter your guess", 1, 100);
                if (myNum > userNum) {
                    System.out.println("Your number is too low");
                } else if (myNum < userNum) {
                    System.out.println("Your number is too high");
                } else {
                    long endTime = System.currentTimeMillis();
                    GameResult gr = new GameResult();
                    gr.setName(name);
                    gr.setAttempts(attempt);
                    gr.setDuration(endTime - startTime);
                    leaderboard.add(gr);
                    Records.add(gr);

                    System.out.printf("You won! %d attempts were used.\n", attempt);
                    userWin = true;
                    break;
                }
            }

            if (!userWin) {
                System.out.printf("You lost! My number was %d\n", myNum);
            }
            System.out.print("Do you want to play again? (Y/n) ");
        } while (!scanner.next().equals("n"));

        saveLeaderboard();
        printleaderboard5();

        System.out.println("Good bye!");
    }

    private static void Records() {


    }

    private static void leaderboard() {
        try (var in = new Scanner(leaderboardFile)) {
            while (in.hasNext()) {
                var gr = new GameResult();
                gr.setName(in.next());
                gr.setAttempts(in.nextInt());
                gr.setDuration(in.nextLong());
                leaderboard.add(gr);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read leaderboard");
        }
    }

    private static void saveLeaderboard() {

        try (var out = new PrintWriter(leaderboardFile)) {
            for (var gr : leaderboard) {
                out.printf("%s %d %d\n", gr.getName(), gr.getAttempts(), gr.getDuration());

            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot save leaderboard");
        }
    }


    private static void printleaderboard() {
        leaderboard.sort(
                Comparator
                        .comparingInt(GameResult::getAttempts)
                        .thenComparingLong(GameResult::getDuration)
        );

        for (GameResult gr : leaderboard) {
            System.out.printf("%s \t %d \t %.1f \n", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
        }
    }

    private static void printleaderboard2() {
        leaderboard.sort(
                Comparator
                        .comparingInt(GameResult::getAttempts)
                        .thenComparingLong(GameResult::getDuration)
        );
        var rows = 5;
        for (GameResult gr : leaderboard) {
            rows--;
            if (rows < 0) {
                break;
            }
            System.out.printf("%s \t %d \t %.1f \n", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
        }
    }

    private static void printleaderboard3() {
        leaderboard.sort(
                Comparator
                        .comparingInt(GameResult::getAttempts)
                        .thenComparingLong(GameResult::getDuration)
        );
        var num = Math.min(5, leaderboard.size());
        var subList = leaderboard.subList(0, num);
        for (GameResult gr : subList)


            System.out.printf("%s \t %d \t %.1f \n", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
    }

    private static void printleaderboard4() {
        leaderboard.sort(
                Comparator
                        .comparingInt(GameResult::getAttempts)
                        .thenComparingLong(GameResult::getDuration)
        );

        for (int i = 0; i < 5 && i < leaderboard.size(); i++) {
var gr = leaderboard.get(i);
            System.out.printf("%s \t %d \t %.1f \n", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
        }

    }
    private static void printleaderboard5() {
        leaderboard.stream()
                .sorted (
        Comparator
                .comparingInt(GameResult::getAttempts)
                .thenComparingLong(GameResult::getDuration)
        )

                .limit(5)
                .forEach(gr -> {
                   System.out.printf("%s \t %d \t %.1f \n", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
                  });
    }

    public static int askNumber(String msg, int min, int max) {
        while (true) {
            System.out.print(msg + ":> ");
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
                System.out.println(input + " is not a number");
            }
        }
    }

}
