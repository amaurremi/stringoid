package com.pocket.i.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.ideashower.readitlater.util.i;
import com.ideashower.readitlater.util.j;
import com.pocket.p.y;

public class f
  extends Drawable
{
  private final TextPaint a = new TextPaint();
  private final ColorStateList b;
  private String c;
  private String d;
  private float e;
  
  public f(String paramString, Resources paramResources)
  {
    this.b = paramResources.getColorStateList(2131165811);
    this.a.setTextSize(paramResources.getDimension(2131296398));
    this.a.setTypeface(i.a(i.a));
    this.a.setFlags(this.a.getFlags() | 0x80);
    this.a.setAntiAlias(true);
    this.a.setTextAlign(Paint.Align.LEFT);
    this.a.setAntiAlias(true);
    a(paramString);
  }
  
  private void b()
  {
    if (this.c != null)
    {
      this.d = TextUtils.ellipsize(this.c, this.a, getBounds().width(), TextUtils.TruncateAt.END).toString();
      this.e = this.a.measureText(this.d);
      return;
    }
    this.d = null;
    this.e = 0.0F;
  }
  
  public int a()
  {
    int i = 0;
    if (this.c != null) {
      i = (int)this.a.measureText(this.c, 0, this.c.length()) + j.a(2.0F);
    }
    return i;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
    b();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.d == null) {
      return;
    }
    Rect localRect = getBounds();
    paramCanvas.drawText(this.d, localRect.left, y.a(localRect, this.a), this.a);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.d != null) {}
    for (float f = y.a(this.a);; f = 0.0F) {
      return (int)f;
    }
  }
  
  public int getIntrinsicWidth()
  {
    return (int)this.e;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    b();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    super.onStateChange(paramArrayOfInt);
    this.a.setColor(this.b.getColorForState(paramArrayOfInt, 0));
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */