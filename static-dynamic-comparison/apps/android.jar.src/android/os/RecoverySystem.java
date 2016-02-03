/*    */
package android.os;
/*    */ 
/*    */

import android.content.Context;

/*    */
/*    */ 
/*    */ public class RecoverySystem
/*    */ {
    /*  8 */
    public RecoverySystem() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public static void verifyPackage(java.io.File packageFile, ProgressListener listener, java.io.File deviceCertsZipFile) throws java.io.IOException, java.security.GeneralSecurityException {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public static void installPackage(Context context, java.io.File packageFile) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public static void rebootWipeUserData(Context context) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public static void rebootWipeCache(Context context) throws java.io.IOException {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static abstract interface ProgressListener
/*    */ {
        /*    */
        public abstract void onProgress(int paramInt);
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/os/RecoverySystem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */