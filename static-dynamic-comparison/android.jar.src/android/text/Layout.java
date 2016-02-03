/*    */
package android.text;
/*    */ 
/*    */

import android.graphics.Path;

/*    */
/*    */ public abstract class Layout {
    /*  6 */   public static class Directions {
        Directions() {
            throw new RuntimeException("Stub!");
        }
    }

    /*    */
/*    */   public static final int DIR_LEFT_TO_RIGHT = 1;
    /*    */   public static final int DIR_RIGHT_TO_LEFT = -1;

    /* 10 */   public static enum Alignment {
        ALIGN_CENTER,
        /* 11 */     ALIGN_NORMAL,
        /* 12 */     ALIGN_OPPOSITE;

        /*    */
        private Alignment() {
        }
    }

    /* 14 */
    protected Layout(CharSequence text, TextPaint paint, int width, Alignment align, float spacingMult, float spacingAdd) {
        throw new RuntimeException("Stub!");
    }

    /* 15 */
    public static float getDesiredWidth(CharSequence source, TextPaint paint) {
        throw new RuntimeException("Stub!");
    }

    /* 16 */
    public static float getDesiredWidth(CharSequence source, int start, int end, TextPaint paint) {
        throw new RuntimeException("Stub!");
    }

    /* 17 */
    public void draw(android.graphics.Canvas c) {
        throw new RuntimeException("Stub!");
    }

    /* 18 */
    public void draw(android.graphics.Canvas canvas, Path highlight, android.graphics.Paint highlightPaint, int cursorOffsetVertical) {
        throw new RuntimeException("Stub!");
    }

    /* 19 */
    public final CharSequence getText() {
        throw new RuntimeException("Stub!");
    }

    /* 20 */
    public final TextPaint getPaint() {
        throw new RuntimeException("Stub!");
    }

    /* 21 */
    public final int getWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 22 */
    public int getEllipsizedWidth() {
        throw new RuntimeException("Stub!");
    }

    /* 23 */
    public final void increaseWidthTo(int wid) {
        throw new RuntimeException("Stub!");
    }

    /* 24 */
    public int getHeight() {
        throw new RuntimeException("Stub!");
    }

    /* 25 */
    public final Alignment getAlignment() {
        throw new RuntimeException("Stub!");
    }

    /* 26 */
    public final float getSpacingMultiplier() {
        throw new RuntimeException("Stub!");
    }

    /* 27 */
    public final float getSpacingAdd() {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract int getLineCount();

    /* 29 */
    public int getLineBounds(int line, android.graphics.Rect bounds) {
        throw new RuntimeException("Stub!");
    }

    /*    */
    public abstract int getLineTop(int paramInt);

    /*    */
    public abstract int getLineDescent(int paramInt);

    /*    */
    public abstract int getLineStart(int paramInt);

    /*    */
    public abstract int getParagraphDirection(int paramInt);

    /*    */
    public abstract boolean getLineContainsTab(int paramInt);

    /*    */
    public abstract Directions getLineDirections(int paramInt);

    /*    */
    public abstract int getTopPadding();

    /*    */
    public abstract int getBottomPadding();

    /* 38 */
    public boolean isRtlCharAt(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 39 */
    public float getPrimaryHorizontal(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 40 */
    public float getSecondaryHorizontal(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 41 */
    public float getLineLeft(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 42 */
    public float getLineRight(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 43 */
    public float getLineMax(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 44 */
    public float getLineWidth(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 45 */
    public int getLineForVertical(int vertical) {
        throw new RuntimeException("Stub!");
    }

    /* 46 */
    public int getLineForOffset(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 47 */
    public int getOffsetForHorizontal(int line, float horiz) {
        throw new RuntimeException("Stub!");
    }

    /* 48 */
    public final int getLineEnd(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 49 */
    public int getLineVisibleEnd(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 50 */
    public final int getLineBottom(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 51 */
    public final int getLineBaseline(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 52 */
    public final int getLineAscent(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 53 */
    public int getOffsetToLeftOf(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 54 */
    public int getOffsetToRightOf(int offset) {
        throw new RuntimeException("Stub!");
    }

    /* 55 */
    public void getCursorPath(int point, Path dest, CharSequence editingBuffer) {
        throw new RuntimeException("Stub!");
    }

    /* 56 */
    public void getSelectionPath(int start, int end, Path dest) {
        throw new RuntimeException("Stub!");
    }

    /* 57 */
    public final Alignment getParagraphAlignment(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 58 */
    public final int getParagraphLeft(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 59 */
    public final int getParagraphRight(int line) {
        throw new RuntimeException("Stub!");
    }

    /* 60 */
    protected final boolean isSpanned() {
        throw new RuntimeException("Stub!");
    }

    /*    */
/*    */
    public abstract int getEllipsisStart(int paramInt);

    /*    */
/*    */
    public abstract int getEllipsisCount(int paramInt);
/*    */
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/Layout.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */