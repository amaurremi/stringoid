package com.jiubang.core.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.util.DisplayMetrics;

public class h
  extends t
{
  private float A;
  private float B = 0.5F;
  private float C = 0.5F;
  private float u;
  private float v;
  private float w;
  private float x;
  private float y;
  private float z;
  
  public h(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    super(paramInt1, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramBoolean1, paramBoolean2, paramLong1, paramLong2);
    paramInt1 = paramInt5 - paramInt3;
    paramInt3 = paramInt6 - paramInt4;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      this.A = 0.16666667F;
      if (paramInt5 < 0) {
        this.B = -0.5F;
      }
      if (paramInt6 < 0) {
        this.C = -0.5F;
      }
      return;
      float f = 1.0F / (this.h * this.h);
      this.u = paramFloat1;
      this.v = paramFloat2;
      if (paramInt1 != 0) {
        this.w = (((paramInt1 << 1) - this.u * this.h * 2.0F) * f);
      }
      if (paramInt3 != 0)
      {
        this.y = (((paramInt3 << 1) - this.v * this.h * 2.0F) * f);
        continue;
        paramFloat1 = 1.0F / this.h;
        this.u = (paramInt1 * paramFloat1);
        this.v = (paramInt3 * paramFloat1);
        continue;
        this.u = paramFloat1;
        this.v = paramFloat2;
        if (paramInt1 != 0) {
          this.w = ((paramInt1 * 6 - this.h * 4 * this.u) / (this.h * this.h));
        }
        for (this.x = ((this.h * 6 * this.u - paramInt1 * 12) / (this.h * this.h * this.h));; this.x = 0.0F)
        {
          if (paramInt3 == 0) {
            break label417;
          }
          this.y = ((paramInt3 * 6 - this.h * 4 * this.v) / (this.h * this.h));
          this.z = ((this.h * 6 * this.v - paramInt3 * 12) / (this.h * this.h * this.h));
          break;
          this.u = 0.0F;
          this.w = 0.0F;
        }
        label417:
        this.v = 0.0F;
        this.y = 0.0F;
        this.z = 0.0F;
        continue;
        this.u = (paramInt1 / this.h);
        this.v = paramFloat2;
        if (paramInt3 != 0)
        {
          this.y = (((paramInt3 << 1) - this.v * this.h * 2.0F) / (this.h * this.h));
          continue;
          this.u = paramFloat1;
          if (paramInt1 != 0) {
            this.w = (((paramInt1 << 1) - this.u * this.h * 2.0F) / (this.h * this.h));
          }
          this.v = (paramInt3 / this.h);
        }
      }
    }
  }
  
  protected void a(s params, l paraml)
  {
    if (!c())
    {
      if (this.j == 1)
      {
        this.q = ((int)(this.m + (this.u + this.w * 0.5F * this.k + this.x * this.k * this.k * this.A) * this.k + this.B));
        this.r = ((int)(this.o + (this.v + this.y * 0.5F * this.k + this.z * this.k * this.k * this.A) * this.k + this.C));
        params.a().postTranslate(this.q, this.r);
      }
    }
    else {
      return;
    }
    int i = a();
    this.q = (this.m + (this.n - this.m) * i / 100000);
    int j = this.o;
    this.r = (i * (this.p - this.o) / 100000 + j);
    DisplayMetrics localDisplayMetrics;
    if (!this.s)
    {
      i = e.a();
      if (this.q > i) {
        this.q -= i + paraml.a();
      }
    }
    else if (!this.t)
    {
      localDisplayMetrics = paraml.j().getResources().getDisplayMetrics();
      if (this.r <= localDisplayMetrics.heightPixels) {
        break label388;
      }
      this.r -= localDisplayMetrics.heightPixels + paraml.b();
    }
    for (;;)
    {
      i = paraml.f();
      j = paraml.g();
      params.a().postTranslate(-i, -j);
      params.a().postTranslate(this.q, this.r);
      paraml.a(this.q, this.r);
      return;
      if (this.q + paraml.a() >= 0) {
        break;
      }
      j = this.q;
      this.q = (i + paraml.a() + j);
      break;
      label388:
      if (this.r + paraml.b() < 0)
      {
        i = this.r;
        this.r = (localDisplayMetrics.heightPixels + paraml.b() + i);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */