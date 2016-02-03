package com.pocket.i.a;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.j;
import org.apache.a.c.a;

public class p
  extends Drawable
{
  public static final int a = j.a(8.5F);
  public static final int b = j.a(23.0F);
  private static final int c = Color.argb(190, 0, 0, 0);
  private static final int d = Color.argb(230, 0, 0, 0);
  private static final int e = Color.argb(190, 2, 141, 171);
  private static final int f = j.a(4.0F);
  private float g = j.a(5.0F);
  private final Paint h = new Paint();
  private final Paint i = new Paint();
  private final RectF j = new RectF();
  private final RectF k = new RectF();
  private final Rect l = new Rect();
  private int m = 0;
  private final Path n = new Path();
  private boolean o;
  private boolean p;
  private boolean q;
  private int r = c;
  private int s = e;
  
  public p()
  {
    this.h.setColor(this.r);
    this.h.setStyle(Paint.Style.FILL_AND_STROKE);
    this.h.setAntiAlias(true);
    this.i.setColor(Color.argb(255, 102, 102, 102));
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setStrokeWidth(j.a(2.0F));
    this.i.setAntiAlias(true);
    this.n.setFillType(Path.FillType.EVEN_ODD);
  }
  
  public p(int paramInt)
  {
    this();
    c(paramInt);
  }
  
  private void a()
  {
    if ((getBounds() == null) || (getBounds().isEmpty())) {
      return;
    }
    int i1 = b();
    int i2 = c();
    Path localPath = this.n;
    localPath.rewind();
    RectF localRectF1 = d();
    float f1 = b / 2.0F;
    RectF localRectF2 = this.k;
    float f2 = this.g * 2.0F;
    float f3 = localRectF1.left + f2;
    float f4 = localRectF1.top;
    float f5 = localRectF1.left + localRectF1.width() - f2;
    float f6 = f5 + f2;
    float f7 = f4 + f2;
    float f8 = localRectF1.top + f2 + (localRectF1.height() - 2.0F * f2);
    float f9 = localRectF1.top + localRectF1.height();
    float f10 = localRectF1.left;
    if (((i1 == 4) && (i2 == 16)) || ((i1 == 1) && (i2 == 64)))
    {
      localPath.moveTo(f10, f4);
      if (i1 == 4) {}
      switch (i2)
      {
      default: 
        label224:
        if (((i1 == 4) && (i2 == 64)) || ((i1 == 2) && (i2 == 16)))
        {
          localPath.lineTo(f6, f4);
          label259:
          if (i1 == 2) {}
          switch (i2)
          {
          default: 
            label300:
            if (((i1 == 2) && (i2 == 64)) || ((i1 == 8) && (i2 == 16)))
            {
              localPath.lineTo(f6, f9);
              label336:
              if (i1 == 8) {}
              switch (i2)
              {
              default: 
                label380:
                if (((i1 == 8) && (i2 == 64)) || ((i1 == 1) && (i2 == 16)))
                {
                  localPath.lineTo(f10, f9);
                  label416:
                  if (i1 == 1) {}
                  switch (i2)
                  {
                  default: 
                    label460:
                    if (((i1 != 4) || (i2 != 16)) && ((i1 != 1) || (i2 != 64))) {}
                    break;
                  }
                }
                break;
              }
            }
            break;
          }
        }
        break;
      }
    }
    for (;;)
    {
      localPath.close();
      return;
      localPath.moveTo(f3, f4);
      break;
      localPath.lineTo(f10 + f1, localRectF1.top - a);
      localPath.lineTo(b + f10, localRectF1.top);
      break label224;
      localPath.lineTo(localRectF1.centerX() - f1, localRectF1.top);
      localPath.lineTo(localRectF1.centerX(), localRectF1.top - a);
      localPath.lineTo(localRectF1.centerX() + f1, localRectF1.top);
      break label224;
      localPath.lineTo(f6 - b, localRectF1.top);
      localPath.lineTo(f6 - f1, localRectF1.top - a);
      break label224;
      localPath.lineTo(f5, f4);
      localRectF2.set(f5, f4, f6, f7);
      localPath.arcTo(localRectF2, 270.0F, 90.0F);
      break label259;
      localPath.lineTo(localRectF1.right + a, f4 + f1);
      localPath.lineTo(localRectF1.right, b + f4);
      break label300;
      localPath.lineTo(localRectF1.right, localRectF1.centerY() - f1);
      localPath.lineTo(localRectF1.right + a, localRectF1.centerY());
      localPath.lineTo(localRectF1.right, localRectF1.centerY() + f1);
      break label300;
      localPath.lineTo(localRectF1.right, f9 - b);
      localPath.lineTo(localRectF1.right + a, f9 + f1);
      break label300;
      localPath.lineTo(f6, f8);
      localRectF2.set(f6 - f2, f8, f5 + f2, f9);
      localPath.arcTo(localRectF2, 0.0F, 90.0F);
      break label336;
      localPath.lineTo(f6 - f1, localRectF1.bottom + a);
      localPath.lineTo(f6 - b, localRectF1.bottom);
      break label380;
      localPath.lineTo(localRectF1.centerX() - f1, localRectF1.bottom);
      localPath.lineTo(localRectF1.centerX(), localRectF1.bottom + a);
      localPath.lineTo(localRectF1.centerX() + f1, localRectF1.bottom);
      break label380;
      localPath.lineTo(b + f10, localRectF1.bottom);
      localPath.lineTo(f10 + f1, localRectF1.bottom + a);
      break label380;
      localPath.lineTo(f3, f9);
      localRectF2.set(f10, f8, f3, f9);
      localPath.arcTo(localRectF2, 90.0F, 90.0F);
      break label416;
      localPath.lineTo(localRectF1.left - a, f9 - f1);
      localPath.lineTo(localRectF1.left, b + f9);
      break label460;
      localPath.lineTo(localRectF1.left, localRectF1.centerY() - f1);
      localPath.lineTo(localRectF1.left - a, localRectF1.centerY());
      localPath.lineTo(localRectF1.left, localRectF1.centerY() + f1);
      break label460;
      localPath.lineTo(localRectF1.left, b + f4);
      localPath.lineTo(localRectF1.left - a, f1 + f4);
      break label460;
      localPath.lineTo(f10, f7);
      localRectF2.set(f3 - f2, f4, f10 + f2, f7);
      localPath.arcTo(localRectF2, 180.0F, 90.0F);
    }
  }
  
  private int b()
  {
    int i1 = 1;
    if (this.m == 0) {
      i1 = 0;
    }
    while ((this.m & 0x1) == 1) {
      return i1;
    }
    if ((this.m & 0x2) == 2) {
      return 2;
    }
    if ((this.m & 0x4) == 4) {
      return 4;
    }
    if ((this.m & 0x8) == 8) {
      return 8;
    }
    throw new RuntimeException("invalid vertical position " + this.m);
  }
  
  private int c()
  {
    int i1 = 16;
    if (this.m == 0) {
      i1 = 0;
    }
    while ((this.m & 0x10) == 16) {
      return i1;
    }
    if ((this.m & 0x20) == 32) {
      return 32;
    }
    if ((this.m & 0x40) == 64) {
      return 64;
    }
    throw new RuntimeException("invalid horizontal position " + this.m);
  }
  
  private void c(int paramInt)
  {
    if (this.m == paramInt) {
      return;
    }
    this.m = paramInt;
    c();
    int i4 = b();
    paramInt = a + f;
    Rect localRect = this.l;
    int i1;
    int i2;
    label55:
    int i3;
    if (i4 == 1)
    {
      i1 = paramInt;
      if (i4 != 4) {
        break label95;
      }
      i2 = paramInt;
      if (i4 != 2) {
        break label100;
      }
      i3 = paramInt;
      label64:
      if (i4 != 8) {
        break label106;
      }
    }
    for (;;)
    {
      localRect.set(i1, i2, i3, paramInt);
      a();
      invalidateSelf();
      return;
      i1 = 0;
      break;
      label95:
      i2 = 0;
      break label55;
      label100:
      i3 = 0;
      break label64;
      label106:
      paramInt = 0;
    }
  }
  
  private RectF d()
  {
    RectF localRectF = this.j;
    localRectF.set(getBounds());
    localRectF.left += this.l.left;
    localRectF.top += this.l.top;
    localRectF.right -= this.l.right;
    localRectF.bottom -= this.l.bottom;
    return localRectF;
  }
  
  public void a(int paramInt)
  {
    this.r = Color.argb(paramInt, 0, 0, 0);
    Paint localPaint = this.h;
    if (this.q) {
      paramInt = this.s;
    }
    for (;;)
    {
      localPaint.setColor(paramInt);
      invalidateSelf();
      return;
      if (this.p) {
        paramInt = d;
      } else {
        paramInt = this.r;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.s = paramInt;
    Paint localPaint = this.h;
    if (this.q) {
      paramInt = this.s;
    }
    for (;;)
    {
      localPaint.setColor(paramInt);
      invalidateSelf();
      return;
      if (this.p) {
        paramInt = d;
      } else {
        paramInt = this.r;
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((getBounds() == null) || (getBounds().isEmpty())) {}
    do
    {
      return;
      paramCanvas.drawPath(this.n, this.h);
    } while ((!this.o) && (!this.p));
    paramCanvas.drawPath(this.n, this.i);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    paramRect.set(this.l);
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
    boolean bool1 = false;
    boolean bool2 = a.b(paramArrayOfInt, 16842919);
    if (bool2 != this.q) {
      this.q = bool2;
    }
    for (int i1 = 1;; i1 = 0)
    {
      boolean bool3 = m.a(paramArrayOfInt);
      if (this.p != bool3)
      {
        this.p = bool3;
        a();
        i1 = 1;
      }
      for (;;)
      {
        if (i1 != 0)
        {
          if (bool2) {
            this.h.setColor(this.s);
          }
        }
        else
        {
          if ((super.onStateChange(paramArrayOfInt)) || (i1 != 0)) {
            bool1 = true;
          }
          return bool1;
        }
        Paint localPaint = this.h;
        if (bool3) {}
        for (int i2 = d;; i2 = this.r)
        {
          localPaint.setColor(i2);
          break;
        }
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.h.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.h.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/i/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */