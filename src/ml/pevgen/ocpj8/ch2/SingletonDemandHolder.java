package ml.pevgen.ocpj8.ch2;

/**
 * Singleton with lazy load and om demand holder : https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 *  (problems can appear in with exceptions in constructor)
 * @author Polyak
 * @since 13.01.2017
 */
public final class SingletonDemandHolder {        // class is "final" in order to defend changing behavior in subclasses


    // PRIVATE constructor
    private SingletonDemandHolder(){}


    private static class Holder {
        // STATIC PRIVATE variable with any name (usually "instance" )
        private final static SingletonDemandHolder instanceDemandHolder = new SingletonDemandHolder();
    }

    // PUBLIC STATIC method with any name with access to instanceDoubleChecked variable
    public static SingletonDemandHolder getDemandHolder(){
        return Holder.instanceDemandHolder;                    // first initialization
    }

}
