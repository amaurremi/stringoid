package com.pocket.list.widget.b.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;
import com.ideashower.readitlater.util.i;

public class b
{
  public final TextPaint a = new TextPaint();
  public final Rect b;
  public final ColorStateList c;
  public final float d;
  public final int e;
  public final ColorStateList f;
  public final Typeface g;
  
  public b(a parama, float paramFloat1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat2, int paramInt6, Resources paramResources)
  {
    this.a.setTextSize(TypedValue.applyDimension(paramInt1, paramFloat1, paramResources.getDisplayMetrics()));
    this.a.setTypeface(i.a(paramInt2));
    this.a.setFlags(this.a.getFlags() | 0x80);
    this.a.setAntiAlias(true);
    this.c = paramResources.getColorStateList(paramInt4);
    this.d = paramFloat2;
    this.e = paramInt6;
    this.b = new Rect();
    this.g = i.a(paramInt3);
    if (paramInt5 != 0) {}
    for (parama = paramResources.getColorStateList(paramInt5);; parama = null)
    {
      this.f = parama;
      return;
    }
  }
  
  public void a(TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(this.a.getTextSize());
    paramTextPaint.setTypeface(this.a.getTypeface());
    paramTextPaint.setFlags(this.a.getFlags());
    paramTextPaint.setAntiAlias(paramTextPaint.isAntiAlias());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */