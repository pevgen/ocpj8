package ml.pevgen.ocpj8.ch1;

/**
 * OCP J8. Chapter 01.
 *
 * Example of inner (instance and static) classes and variables
 *
 * @author Polyak Evgeny
 * @since 12.01.2017
 */
public class OuterAndInner {

    /**
     * Inner INSTANCE class has some limitations
     */
    public class InnerInstance {
        // public static String innerStaticVariable = "static variable in instance inner class"; // NOT COMPILE  as Inner - instance class
        // public static void innerStaticMethod(){}                                              // NOT COMPILE  as Inner - instance class
        public String innerInstanceVariable;
        public void innerInstanceMethod(){}
    }

    /**
     * Inner STATIC class
     */
    public static class InnerStatic {
        public static String innerStaticVariable = "static variable in static inner class"; // OK
        public static void innerStaticMethod(){}                                            // OK
        public String innerInstanceVariable;
        public void innerInstanceMethod(){}
    }

    public static void main(String[] args) {
        OuterAndInner outerAndInner = new OuterAndInner();

        // with new OuterAndInner(), as it is instance inner class
        OuterAndInner.InnerInstance innerInstance = new OuterAndInner().new InnerInstance();

        // creation Inner static class
        OuterAndInner.InnerStatic innerStatic = new OuterAndInner.InnerStatic();
        OuterAndInner.InnerStatic innerStatic2 = new InnerStatic();
    }
}
