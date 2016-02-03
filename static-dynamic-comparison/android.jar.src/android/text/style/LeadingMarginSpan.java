/*    */
package android.text.style;
/*    */ 
/*    */

import android.graphics.Canvas;

/*    */
/*    */ public abstract interface LeadingMarginSpan
/*    */ extends ParagraphStyle
/*    */ {
    /*    */
    public abstract int getLeadingMargin(boolean paramBoolean);

    /*    */
/*    */
    public abstract void drawLeadingMargin(Canvas paramCanvas, android.graphics.Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, boolean paramBoolean, android.text.Layout paramLayout);

    /*    */
/*    */   public static class Standard implements LeadingMarginSpan, android.text.ParcelableSpan {
        /* 13 */
        public Standard(int first, int rest) {
            throw new RuntimeException("Stub!");
        }

        /* 14 */
        public Standard(int every) {
            throw new RuntimeException("Stub!");
        }

        /* 15 */
        public Standard(android.os.Parcel src) {
            throw new RuntimeException("Stub!");
        }

        /* 16 */
        public int getSpanTypeId() {
            throw new RuntimeException("Stub!");
        }

        /* 17 */
        public int describeContents() {
            throw new RuntimeException("Stub!");
        }

        /* 18 */
        public void writeToParcel(android.os.Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /* 19 */
        public int getLeadingMargin(boolean first) {
            throw new RuntimeException("Stub!");
        }

        /* 20 */
        public void drawLeadingMargin(Canvas c, android.graphics.Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, android.text.Layout layout) {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/*    */   public static abstract interface LeadingMarginSpan2
/*    */ extends LeadingMarginSpan, WrapTogetherSpan
/*    */ {
        /*    */
        public abstract int getLeadingMarginLineCount();
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/LeadingMarginSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */