/*    */
package android.text;
/*    */ 
/*    */

import android.graphics.Paint;

/*    */
/*  5 */ public class SpannableStringBuilder implements CharSequence, GetChars, Spannable, Editable, Appendable {
    public SpannableStringBuilder() {
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public SpannableStringBuilder(CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public SpannableStringBuilder(CharSequence text, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public static SpannableStringBuilder valueOf(CharSequence source) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public char charAt(int where) {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int length() {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public SpannableStringBuilder insert(int where, CharSequence tb, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public SpannableStringBuilder insert(int where, CharSequence tb) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public SpannableStringBuilder delete(int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public void clear() {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public void clearSpans() {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public SpannableStringBuilder append(CharSequence text) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public SpannableStringBuilder append(CharSequence text, int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public SpannableStringBuilder append(char text) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public SpannableStringBuilder replace(int start, int end, CharSequence tb) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public SpannableStringBuilder replace(int start, int end, CharSequence tb, int tbstart, int tbend) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public void setSpan(Object what, int start, int end, int flags) {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public void removeSpan(Object what) {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getSpanStart(Object what) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public int getSpanEnd(Object what) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getSpanFlags(Object what) {
        throw new RuntimeException("Stub!");
    }

    /*    */
/* 27 */
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public int nextSpanTransition(int start, int limit, Class kind) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public CharSequence subSequence(int start, int end) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public void getChars(int start, int end, char[] dest, int destoff) {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public String toString() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    @Deprecated
/* 33 */ public int getTextRunCursor(int contextStart, int contextEnd, int flags, int offset, int cursorOpt, Paint p) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public void setFilters(InputFilter[] filters) {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public InputFilter[] getFilters() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/SpannableStringBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */