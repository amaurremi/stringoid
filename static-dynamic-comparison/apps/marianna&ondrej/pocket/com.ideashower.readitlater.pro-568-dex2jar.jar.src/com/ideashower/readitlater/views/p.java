package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.SparseArray;

public class p
  extends Drawable
{
  private static ColorStateList e;
  private static SparseArray o = new SparseArray();
  protected Paint a;
  protected Paint b;
  private final Bitmap c;
  private final Bitmap d;
  private int f = 255;
  private int g = 160;
  private int h;
  private int i;
  private boolean j = false;
  private int k;
  private Bitmap l;
  private Canvas m;
  private final ColorStateList n;
  
  public p(int paramInt, Context paramContext)
  {
    this(BitmapFactory.decodeResource(paramContext.getResources(), paramInt), paramContext, a(paramContext));
  }
  
  public p(int paramInt, Context paramContext, ColorStateList paramColorStateList)
  {
    this(BitmapFactory.decodeResource(paramContext.getResources(), paramInt), paramContext, paramColorStateList);
  }
  
  public p(Bitmap paramBitmap, Context paramContext)
  {
    this(paramBitmap, paramContext, a(paramContext));
  }
  
  public p(Bitmap paramBitmap, Context paramContext, ColorStateList paramColorStateList)
  {
    this.n = paramColorStateList;
    this.d = paramBitmap.extractAlpha();
    this.c = paramBitmap;
    this.g = paramContext.getResources().getDisplayMetrics().densityDpi;
    c();
    this.b = new Paint();
    this.b.setFilterBitmap(false);
    this.b.setAntiAlias(true);
    this.a = new Paint();
    this.a.setFilterBitmap(false);
    this.a.setAntiAlias(true);
  }
  
  public static int a(int[] paramArrayOfInt, int paramInt, Context paramContext)
  {
    return a(paramContext).getColorForState(paramArrayOfInt, paramInt);
  }
  
  private static ColorStateList a(Context paramContext)
  {
    if (e == null) {
      e = paramContext.getResources().getColorStateList(2131165811);
    }
    return e;
  }
  
  private void c()
  {
    this.h = this.c.getScaledWidth(this.g);
    this.i = this.c.getScaledHeight(this.g);
  }
  
  private void d()
  {
    int i1 = this.n.getColorForState(getState(), 0);
    if (this.k != i1)
    {
      this.k = i1;
      this.b.setColor(i1);
      PorterDuffColorFilter localPorterDuffColorFilter2 = (PorterDuffColorFilter)o.get(i1);
      PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
      if (localPorterDuffColorFilter2 == null)
      {
        localPorterDuffColorFilter1 = new PorterDuffColorFilter(i1, PorterDuff.Mode.DST_IN);
        o.put(i1, localPorterDuffColorFilter1);
      }
      this.b.setColorFilter(localPorterDuffColorFilter1);
    }
    this.a.setAlpha(this.f);
    this.b.setAlpha(this.f);
  }
  
  public void a()
  {
    setBounds(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a((int)paramFloat1, (int)paramFloat2);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    setBounds(paramInt1, paramInt2, this.h + paramInt1, this.i + paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public Bitmap b()
  {
    return this.c;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.f == 0) {
      return;
    }
    Rect localRect = getBounds();
    if (this.j)
    {
      paramCanvas.drawBitmap(this.c, localRect.left, localRect.top, this.a);
      return;
    }
    if ((this.l == null) || (this.l.getWidth() != this.d.getWidth()) || (this.l.getHeight() != this.d.getHeight()))
    {
      this.l = Bitmap.createBitmap(this.d.getWidth(), this.d.getHeight(), Bitmap.Config.ARGB_8888);
      this.m = new Canvas(this.l);
    }
    this.m.drawColor(0, PorterDuff.Mode.CLEAR);
    this.m.drawBitmap(this.d, 0.0F, 0.0F, this.b);
    paramCanvas.drawBitmap(this.l, localRect.left, localRect.top, null);
  }
  
  public int getIntrinsicHeight()
  {
    return this.i;
  }
  
  public int getIntrinsicWidth()
  {
    return this.h;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    super.onStateChange(paramArrayOfInt);
    d();
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.f)
    {
      this.f = paramInt;
      this.a.setAlpha(this.f);
      this.b.setAlpha(this.f);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */