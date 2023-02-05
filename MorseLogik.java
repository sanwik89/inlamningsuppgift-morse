package testautomatiseringochprogrammering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class MorseLogik {

    public MorseLogik() {
        initializeMorse();
        initializeReverseMorse();
        initializeValidAscii();


    }

    private final HashMap<Character, String> morseAlfabet = new HashMap<>();
    private final HashMap<String, Character> reverseMorseAlfabet = new HashMap<>();

    private final int[] validAscii = new int[36];

    private List<Integer> validAsciiList;

    //framtida bruk?
    public List getValidAscii() {
        return validAsciiList;
    }

    public void initializeMorse() {
        morseAlfabet.put('A', "*-");
        morseAlfabet.put('B', "-***");
        morseAlfabet.put('C', "-*-*");
        morseAlfabet.put('D', "-**");
        morseAlfabet.put('E', "*");
        morseAlfabet.put('F', "**-*");
        morseAlfabet.put('G', "--*");
        morseAlfabet.put('H', "****");
        morseAlfabet.put('I', "**");
        morseAlfabet.put('J', "*---");
        morseAlfabet.put('K', "-*-");
        morseAlfabet.put('L', "*-**");
        morseAlfabet.put('M', "--");
        morseAlfabet.put('N', "-*");
        morseAlfabet.put('O', "---");
        morseAlfabet.put('P', "*--*");
        morseAlfabet.put('Q', "--*-");
        morseAlfabet.put('R', "*-*");
        morseAlfabet.put('S', "***");
        morseAlfabet.put('T', "-");
        morseAlfabet.put('U', "**-");
        morseAlfabet.put('V', "***-");
        morseAlfabet.put('W', "*--");
        morseAlfabet.put('X', "-**-");
        morseAlfabet.put('Y', "-*--");
        morseAlfabet.put('Z', "--**");
        morseAlfabet.put('1', "*----");
        morseAlfabet.put('2', "**---");
        morseAlfabet.put('3', "***--");
        morseAlfabet.put('4', "****-");
        morseAlfabet.put('5', "*****");
        morseAlfabet.put('6', "-****");
        morseAlfabet.put('7', "--***");
        morseAlfabet.put('8', "---**");
        morseAlfabet.put('9', "----*");
        morseAlfabet.put('0', "-----");
        morseAlfabet.put('.', "*-*-*-");
        morseAlfabet.put(',', "--**--");
        morseAlfabet.put('?', "**--**");


    }

    public void initializeValidAscii() {
        int alphabetAscii = 65;
        int numbersAscii = 48;
        validAscii[34] = 44;
        validAscii[35] = 46;
        validAsciiList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            validAscii[i] = alphabetAscii;
            alphabetAscii++;
        }
        for (int i = 25; i < 34; i++) {
            validAscii[i] = numbersAscii;
            numbersAscii++;
        }
        for (int i = 0; i < validAscii.length; i++) {
            validAsciiList.add(validAscii[i]);
        }

    }

    public void initializeReverseMorse() {
        reverseMorseAlfabet.put("*-", 'A');
        reverseMorseAlfabet.put("-***", 'B');
        reverseMorseAlfabet.put("-*-*", 'C');
        reverseMorseAlfabet.put("-**", 'D');
        reverseMorseAlfabet.put("*", 'E');
        reverseMorseAlfabet.put("**-*", 'F');
        reverseMorseAlfabet.put("--*", 'G');
        reverseMorseAlfabet.put("****", 'H');
        reverseMorseAlfabet.put("**", 'I');
        reverseMorseAlfabet.put("*---", 'J');
        reverseMorseAlfabet.put("-*-", 'K');
        reverseMorseAlfabet.put("*-**", 'L');
        reverseMorseAlfabet.put("--", 'M');
        reverseMorseAlfabet.put("-*", 'N');
        reverseMorseAlfabet.put("---", 'O');
        reverseMorseAlfabet.put("*--*", 'P');
        reverseMorseAlfabet.put("--*-", 'Q');
        reverseMorseAlfabet.put("*-*", 'R');
        reverseMorseAlfabet.put("***", 'S');
        reverseMorseAlfabet.put("-", 'T');
        reverseMorseAlfabet.put("**-", 'U');
        reverseMorseAlfabet.put("***-", 'V');
        reverseMorseAlfabet.put("*--", 'W');
        reverseMorseAlfabet.put("-**-", 'X');
        reverseMorseAlfabet.put("-*--", 'Y');
        reverseMorseAlfabet.put("--**", 'Z');
        reverseMorseAlfabet.put("*----", '1');
        reverseMorseAlfabet.put("**---", '2');
        reverseMorseAlfabet.put("***--", '3');
        reverseMorseAlfabet.put("****-", '4');
        reverseMorseAlfabet.put("*****", '5');
        reverseMorseAlfabet.put("-****", '6');
        reverseMorseAlfabet.put("--***", '7');
        reverseMorseAlfabet.put("---**", '8');
        reverseMorseAlfabet.put("----*", '9');
        reverseMorseAlfabet.put("-----", '0');
        reverseMorseAlfabet.put("*-*-*-", '.');
        reverseMorseAlfabet.put("--**--", ',');
        reverseMorseAlfabet.put("**--**", '?');


    }

    public HashMap getMorseHashmap() {
        return morseAlfabet;
    }

    public HashMap getReverseMorseHashmap() {
        return reverseMorseAlfabet;
    }

    public String convertToMorse(String input) {
        input = input.toUpperCase();
        String output = "";

        for (int i = 0; i < input.length(); i++) {

            if (getMorseHashmap().containsKey(input.charAt(i)) && i < input.length() - 1) {

                output += getMorseHashmap().get(input.charAt(i));
                output += " ";
            } else if (getMorseHashmap().containsKey(input.charAt(i))) {
                output += getMorseHashmap().get(input.charAt(i));
            } else if (input.charAt(i) == ' ') {
                output += input.charAt(i);
            }
        }


        return output;
    }

    public String convertFromMorse(String input) {
        input = input.replaceAll("  ", "X");
        String[] whiteSpaces = input.split("X"); //skapar en ny array för att särskilja dubbla whitespace
        String output = "";
        boolean lastIteration = false; //ser till att " " inte läggs till vid sista Stringen.
        for (int i = 0; i < whiteSpaces.length; i++) {
            String[] splitInput = whiteSpaces[i].split("\s");


            for (String s : splitInput) {
                if (i == whiteSpaces.length - 1 && s == splitInput[splitInput.length - 1]) lastIteration = true;

                if (lastIteration == true) {
                    output += getReverseMorseHashmap().get(s);
                    break;

                } else if (getReverseMorseHashmap().containsKey(s) && Objects.equals(s, splitInput[splitInput.length - 1])) {
                    output += getReverseMorseHashmap().get(s);
                    output += " ";


                } else if (getReverseMorseHashmap().containsKey(s)) {
                    output += getReverseMorseHashmap().get(s);

                }

            }

        }


        return output;
    }

    //metod för att byta ut icke accepterade tecken till " "
    public String replaceInvalidCharacters(String input) {
        char c;
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i); //för att kunna läsa lättare
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                output += c;
            } else if (c >= '0' && c <= '9' || c == '.' || c == ',') {
                output += c;
            } else output += " ";
        }

        return output;
    }

    //denna metod returnerar false om användaren använder något annat tecken än "*" "-" eller blanksteg
    public boolean validMorse(String input) {
        char c;
        boolean result = false;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i); //för att kunna läsa lättare
            if (c == '*' || c == '-') {
                result = true;
            } else if (c == ' ') {
                result = true;
            } else return false;
        }

        return result;
    }


}

