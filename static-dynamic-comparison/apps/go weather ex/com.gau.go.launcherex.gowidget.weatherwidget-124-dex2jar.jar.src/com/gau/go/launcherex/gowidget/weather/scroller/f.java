package com.gau.go.launcherex.gowidget.weather.scroller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class f
{
  private final int A;
  private final Drawable a;
  private final Drawable b;
  private int c;
  private int d;
  private final int e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private long r;
  private float s;
  private final Interpolator t;
  private int u = 0;
  private float v;
  private final Rect w = new Rect();
  private final int x;
  private final int y;
  private final int z;
  
  public f(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.a = paramContext.getDrawable(2130838378);
    this.b = paramContext.getDrawable(2130838379);
    PorterDuffColorFilter localPorterDuffColorFilter = new PorterDuffColorFilter(-16723201, PorterDuff.Mode.SRC_ATOP);
    this.b.setColorFilter(localPorterDuffColorFilter);
    this.a.setColorFilter(localPorterDuffColorFilter);
    this.x = this.a.getIntrinsicHeight();
    this.y = this.b.getIntrinsicHeight();
    this.z = this.b.getIntrinsicWidth();
    this.A = ((int)(Math.min(this.y * 4.0F * this.y / this.z * 0.6F, this.y * 4.0F) + 0.5F));
    this.e = ((int)(paramContext.getDisplayMetrics().density * 300.0F + 0.5F));
    this.t = new DecelerateInterpolator();
  }
  
  private void b()
  {
    float f1 = Math.min((float)(AnimationUtils.currentAnimationTimeMillis() - this.r) / this.s, 1.0F);
    float f2 = this.t.getInterpolation(f1);
    this.f = (this.j + (this.k - this.j) * f2);
    this.g = (this.l + (this.m - this.l) * f2);
    this.h = (this.n + (this.o - this.n) * f2);
    this.i = (this.p + (this.q - this.p) * f2);
    if (f1 >= 0.999F) {}
    switch (this.u)
    {
    default: 
      return;
    case 2: 
      this.u = 3;
      this.r = AnimationUtils.currentAnimationTimeMillis();
      this.s = 1000.0F;
      this.j = this.f;
      this.l = this.g;
      this.n = this.h;
      this.p = this.i;
      this.k = 0.0F;
      this.m = 0.0F;
      this.o = 0.0F;
      this.q = 0.0F;
      return;
    case 1: 
      this.u = 4;
      this.r = AnimationUtils.currentAnimationTimeMillis();
      this.s = 1000.0F;
      this.j = this.f;
      this.l = this.g;
      this.n = this.h;
      this.p = this.i;
      this.k = 0.0F;
      this.m = 0.0F;
      this.o = 0.0F;
      this.q = 0.0F;
      return;
    case 4: 
      if (this.q != 0.0F) {}
      for (f1 = 1.0F / (this.q * this.q);; f1 = Float.MAX_VALUE)
      {
        float f3 = this.l;
        this.g = (f1 * (f2 * (this.m - this.l)) + f3);
        this.u = 3;
        return;
      }
    }
    this.u = 0;
  }
  
  public void a()
  {
    this.v = 0.0F;
    if ((this.u != 1) && (this.u != 4)) {
      return;
    }
    this.u = 3;
    this.j = this.f;
    this.l = this.g;
    this.n = this.h;
    this.p = this.i;
    this.k = 0.0F;
    this.m = 0.0F;
    this.o = 0.0F;
    this.q = 0.0F;
    this.r = AnimationUtils.currentAnimationTimeMillis();
    this.s = 1000.0F;
  }
  
  public void a(float paramFloat)
  {
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    if ((this.u == 4) && ((float)(l1 - this.r) < this.s)) {
      return;
    }
    if (this.u != 1) {
      this.i = 1.0F;
    }
    this.u = 1;
    this.r = l1;
    this.s = 167.0F;
    this.v += paramFloat;
    float f1 = Math.abs(this.v);
    float f2 = Math.max(0.6F, Math.min(f1, 1.0F));
    this.j = f2;
    this.f = f2;
    f1 = Math.max(0.5F, Math.min(f1 * 7.0F, 1.0F));
    this.l = f1;
    this.g = f1;
    f1 = Math.min(1.0F, this.h + Math.abs(paramFloat) * 1.1F);
    this.n = f1;
    this.h = f1;
    f2 = Math.abs(paramFloat);
    f1 = f2;
    if (paramFloat > 0.0F)
    {
      f1 = f2;
      if (this.v < 0.0F) {
        f1 = -f2;
      }
    }
    if (this.v == 0.0F) {
      this.i = 0.0F;
    }
    paramFloat = Math.min(4.0F, Math.max(0.0F, f1 * 7.0F + this.i));
    this.p = paramFloat;
    this.i = paramFloat;
    this.k = this.f;
    this.m = this.g;
    this.o = this.h;
    this.q = this.i;
  }
  
  public void a(int paramInt)
  {
    this.u = 2;
    paramInt = Math.max(100, Math.abs(paramInt));
    this.r = AnimationUtils.currentAnimationTimeMillis();
    this.s = (0.1F + paramInt * 0.03F);
    this.j = 0.0F;
    this.l = 0.0F;
    this.g = 0.0F;
    this.n = 0.5F;
    this.p = 0.0F;
    this.k = Math.max(0, Math.min(paramInt * 8, 1));
    this.m = Math.max(0.5F, Math.min(paramInt * 8, 1.0F));
    this.q = Math.min(0.025F + paramInt / 100 * paramInt * 1.5E-4F, 1.75F);
    this.o = Math.max(this.n, Math.min(paramInt * 16 * 1.0E-5F, 1.0F));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool = false;
    b();
    this.b.setAlpha((int)(Math.max(0.0F, Math.min(this.h, 1.0F)) * 255.0F));
    int i1 = (int)Math.min(this.y * this.i * this.y / this.z * 0.6F, this.y * 4.0F);
    int i2;
    if (this.c < this.e)
    {
      i2 = (this.c - this.e) / 2;
      this.b.setBounds(i2, 0, this.c - i2, i1);
      this.b.draw(paramCanvas);
      this.a.setAlpha((int)(Math.max(0.0F, Math.min(this.f, 1.0F)) * 255.0F));
      i2 = (int)(this.x * this.g);
      if (this.c >= this.e) {
        break label251;
      }
      int i3 = (this.c - this.e) / 2;
      this.a.setBounds(i3, 0, this.c - i3, i2);
    }
    for (;;)
    {
      this.a.draw(paramCanvas);
      if ((this.u == 3) && (i1 == 0) && (i2 == 0)) {
        this.u = 0;
      }
      if (this.u != 0) {
        bool = true;
      }
      return bool;
      this.b.setBounds(0, 0, this.c, i1);
      break;
      label251:
      this.a.setBounds(0, 0, this.c, i2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/scroller/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */