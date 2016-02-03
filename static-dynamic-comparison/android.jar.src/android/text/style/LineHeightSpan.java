package android.text.style;

import android.graphics.Paint.FontMetricsInt;
import android.text.TextPaint;

public abstract interface LineHeightSpan
        extends ParagraphStyle, WrapTogetherSpan {
    public abstract void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt);

    public static abstract interface WithDensity
            extends LineHeightSpan {
        public abstract void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt, TextPaint paramTextPaint);
    }
}


/* Location:              /Users/amaurremi/uw/projects/WALA/com.ibm.wala.dalvik.test/data/android.jar!/android/text/style/LineHeightSpan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */