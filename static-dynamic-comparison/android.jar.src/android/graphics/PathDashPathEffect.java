/*    */
package android.graphics;

/*    */
/*    */ public class PathDashPathEffect extends PathEffect
/*    */ {
    /*    */   public static enum Style
/*    */ {
        /*  7 */     MORPH,
        /*  8 */     ROTATE,
        /*  9 */     TRANSLATE;

        /*    */
        private Style() {
        }
    }

    /* 11 */
    public PathDashPathEffect(Path shape, float advance, float phase, Style style) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/graphics/PathDashPathEffect.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */