package testautomatiseringochprogrammering;

import java.util.Scanner;

public class Morsekod {

    private static final MorseLogik mL = new MorseLogik();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        while (true) {
            String userInput;
            System.out.println("What do you want to do? \n1. Convert to morse?\n2. Convert from morse? \n3. Exit? \n4. Information about the program");
            userInput = sc.nextLine();
            int menuChoice;

            try {
                menuChoice = Integer.parseInt(userInput);
                if (menuChoice <= 0)
                    System.out.println("Just enter a positive integer will ya?");

                switch (menuChoice) {
                    case 1 -> {
                        System.out.println("Enter a sentence you want to translate to morse code");
                        userInput = sc.nextLine();
                        if (!userInput.equalsIgnoreCase(mL.replaceInvalidCharacters(userInput))) {
                            System.out.println("The sentence your entered was translated to: ");
                            System.out.println(mL.convertToMorse(mL.replaceInvalidCharacters(userInput)));
                            System.out.println("(The sentence you entered contained some characters that have been modified");
                            System.out.println("The converter only accepts \"a-z(or A-Z)\", \"0-9\" and \".,\"" + "\n");
                        } else {
                            System.out.println("The sentence your entered was translated to: ");
                            System.out.println(mL.convertToMorse(mL.replaceInvalidCharacters(userInput)) + "\n");

                        }
                    }
                    case 2 -> {
                        System.out.println("Enter a sentence you want to translate from morse code");
                        userInput = sc.nextLine();
                        if (mL.validMorse(userInput)) {
                            System.out.println(mL.convertFromMorse(userInput) + "\n");

                        } else {
                            System.out.println("Invalid input!");
                            System.out.println("The Morse-to-text converter only accepts \"*- and blankspace\" characters");

                        }
                    }
                    case 3 -> System.exit(0);
                    case 4 -> {
                        System.out.println("""
                                The text-to-morse converter works like this:\s
                                 1. It only accepts letters "a-z" (upper or lowercase), "0 - 9" and ", ."
                                 2. If you use letters that aren't accepted, the converter should "blank them"\s
                                 3. I don't really know what to write here to be honest.
                                """);
                        System.out.println("""
                                The morse-to-text converter works like this:\s
                                 1. It only accepts *- and blankspaces as valid inputs.
                                 2. * = Represents short. - = Represents long
                                 3. To separate a letter use 1 blankspace. To separate a word, use 2 blankspaces.

                                """);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Only enter valid numbers");


            } catch (Exception e) {
                System.out.println("Ok what the hell. Something wierd happened, you should yell at the programmer");


            }

        }
    }
}
