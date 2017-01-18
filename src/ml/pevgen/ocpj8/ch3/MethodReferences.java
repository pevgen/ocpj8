package ml.pevgen.ocpj8.ch3;

/**
 * Method references examples: constructor, static methods, instance methods
 *
 * @author Polyak Evgeny
 * @since 15.01.2017
 */
public class MethodReferences {

    public static class Person {

        public Person() {
            System.out.println("Person constructor()");
        }

        public Person(int param) {
            System.out.println("Person constructor with param(int). Param=" + param);
        }

    }


    /**
     * Actually, it is a functional interface (without annotation)
     */
    interface IPersonUse {
        Person createPerson();
    }

    /**
     * Actually, it is a functional interface (without annotation)
     */
    interface IPersonUseWithParam {
        Person createPersonWithParam(int param);
    }


    public static Person staticNewPerson() {
        System.out.println("Create Person in static method \"staticNewPerson\" WITHOUT param");
        return new Person();
    }

    public static Person staticNewPersonWithParam(int param) {
        System.out.println("Create Person in static method \"staticNewPersonWithParam\" WITH param");
        return new Person(param);
    }

    public Person instanceNewPerson() {
        System.out.println("Create Person in instance method \"instanceNewPerson\" WITHOUT param");
        return new Person();
    }

    public Person instanceNewPersonWithParam(int param) {
        System.out.println("Create Person in instance method \"instanceNewPersonWithParam\" WITH param");
        return new Person(param);
    }


    public static void main(String[] args) {
        // constructor without param
        IPersonUse personConstructorRef = Person::new;                // reference  constructor NO param
        Person personObject1 = personConstructorRef.createPerson();   // object

        // constructor with param
        IPersonUseWithParam personConstructorRef2 = Person::new;      // reference  constructor WITH param int
        Person personObject2 = personConstructorRef2.createPersonWithParam(1); // object

        // static method reference without param
        IPersonUse personStaticMethodRef = MethodReferences::staticNewPerson;  // reference static method
        Person personObject3 = personStaticMethodRef.createPerson();     // object, created in static method without param

        // static method reference with param
        IPersonUseWithParam personStaticMethodRef2 = MethodReferences::staticNewPersonWithParam;  // reference static method WITH param int
        Person personObject4 = personStaticMethodRef2.createPersonWithParam(2);              // object, created in static method with param


        // instance method reference without param
        MethodReferences methodReferences = new MethodReferences();
        IPersonUse personInstanceRef = methodReferences::instanceNewPerson;        // reference
        Person personObject5 = personInstanceRef.createPerson();                   // object
        // instance method reference with param
        IPersonUseWithParam personInstanceRef2 = methodReferences::instanceNewPersonWithParam;  // reference
        Person personObject6 = personInstanceRef2.createPersonWithParam(3);        // object
    }


    /*  Output:

    Person constructor()
    Person constructor with param(int). Param=1
    Create Person in static method "staticNewPerson" WITHOUT param
    Person constructor()
    Create Person in static method "staticNewPersonWithParam" WITH param
    Person constructor with param(int). Param=2
    Create Person in instance method "instanceNewPerson" WITHOUT param
    Person constructor()
    Create Person in instance method "instanceNewPersonWithParam" WITH param
    Person constructor with param(int). Param=3

    * */
}
