package com.pocket.text;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class CustomTypefaceSpan
  extends TypefaceSpan
{
  private final Typeface a;
  private final boolean b;
  
  public CustomTypefaceSpan(Typeface paramTypeface, boolean paramBoolean)
  {
    this("", paramTypeface, paramBoolean);
  }
  
  public CustomTypefaceSpan(String paramString, Typeface paramTypeface)
  {
    this(paramString, paramTypeface, true);
  }
  
  public CustomTypefaceSpan(String paramString, Typeface paramTypeface, boolean paramBoolean)
  {
    super(paramString);
    this.a = paramTypeface;
    this.b = paramBoolean;
  }
  
  private static void a(Paint paramPaint, Typeface paramTypeface, boolean paramBoolean)
  {
    Typeface localTypeface;
    if (paramBoolean)
    {
      localTypeface = paramPaint.getTypeface();
      if (localTypeface != null) {
        break label56;
      }
    }
    label56:
    for (int i = 0;; i = localTypeface.getStyle())
    {
      i &= (paramTypeface.getStyle() ^ 0xFFFFFFFF);
      if ((i & 0x1) != 0) {
        paramPaint.setFakeBoldText(true);
      }
      if ((i & 0x2) != 0) {
        paramPaint.setTextSkewX(-0.25F);
      }
      paramPaint.setTypeface(paramTypeface);
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    a(paramTextPaint, this.a, this.b);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    a(paramTextPaint, this.a, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/text/CustomTypefaceSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */