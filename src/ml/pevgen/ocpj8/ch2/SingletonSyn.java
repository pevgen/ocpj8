package ml.pevgen.ocpj8.ch2;

/**
 * Singleton with lazy load and synchronization (one from several techniques, BASE for exam !!!)
 *
 * @author Polyak
 * @since 13.01.2017
 */
public final class SingletonSyn {        // class is "final" in order to defend changing behavior in subclasses

    // STATIC PRIVATE variable with any name (usually "instance" )
    private static SingletonSyn instanceSyn;

    // PRIVATE constructor
    private SingletonSyn(){}

    // PUBLIC STATIC SYNCHRONIZED (in this case) method with any name with access to instanceSyn variable
    public static synchronized SingletonSyn getInstanceSyn(){
        if (instanceSyn == null) {
            instanceSyn = new SingletonSyn();
        }
        return instanceSyn;
    }

}
