/*    */
package android.text;
/*    */ 
/*    */

import android.graphics.Canvas;

/*    */
/*    */ public class BoringLayout extends Layout implements TextUtils.EllipsizeCallback {
    /*    */   public static class Metrics extends android.graphics.Paint.FontMetricsInt {
        /*    */     public int width;

        /*    */
/*  9 */
        public Metrics() {
            throw new RuntimeException("Stub!");
        }

        /* 10 */
        public String toString() {
            throw new RuntimeException("Stub!");
        }
/*    */
    }

    /*    */
/* 13 */
    public BoringLayout(CharSequence source, TextPaint paint, int outerwidth, Layout.Alignment align, float spacingmult, float spacingadd, Metrics metrics, boolean includepad) {
        super((CharSequence) null, (TextPaint) null, 0, (Layout.Alignment) null, 0.0F, 0.0F);
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public BoringLayout(CharSequence source, TextPaint paint, int outerwidth, Layout.Alignment align, float spacingmult, float spacingadd, Metrics metrics, boolean includepad, TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        super((CharSequence) null, (TextPaint) null, 0, (Layout.Alignment) null, 0.0F, 0.0F);
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static BoringLayout make(CharSequence source, TextPaint paint, int outerwidth, Layout.Alignment align, float spacingmult, float spacingadd, Metrics metrics, boolean includepad) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static BoringLayout make(CharSequence source, TextPaint paint, int outerwidth, Layout.Alignment align, float spacingmult, float spacingadd, Metrics metrics, boolean includepad, TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint, int outerwidth, Layout.Alignment align, float spacingmult, float spacingadd, Metrics metrics, boolean includepad) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public BoringLayout replaceOrMake(CharSequence source, TextPaint paint, int outerwidth, Layout.Alignment align, float spacingmult, float spacingadd, Metrics metrics, boolean includepad, TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public static Metrics isBoring(CharSequence text, TextPaint paint) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public static Metrics isBoring(CharSequence text, TextPaint paint, Metrics metrics) {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public int getHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public int getLineCount() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public int getLineTop(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public int getLineDescent(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public int getLineStart(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public int getParagraphDirection(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public boolean getLineContainsTab(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 28 */
    public float getLineMax(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 29 */
    public final Layout.Directions getLineDirections(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 30 */
    public int getTopPadding() {
        throw new RuntimeException("Stub!");
    }

    /* 31 */
    public int getBottomPadding() {
        throw new RuntimeException("Stub!");
    }

    /* 32 */
    public int getEllipsisCount(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 33 */
    public int getEllipsisStart(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 34 */
    public int getEllipsizedWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 35 */
    public void draw(Canvas c, android.graphics.Path highlight, android.graphics.Paint highlightpaint, int cursorOffset) {
        throw new RuntimeException("Stub!");
    }

    /* 36 */
    public void ellipsized(int start, int end) {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/BoringLayout.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */