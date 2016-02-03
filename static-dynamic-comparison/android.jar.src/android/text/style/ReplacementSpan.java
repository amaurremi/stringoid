/*   */
package android.text.style;
/*   */ 
/*   */

import android.text.TextPaint;

/*   */
/* 5 */ public abstract class ReplacementSpan extends MetricAffectingSpan {
    public ReplacementSpan() {
        throw new RuntimeException("Stub!");
    }

    /*   */
    public abstract int getSize(android.graphics.Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, android.graphics.Paint.FontMetricsInt paramFontMetricsInt);

    /*   */
    public abstract void draw(android.graphics.Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, android.graphics.Paint paramPaint);

    /* 8 */
    public void updateMeasureState(TextPaint p) {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public void updateDrawState(TextPaint ds) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/ReplacementSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */