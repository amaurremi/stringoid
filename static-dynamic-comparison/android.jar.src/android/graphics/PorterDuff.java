/*    */
package android.graphics;

/*    */
/*    */ public class PorterDuff
/*    */ {
    /*    */   public static enum Mode {
        /*  6 */     ADD,
        /*  7 */     CLEAR,
        /*  8 */     DARKEN,
        /*  9 */     DST,
        /* 10 */     DST_ATOP,
        /* 11 */     DST_IN,
        /* 12 */     DST_OUT,
        /* 13 */     DST_OVER,
        /* 14 */     LIGHTEN,
        /* 15 */     MULTIPLY,
        /* 16 */     OVERLAY,
        /* 17 */     SCREEN,
        /* 18 */     SRC,
        /* 19 */     SRC_ATOP,
        /* 20 */     SRC_IN,
        /* 21 */     SRC_OUT,
        /* 22 */     SRC_OVER,
        /* 23 */     XOR;

        /*    */
        private Mode() {
        }
    }

    /* 25 */
    public PorterDuff() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/PorterDuff.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */