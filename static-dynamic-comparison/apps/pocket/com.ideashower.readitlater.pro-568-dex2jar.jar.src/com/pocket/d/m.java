package com.pocket.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

public abstract class m
  extends Drawable
{
  protected Paint a;
  private Bitmap b;
  private int c;
  private int d;
  private int e;
  
  public m(Bitmap paramBitmap, Resources paramResources)
  {
    this.b = paramBitmap;
    this.c = paramResources.getDisplayMetrics().densityDpi;
    a();
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setShader(new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    a(0, 0);
  }
  
  private void a()
  {
    this.d = this.b.getScaledWidth(this.c);
    this.e = this.b.getScaledHeight(this.c);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    setBounds(paramInt1, paramInt2, getIntrinsicWidth() + paramInt1, getIntrinsicHeight() + paramInt2);
  }
  
  public void draw(Canvas paramCanvas) {}
  
  public int getIntrinsicHeight()
  {
    return this.e;
  }
  
  public int getIntrinsicWidth()
  {
    return this.d;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */