/*   */
package dalvik.system;
/*   */ 
/*   */

import java.io.File;

/*   */
/* 5 */ public class DexClassLoader extends BaseDexClassLoader {
    public DexClassLoader(String dexPath, String optimizedDirectory, String libraryPath, ClassLoader parent) {
        super((String) null, (File) null, (String) null, (ClassLoader) null);
        throw new RuntimeException("Stub!");
/*   */
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/dalvik/system/DexClassLoader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */