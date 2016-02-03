package com.pocket.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.util.j;

public class i
  extends Drawable
{
  private ColorStateList a;
  private ColorStateList b;
  private Paint c;
  private Paint d;
  private float[] e;
  private int[] f;
  private int g;
  private float h;
  private int i;
  private int j;
  
  public i(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.a = paramContext.getColorStateList(2131165738);
    this.b = paramContext.getColorStateList(2131165737);
    this.i = j.a(1.5F);
    this.c = new Paint();
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setAntiAlias(true);
    this.c.setStrokeWidth(this.i);
    this.d = new Paint();
    this.d.setAntiAlias(true);
    this.d.setDither(true);
    this.g = j.a(2.0F);
    this.f = new int[] { 0, 0 };
    this.e = new float[] { 0.9F, 1.0F };
    this.j = (this.i + this.g + j.a(2.0F));
  }
  
  private void b()
  {
    int[] arrayOfInt = getState();
    Rect localRect = getBounds();
    float f1 = c();
    this.c.setColor(this.a.getColorForState(arrayOfInt, 0));
    if (localRect.width() > 0)
    {
      float f2 = j.a(2.0F);
      this.h = (this.i + f1 + this.g);
      if (this.h % 2.0F != f1 % 2.0F) {}
      this.e[0] = ((f1 - f2) / this.h);
      this.f[0] = this.b.getColorForState(arrayOfInt, 0);
      this.d.setShader(new RadialGradient(localRect.exactCenterX(), localRect.exactCenterY(), this.h, this.f, this.e, Shader.TileMode.CLAMP));
    }
  }
  
  private float c()
  {
    Rect localRect = getBounds();
    return Math.min(localRect.width(), localRect.height()) / 2.0F - this.j;
  }
  
  public int a()
  {
    return this.j;
  }
  
  public void a(Rect paramRect)
  {
    setBounds(paramRect.left - this.j, paramRect.top - this.j, paramRect.right + this.j, paramRect.bottom + this.j);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    float f1 = c();
    paramCanvas.drawCircle(localRect.exactCenterX(), localRect.exactCenterY(), this.h, this.d);
    paramCanvas.drawCircle(localRect.exactCenterX(), localRect.exactCenterY(), f1, this.c);
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
    b();
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.c.setAlpha(paramInt);
    this.d.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.c.setColorFilter(paramColorFilter);
    this.d.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */