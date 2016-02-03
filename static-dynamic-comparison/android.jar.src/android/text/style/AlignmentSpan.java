/*    */
package android.text.style;
/*    */ 
/*    */

import android.text.Layout.Alignment;

/*    */
/*    */ public abstract interface AlignmentSpan extends ParagraphStyle {
    /*    */
    public abstract Layout.Alignment getAlignment();

    /*    */
/*  8 */   public static class Standard implements AlignmentSpan, android.text.ParcelableSpan {
        public Standard(Layout.Alignment align) {
            throw new RuntimeException("Stub!");
        }

        /*  9 */
        public Standard(android.os.Parcel src) {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public int getSpanTypeId() {
            throw new RuntimeException("Stub!");
        }

        /* 11 */
        public int describeContents() {
            throw new RuntimeException("Stub!");
        }

        /* 12 */
        public void writeToParcel(android.os.Parcel dest, int flags) {
            throw new RuntimeException("Stub!");
        }

        /* 13 */
        public Layout.Alignment getAlignment() {
            throw new RuntimeException("Stub!");
        }
/*    */
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/AlignmentSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */