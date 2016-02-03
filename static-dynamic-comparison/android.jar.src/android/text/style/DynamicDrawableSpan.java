/*    */
package android.text.style;
/*    */ 
/*    */

import android.graphics.Paint;

/*    */
/*  5 */ public abstract class DynamicDrawableSpan extends ReplacementSpan {
    public DynamicDrawableSpan() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    protected DynamicDrawableSpan(int verticalAlignment) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public int getVerticalAlignment() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract android.graphics.drawable.Drawable getDrawable();

    /*  9 */
    public int getSize(Paint paint, CharSequence text, int start, int end, android.graphics.Paint.FontMetricsInt fm) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void draw(android.graphics.Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int ALIGN_BOTTOM = 0;
    /*    */   public static final int ALIGN_BASELINE = 1;
    /*    */   protected final int mVerticalAlignment;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/DynamicDrawableSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */