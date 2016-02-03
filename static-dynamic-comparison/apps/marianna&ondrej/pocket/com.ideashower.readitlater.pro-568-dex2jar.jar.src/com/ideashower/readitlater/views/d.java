package com.ideashower.readitlater.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.util.j;
import com.pocket.p.u;

public class d
  extends Drawable
{
  private static ColorStateList a;
  private static ColorStateList b;
  private static ColorStateList c;
  private final Path d = new Path();
  private final Paint e;
  private final Paint f;
  private final Paint g;
  private final Paint h;
  private final PorterDuffXfermode i;
  private final boolean j;
  private int k = 255;
  private Bitmap l;
  private Canvas m;
  private int n;
  private int o;
  private int p;
  private boolean q;
  private float r;
  private int s;
  private boolean t;
  
  public d(Context paramContext)
  {
    this(paramContext, 0.0F, 0.0F, true, false);
  }
  
  public d(Context paramContext, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a = paramContext.getResources().getColorStateList(2131165731);
    b = paramContext.getResources().getColorStateList(2131165733);
    c = paramContext.getResources().getColorStateList(2131165732);
    this.i = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.h.setColor(-16777216);
    this.h.setStyle(Paint.Style.FILL_AND_STROKE);
    this.e = new Paint();
    this.e.setXfermode(this.i);
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setStyle(Paint.Style.FILL_AND_STROKE);
    this.f.setXfermode(this.i);
    this.g = new Paint();
    this.d.setFillType(Path.FillType.EVEN_ODD);
    this.j = paramBoolean2;
    a(paramFloat1, paramFloat2, paramBoolean1);
    a(3.0F);
  }
  
  private Path a(int paramInt1, int paramInt2)
  {
    Path localPath = this.d;
    localPath.rewind();
    localPath.moveTo(0.0F, paramInt2 - this.p);
    localPath.lineTo(this.n, paramInt2 - this.p);
    localPath.lineTo(this.n + this.o / 2.0F, paramInt2);
    localPath.lineTo(this.n + this.o, paramInt2 - this.p);
    localPath.lineTo(paramInt1, paramInt2 - this.p);
    return localPath;
  }
  
  private void a()
  {
    this.q = true;
    invalidateSelf();
  }
  
  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    a(j.a(paramFloat1), j.a(paramFloat2), j.a(paramFloat2 / 2.0F), paramBoolean);
  }
  
  private void b()
  {
    Object localObject = getBounds();
    int i1 = ((Rect)localObject).right - ((Rect)localObject).left;
    int i2 = ((Rect)localObject).bottom - ((Rect)localObject).top;
    if ((i1 <= 0) || (i2 <= 0)) {
      return;
    }
    if ((this.l == null) || (this.m == null) || (this.l.getWidth() != i1) || (this.l.getHeight() != i2))
    {
      this.l = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
      this.m = new Canvas(this.l);
    }
    for (;;)
    {
      localObject = a(i1, i2 - 1);
      ((Path)localObject).lineTo(i1, 0.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      this.m.drawPath((Path)localObject, this.h);
      if (!this.j) {
        this.m.drawRect(0.0F, 0.0F, i1, i2, this.e);
      }
      localObject = a(i1, i2 - 2);
      ((Path)localObject).lineTo(i1, i2);
      ((Path)localObject).lineTo(0.0F, i2);
      ((Path)localObject).close();
      this.m.drawPath((Path)localObject, this.f);
      return;
      this.m.drawColor(0, PorterDuff.Mode.CLEAR);
    }
  }
  
  public void a(float paramFloat)
  {
    this.r = paramFloat;
    a();
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
    a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.n = paramInt1;
    this.o = paramInt2;
    this.p = paramInt3;
    this.t = paramBoolean;
    a();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.q)
    {
      this.q = false;
      b();
    }
    if (this.l != null)
    {
      Rect localRect = getBounds();
      paramCanvas.drawBitmap(this.l, localRect.left, localRect.top, this.g);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    return -1;
  }
  
  public int getMinimumHeight()
  {
    return (int)(this.p + this.r + j.a(1.0F));
  }
  
  public int getMinimumWidth()
  {
    return this.n + this.o;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    paramRect.set(0, 0, 0, this.p);
    return true;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    a();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool3 = true;
    boolean bool1 = super.onStateChange(paramArrayOfInt);
    int i1 = b.getColorForState(paramArrayOfInt, 0);
    int i2 = c.getColorForState(paramArrayOfInt, 0);
    int i3 = a.getColorForState(paramArrayOfInt, 0);
    if (this.f.getColor() != i1)
    {
      this.f.setColor(i1);
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (this.t)
    {
      bool2 = bool1;
      if (this.s != i2)
      {
        this.s = i2;
        u.a(this.f, this.r, 0.0F, -1.0F, i2);
        bool2 = true;
      }
    }
    if (this.e.getColor() != i3) {
      this.e.setColor(i3);
    }
    for (bool1 = bool3;; bool1 = bool2)
    {
      if (bool1) {
        a();
      }
      return bool1;
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.k)
    {
      this.k = paramInt;
      this.g.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */