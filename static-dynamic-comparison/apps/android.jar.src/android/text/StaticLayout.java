/*    */
package android.text;

/*    */
/*    */ public class StaticLayout extends Layout {
    /*    */
    public StaticLayout(CharSequence source, TextPaint paint, int width, Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad) {
/*  5 */
        super((CharSequence) null, (TextPaint) null, 0, (Layout.Alignment) null, 0.0F, 0.0F);
        throw new RuntimeException("Stub!");
    }

    /*  6 */
    public StaticLayout(CharSequence source, int bufstart, int bufend, TextPaint paint, int outerwidth, Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad) {
        super((CharSequence) null, (TextPaint) null, 0, (Layout.Alignment) null, 0.0F, 0.0F);
        throw new RuntimeException("Stub!");
    }

    /*  7 */
    public StaticLayout(CharSequence source, int bufstart, int bufend, TextPaint paint, int outerwidth, Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad, TextUtils.TruncateAt ellipsize, int ellipsizedWidth) {
        super((CharSequence) null, (TextPaint) null, 0, (Layout.Alignment) null, 0.0F, 0.0F);
        throw new RuntimeException("Stub!");
    }

    /*  8 */
    public int getLineForVertical(int vertical) {
        throw new RuntimeException("Stub!");
    }

    /*  9 */
    public int getLineCount() {
        throw new RuntimeException("Stub!");
    }

    /* 10 */
    public int getLineTop(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 11 */
    public int getLineDescent(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 12 */
    public int getLineStart(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 13 */
    public int getParagraphDirection(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 14 */
    public boolean getLineContainsTab(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public final Layout.Directions getLineDirections(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public int getTopPadding() {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public int getBottomPadding() {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public int getEllipsisCount(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public int getEllipsisStart(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public int getEllipsizedWidth() {
        throw new RuntimeException("Stub!");
    }
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/StaticLayout.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */