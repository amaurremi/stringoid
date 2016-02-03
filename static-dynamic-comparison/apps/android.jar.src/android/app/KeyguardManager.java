/*    */
package android.app;

/*    */
/*    */ public class KeyguardManager {
    public static abstract interface OnKeyguardExitResult {
        public abstract void onKeyguardExitResult(boolean paramBoolean);
/*    */
    }

    /*    */
/*    */
    @Deprecated
/*  7 */ public class KeyguardLock {
        KeyguardLock() {
            throw new RuntimeException("Stub!");
        }

        /*  8 */
        public void disableKeyguard() {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public void reenableKeyguard() {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */ 
/*    */ 
/*    */ 
/* 15 */   KeyguardManager() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 17 */ public KeyguardLock newKeyguardLock(String tag) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public boolean isKeyguardLocked() {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public boolean isKeyguardSecure() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public boolean inKeyguardRestrictedInputMode() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 22 */ public void exitKeyguardSecurely(OnKeyguardExitResult callback) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/app/KeyguardManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */