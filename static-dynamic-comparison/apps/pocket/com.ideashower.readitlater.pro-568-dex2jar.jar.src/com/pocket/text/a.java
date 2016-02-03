package com.pocket.text;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class a
  extends MetricAffectingSpan
{
  private b a;
  
  private void a(TextPaint paramTextPaint)
  {
    if (this.a != null) {
      this.a.a(paramTextPaint);
    }
  }
  
  public void a(b paramb)
  {
    this.a = paramb;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    a(paramTextPaint);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    a(paramTextPaint);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/text/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */