/*    */
package android.graphics;

/*    */
/*    */
@Deprecated
/*    */ public class AvoidXfermode extends Xfermode
/*    */ {
    /*    */   public static enum Mode
/*    */ {
        /*  8 */     AVOID,
        /*  9 */     TARGET;

        /*    */
        private Mode() {
        }
    }

    /* 11 */
    public AvoidXfermode(int opColor, int tolerance, Mode mode) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/AvoidXfermode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */