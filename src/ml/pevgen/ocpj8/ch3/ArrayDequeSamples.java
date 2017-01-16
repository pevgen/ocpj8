package ml.pevgen.ocpj8.ch3;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 *
 * ArrayDeque samples
 *
 * @author PolyakEvgeny
 * @since 15.01.2017
 */
public class ArrayDequeSamples {

    public static void main(String[] args) {

        ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
        // add to the end (FIFO)
        arrayDeque.add("Germany");
        arrayDeque.add("France");
        arrayDeque.add("England");

        System.out.println("\n--- iterate ---\n");
        for (String anArrayDeque : arrayDeque) {
            System.out.println("Iterator example. Element = " + anArrayDeque);  // Germany/France/England
        }
        // add to the front
        arrayDeque.push("USA");
        arrayDeque.addFirst("Russia");

        System.out.println("\n--- iterate ---\n");
        for (String anArrayDeque : arrayDeque) {
            System.out.println("Iterator example. Element = " + anArrayDeque);  // Russia/USA/Germany/France/England
        }


        System.out.println("\n--- first/last ---\n");
        // get first element (no remove)
        String sFirst = arrayDeque.getFirst();
        System.out.println("arrayDeque.getFirst() = " + sFirst);
        // get last element (no remove)
        String sLast = arrayDeque.getLast();
        System.out.println("arrayDeque.getLast() = " + sLast);


        System.out.println("\n--- iterate: peek and pop ---\n");
        System.out.printf("\nSize(before): %d \n", arrayDeque.size());
        while (arrayDeque.peek() != null) {
            // FIFO
            String ePop = arrayDeque.pop();
            System.out.println("states.pop() = " + ePop);
        }

        System.out.printf("Size(after): %d \n",arrayDeque.size());
//
//
//        ArrayDeque<Person> people = new ArrayDeque<Person>();
//        people.addFirst(new Person("Tom"));
//        people.addLast(new Person("Nick"));
//        for (Person p : people) {
//
//            System.out.println(p.getName());
//        }
    }


//    static class Person {
//
//        private String name;
//
//        public Person(String value) {
//            name = value;
//        }
//
//        String getName() {
//            return name;
//        }
//    }
}
