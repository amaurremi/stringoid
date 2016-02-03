package com.gau.go.launcherex.gowidget.weather.scroller;

import android.view.MotionEvent;

public class d
{
  final float[] a = new float[10];
  final float[] b = new float[10];
  final long[] c = new long[10];
  float d;
  float e;
  int f;
  
  public void a()
  {
    long[] arrayOfLong = this.c;
    int i = 0;
    while (i < 10)
    {
      arrayOfLong[i] = Long.MIN_VALUE;
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, Float.MAX_VALUE);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    float[] arrayOfFloat1 = this.a;
    float[] arrayOfFloat2 = this.b;
    long[] arrayOfLong = this.c;
    int m = this.f;
    if (arrayOfLong[m] != Long.MIN_VALUE)
    {
      f1 = (float)(arrayOfLong[m] - 200L);
      i = (m + 10 - 1) % 10;
      j = m;
      for (;;)
      {
        k = j;
        if ((float)arrayOfLong[i] < f1) {
          break;
        }
        k = j;
        if (i == m) {
          break;
        }
        j = i;
        i = (i + 10 - 1) % 10;
      }
    }
    int k = m;
    float f6 = arrayOfFloat1[k];
    float f7 = arrayOfFloat2[k];
    long l = arrayOfLong[k];
    float f1 = 0.0F;
    float f2 = 0.0F;
    int j = (m - k + 10) % 10 + 1;
    int i = j;
    if (j > 3) {
      i = j - 1;
    }
    j = 1;
    while (j < i)
    {
      m = (k + j) % 10;
      int n = (int)(arrayOfLong[m] - l);
      float f3;
      if (n == 0)
      {
        f3 = f1;
        f1 = f2;
        j += 1;
        f2 = f1;
        f1 = f3;
      }
      else
      {
        float f4 = (arrayOfFloat1[m] - f6) / n * paramInt;
        if (f1 == 0.0F) {}
        for (;;)
        {
          float f5 = (arrayOfFloat2[m] - f7) / n * paramInt;
          f3 = f4;
          f1 = f5;
          if (f2 == 0.0F) {
            break;
          }
          f1 = (f5 + f2) * 0.5F;
          f3 = f4;
          break;
          f4 = (f4 + f1) * 0.5F;
        }
      }
    }
    if (f1 < 0.0F)
    {
      f1 = Math.max(f1, -paramFloat);
      this.e = f1;
      if (f2 >= 0.0F) {
        break label356;
      }
    }
    label356:
    for (paramFloat = Math.max(f2, -paramFloat);; paramFloat = Math.min(f2, paramFloat))
    {
      this.d = paramFloat;
      return;
      f1 = Math.min(f1, paramFloat);
      break;
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getHistorySize();
    int i = this.f + 1;
    this.f = i;
    if (i >= 10) {
      this.f = 0;
    }
    i = 0;
    while (i < j)
    {
      this.a[this.f] = paramMotionEvent.getHistoricalX(i);
      this.b[this.f] = paramMotionEvent.getHistoricalY(i);
      this.c[this.f] = paramMotionEvent.getHistoricalEventTime(i);
      int k = this.f + 1;
      this.f = k;
      if (k >= 10) {
        this.f = 0;
      }
      i += 1;
    }
    this.a[this.f] = paramMotionEvent.getX();
    this.b[this.f] = paramMotionEvent.getY();
    this.c[this.f] = paramMotionEvent.getEventTime();
  }
  
  public float b()
  {
    return this.e;
  }
  
  public float c()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/scroller/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */