/*    */
package android.text.style;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class BulletSpan implements LeadingMarginSpan, android.text.ParcelableSpan {
    public BulletSpan() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public BulletSpan(int gapWidth) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public BulletSpan(int gapWidth, int color) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public BulletSpan(Parcel src) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getSpanTypeId() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getLeadingMargin(boolean first) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void drawLeadingMargin(android.graphics.Canvas c, android.graphics.Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, android.text.Layout l) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */   public static final int STANDARD_GAP_WIDTH = 2;
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/BulletSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */