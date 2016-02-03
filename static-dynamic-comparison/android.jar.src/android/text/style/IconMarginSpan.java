/*   */
package android.text.style;
/*   */ 
/*   */

import android.graphics.Bitmap;

/*   */
/* 5 */ public class IconMarginSpan implements LeadingMarginSpan, LineHeightSpan {
    public IconMarginSpan(Bitmap b) {
        throw new RuntimeException("Stub!");
    }

    /* 6 */
    public IconMarginSpan(Bitmap b, int pad) {
        throw new RuntimeException("Stub!");
    }

    /* 7 */
    public int getLeadingMargin(boolean first) {
        throw new RuntimeException("Stub!");
    }

    /* 8 */
    public void drawLeadingMargin(android.graphics.Canvas c, android.graphics.Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, android.text.Layout layout) {
        throw new RuntimeException("Stub!");
    }

    /* 9 */
    public void chooseHeight(CharSequence text, int start, int end, int istartv, int v, android.graphics.Paint.FontMetricsInt fm) {
        throw new RuntimeException("Stub!");
    }
/*   */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/IconMarginSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */