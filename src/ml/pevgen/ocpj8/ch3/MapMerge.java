package ml.pevgen.ocpj8.ch3;

import java.util.HashMap;
import java.util.Map;

/**
 * Example of working with map.merge(...)
 *
 * no key
 *   - create with default value (BiFunction is not execute)
 * exist key (value null)
 *   - replace with default value (BiFunction is not execute)
 * exist key (value not null, BiFunction return not null)
 *   - replace with BiFunction
 * exist key (value not null, BiFunction null)
 *   - remove key and value
 *
 *
 * @author Polyak Evgeny
 * @since 16.01.2017
 */
public class MapMerge {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("First", "England");
        map.put("Second", null);
        map.put("Third", "USA");

        System.out.print("-----------------------");
        map.forEach((k, v) -> {
            System.out.print("\nk=" + k + ", v=" + v);
        });
        /*
         k=Second, v=null
         k=Third, v=USA
         k=First, v=England
         */

        // no key: add new
        map.merge("Fourth", "Germany", (k, v) -> "Russia");  // Fourth not present in keys --> "Germany"
        // map.merge("Fifth", null, (k, v) -> "Russia");  // !!! NullPointerException

        // key exist, value null: replace null value with default: null -> defaultCountry (BiFunction is not execute)
        map.merge("Second", "defaultCountry", (s, s2) -> null);

        // key exist, value not null: replace value : vOld=England, vNew=defaultCountry
        map.merge("First", "defaultCountry", (vOld, vNew) -> vOld + "_replaced_" + vNew);//k=First, v=England_replaced_defaultCountry


        // remove key and value
        // key exist,value is not null, BiFunction return null
        map.merge("Third", "defaultCountry", (s, s2) -> null);  // remove "Third"

        System.out.print("\n\n------- add ----------------");
        map.forEach((k, v) -> {
            System.out.print("\nk=" + k + ", v=" + v);
        });


        /*
         k=Second, v=defaultCountry
         k=First, v=England_replaced_defaultCountry
         k=Fourth,  v=Germany
         */
    }

}
