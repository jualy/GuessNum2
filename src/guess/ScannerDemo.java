package guess;

import java.io.FilenameFilter;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();

        System.out.println("Hello, " + userName + "!");
boolean isLena = userName.equalsIgnoreCase("Lena");
if (isLena) {
    System.out.println("You are Lena");
}   else {
    System.out.println("You are not Lena");
}

        System.out.println("Enter your favourite number");
        int favNum = scanner.nextInt();
        System.out.println("I know your favourite number. It is " + favNum);

    }
}
