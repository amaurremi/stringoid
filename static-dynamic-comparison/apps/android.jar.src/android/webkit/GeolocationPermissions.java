/*    */
package android.webkit;
/*    */ 
/*    */

import java.util.Set;

/*    */
/*    */ 
/*    */ public class GeolocationPermissions
/*    */ {
    /*  8 */   GeolocationPermissions() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static GeolocationPermissions getInstance() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void getOrigins(ValueCallback<Set<String>> callback) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void getAllowed(String origin, ValueCallback<Boolean> callback) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public void clear(String origin) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void allow(String origin) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void clearAll() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface Callback
/*    */ {
        /*    */
        public abstract void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/webkit/GeolocationPermissions.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */