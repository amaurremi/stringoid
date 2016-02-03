/*    */
package android.text.style;
/*    */ 
/*    */

import android.content.res.ColorStateList;

/*    */
/*    */ public class TextAppearanceSpan extends MetricAffectingSpan implements android.text.ParcelableSpan {
    /*  6 */
    public TextAppearanceSpan(android.content.Context context, int appearance) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public TextAppearanceSpan(android.content.Context context, int appearance, int colorList) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public TextAppearanceSpan(String family, int style, int size, ColorStateList color, ColorStateList linkColor) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public TextAppearanceSpan(android.os.Parcel src) {
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
    public String getFamily() {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public ColorStateList getTextColor() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public ColorStateList getLinkTextColor() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getTextSize() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getTextStyle() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void updateDrawState(android.text.TextPaint ds) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public void updateMeasureState(android.text.TextPaint ds) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/TextAppearanceSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */