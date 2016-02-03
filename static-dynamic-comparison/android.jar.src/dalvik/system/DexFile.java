/*    */
package dalvik.system;
/*    */

import java.io.IOException;

/*    */
/*  4 */ public final class DexFile {
    public DexFile(java.io.File file) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  5 */
    public DexFile(String fileName) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public static DexFile loadDex(String sourcePathName, String outputPathName, int flags) throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public Class loadClass(String name, ClassLoader loader) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public java.util.Enumeration<String> entries() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    protected void finalize() throws Throwable {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    public static native boolean isDexOptNeeded(String paramString)
/*    */     throws java.io.FileNotFoundException, IOException;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/dalvik/system/DexFile.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */