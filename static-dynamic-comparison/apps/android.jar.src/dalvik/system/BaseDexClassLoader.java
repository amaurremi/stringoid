/*    */
package dalvik.system;
/*    */ 
/*    */

import java.net.URL;

/*    */
/*  5 */ public class BaseDexClassLoader extends ClassLoader {
    public BaseDexClassLoader(String dexPath, java.io.File optimizedDirectory, String libraryPath, ClassLoader parent) {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    protected URL findResource(String name) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    protected java.util.Enumeration<URL> findResources(String name) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public String findLibrary(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    protected synchronized Package getPackage(String name) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/dalvik/system/BaseDexClassLoader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */