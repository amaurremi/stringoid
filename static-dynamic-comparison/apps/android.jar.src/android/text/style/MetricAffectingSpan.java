/*   */
package android.text.style;
/*   */ 
/*   */

import android.text.TextPaint;

/*   */
/*   */ public abstract class MetricAffectingSpan extends CharacterStyle implements UpdateLayout {
    /* 6 */
    public MetricAffectingSpan() {
        throw new RuntimeException("Stub!");
    }

    /*   */
    public abstract void updateMeasureState(TextPaint paramTextPaint);

    /* 8 */
    public MetricAffectingSpan getUnderlying() {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/MetricAffectingSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */