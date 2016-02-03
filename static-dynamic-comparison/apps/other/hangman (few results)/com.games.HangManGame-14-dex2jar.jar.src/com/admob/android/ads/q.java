package com.admob.android.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.widget.TextView;

public final class q
  extends TextView
{
  public float a = -1.0F;
  public boolean b = false;
  public float c;
  
  public q(Context paramContext, float paramFloat)
  {
    super(paramContext);
    setGravity(80);
    this.c = paramFloat;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.b)
    {
      paramInt1 = getMeasuredWidth();
      Typeface localTypeface = getTypeface();
      float f2 = getTextSize();
      CharSequence localCharSequence = getText();
      TextPaint localTextPaint = new TextPaint(getPaint());
      if (localCharSequence != null)
      {
        for (float f1 = f2; f1 >= this.a; f1 -= 0.5F)
        {
          localTextPaint.setTypeface(localTypeface);
          localTextPaint.setTextSize(f1);
          if (localTextPaint.measureText(localCharSequence, 0, localCharSequence.length()) <= paramInt1) {
            break;
          }
        }
        if (f2 != f1) {
          setTextSize(1, f1 / this.c);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */