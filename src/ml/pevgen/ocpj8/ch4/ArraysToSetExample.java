package ml.pevgen.ocpj8.ch4;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example creation Set from two string-arrays, with null checking array
 *
 * @author Polyak Evgeny
 * @since 22.02.2017
 */
public class ArraysToSetExample {


    public static void main(String[] args) {


        String[] s1 = null;
        String[] s2 = null;

        Set<String> res = Stream.of(s1, s2)
                .filter(Objects::nonNull)  // <-- Filter out null values
                .flatMap(Stream::of)
                .collect(Collectors.toSet());

        assert res != null;
        assert res.size() == 0;

        s1 = new String[]{"1", "2"};
        Set<String> res2 = Stream.of(s1, s2)
                .filter(Objects::nonNull)  // <-- Filter out null values
                .flatMap(Stream::of)       // two arrays to one stream
                .collect(Collectors.toSet());

        assert res2 != null;
        assert res2.size() == 2;

        s2 = new String[]{"3", "4"};
        Set<String> res3 = Stream.of(s1, s2)
                .filter(Objects::nonNull)  // <-- Filter out null values
                .flatMap(Stream::of)       // two arrays to one stream
                .collect(Collectors.toSet());

        assert res3 != null;
        assert res3.size() == 4;
        assert res3.iterator().next() != null;

    }
}
