/*    */
package android.text.style;
/*    */ 
/*    */

import android.os.Parcel;

/*    */
/*  5 */ public class QuoteSpan implements LeadingMarginSpan, android.text.ParcelableSpan {
    public QuoteSpan() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public QuoteSpan(int color) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public QuoteSpan(Parcel src) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int getSpanTypeId() {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int describeContents() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public void writeToParcel(Parcel dest, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getColor() {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getLeadingMargin(boolean first) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public void drawLeadingMargin(android.graphics.Canvas c, android.graphics.Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, android.text.Layout layout) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/QuoteSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */