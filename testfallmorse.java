package testautomatiseringochprogrammering;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testfallmorse {
    @Test
    public void convertAbctoMorse(){
        String expected;
        String actual;


        MorseLogik ml = new MorseLogik();
        expected = "*- -*** -*-*";
        actual = ml.convertToMorse("ABC");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void convertFromMorse(){
        String expected;
        String actual;


        MorseLogik ml = new MorseLogik();
        expected = "ABC DEF";
        actual = ml.convertFromMorse("*- -*** -*-*  -** * **-*");
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void convertFromMorseWithMultipleBlankspaces(){
        String expected;
        String actual;


        MorseLogik ml = new MorseLogik();
        expected = "ABC DEF";
        actual = ml.convertFromMorse("*- -*** -*-*      -** * **-*");
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void convertToMorseWithLowercase(){
        String expected;
        String actual;


        MorseLogik ml = new MorseLogik();
        expected = "*- -*** -*-* -** * **-*";
        actual = ml.convertToMorse("abcdef");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void convertToMorseWithBlankspace(){
        String expected;
        String actual;


        MorseLogik ml = new MorseLogik();
        expected = "*- -*** -*-*  -** * **-*";
        actual = ml.convertToMorse("abc def");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void replaceInvalidCharactersWithSpace(){
        String expected;
        String actual;


        MorseLogik ml = new MorseLogik();
        expected = "hej san123     ";
        actual = ml.replaceInvalidCharacters("hej san123 _'^%");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void validMorseCharacters(){
        boolean expected;
        boolean actual;


        MorseLogik ml = new MorseLogik();
        expected = true;
        actual = ml.validMorse("**** * *--- *** *- -* *-*-*-");
        Assertions.assertEquals(expected, actual);

    }
}


