/*    */
package android.graphics;

/*    */
/*    */ public class BlurMaskFilter extends MaskFilter
/*    */ {
    /*    */   public static enum Blur
/*    */ {
        /*  7 */     INNER,
        /*  8 */     NORMAL,
        /*  9 */     OUTER,
        /* 10 */     SOLID;

        /*    */
        private Blur() {
        }
    }

    /* 12 */
    public BlurMaskFilter(float radius, Blur style) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/BlurMaskFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */