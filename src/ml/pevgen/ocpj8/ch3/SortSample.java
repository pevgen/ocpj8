package ml.pevgen.ocpj8.ch3;

import java.util.Arrays;

/**
 * Example for sorting:
 * 1.Numbers
 * 2.Capital letters
 * 3.Others
 *
 * @author Polyak Evgeny
 * @since 17.01.2017
 */
public class SortSample {

    public static void main(String[] args) {
        String[] strings = {"123","Abb","aab"};
        Arrays.sort(strings);
        for (String s : strings){
            System.out.println(s);
        }

        /*
        * 123
        * Abb
        * aab
        *
        * */
    }

}
