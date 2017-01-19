package ml.pevgen.ocpj8.ch4;

import java.util.stream.Stream;

/**
 * Examples for stream terminal operations: noneMatch,anyMatch,allMatch
 *
 * @author Polyak Evgeny
 * @since 18.01.2017
 */
public class AnyAllNoneSamples {

    public static void main(String[] args) {
        allMatch();
        anyMatch();
        noneMatch();
    }


    public static void noneMatch() {
        System.out.println("---- noneMatch \"a1\", \"a2\", \"b3\"----");
        Stream<String> stream = Stream.of("a1", "a2", "b3");
        System.out.println(stream.noneMatch((s) -> s.contains("2")) + "  // a2 consists \"2\"");  // false - a2 consists "2"

        Stream<String> stream2 = Stream.of("a1", "a2", "b3");
        System.out.println(stream2.noneMatch((s) -> s.contains("4")) + "   // none contains \"4\"");  // true
    }

    public static void anyMatch() {
        System.out.println("---- anyMatch : \"a1\", \"a2\", \"b3\" ----");
        Stream<String> stream = Stream.of("a1", "a2", "b3");
        System.out.println(stream.anyMatch((s) -> s.contains("2")) + "  //  a2 consists \"2\"");  // true - a2 consists "2"

        Stream<String> stream2 = Stream.of("a1", "a2", "b3");
        System.out.println(stream2.anyMatch((s) -> s.contains("4")) + "  // none contains \"4\"");  // false
    }


    public static void allMatch() {
        System.out.println("---- allMatch : generate(() -> \"meow\")----");
        Stream<String> stream = Stream.generate(() -> "meow");
        // as soon as we found the first wrong (not empty) element, just return "false"
        // no need to check all elements
        boolean match = stream.allMatch(String::isEmpty);
        System.out.println("match=" + match);  //output:  match=false

        // infinite loop !!!!
        // т.к. чтобы проверить нет ли какого-нибудь(any) пустого, надо проверить все
        // а все - бесконечная генерация
        //boolean match2 = stream.anyMatch(String::isEmpty);

    }


}
