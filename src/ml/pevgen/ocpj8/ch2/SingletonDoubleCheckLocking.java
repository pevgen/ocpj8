package ml.pevgen.ocpj8.ch2;

/**
 * Singleton with lazy initialization nad Double checking Lock + volatile (necessarily)
 *  https://ru.wikipedia.org/wiki/Double_checked_locking (ru)
 *  https://en.wikipedia.org/wiki/Double-checked_locking (en)
 *
 *
 * @author Polyak Evgeny
 * @since 13.01.2017
 */
public class SingletonDoubleCheckLocking {

    // VOLATILE necessarily !!!!
    private static volatile SingletonDoubleCheckLocking instance;

    public static SingletonDoubleCheckLocking getInstance() {

        SingletonDoubleCheckLocking localInstance = instance;
        if (localInstance == null) {  // 1-st check

            synchronized (SingletonDoubleCheckLocking.class) {
                localInstance = instance;
                if (localInstance == null) {   // 2-nd check
                    instance = localInstance = new SingletonDoubleCheckLocking();
                }
            }

        }
        return localInstance;
    }
}
