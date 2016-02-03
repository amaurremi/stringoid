package android.text.style;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract interface LineBackgroundSpan
        extends ParagraphStyle {
    public abstract void drawBackground(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, int paramInt8);
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/LineBackgroundSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */