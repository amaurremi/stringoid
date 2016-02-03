package com.androidwasabi.a;

import android.os.Build.VERSION;
import android.util.Log;
import com.badlogic.gdx.g;
import com.badlogic.gdx.h;

public class d
{
  public static Boolean a;
  public static int b;
  public static int c;
  public static float d;
  public static int e = 0;
  
  public static int a()
  {
    return b;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    int m;
    int n;
    label24:
    int i;
    int j;
    label84:
    int k;
    label166:
    float f2;
    if (a.booleanValue())
    {
      m = paramInt1;
      if (!a.booleanValue()) {
        break label249;
      }
      n = paramInt2;
      i = g.b.e();
      j = g.b.f();
      if (!a.booleanValue()) {
        break label255;
      }
      paramInt2 = j;
      paramInt1 = i;
      if (i < j)
      {
        paramInt1 = g.b.f();
        paramInt2 = g.b.e();
      }
      k = Integer.parseInt(Build.VERSION.SDK);
      if ((k != 11) && (k != 12))
      {
        j = paramInt2;
        i = paramInt1;
        if (k != 13) {}
      }
      else
      {
        if (!a.booleanValue()) {
          break label289;
        }
        k = paramInt1;
        if (paramInt1 == 1232) {
          k = 1280;
        }
        j = paramInt2;
        i = k;
        if (paramInt2 == 800)
        {
          j = 752;
          i = k;
        }
      }
      f1 = m / i;
      f2 = n / j;
      if (f1 <= f2) {
        break label330;
      }
      b = m;
      c = (int)(j * f1);
      label202:
      Log.v("WorldSize", String.valueOf(b));
      Log.v("WorldSize", String.valueOf(c));
      if (b >= c) {
        break label347;
      }
    }
    label249:
    label255:
    label289:
    label330:
    label347:
    for (float f1 = 30.0F;; f1 = 15.0F)
    {
      d = f1;
      return;
      m = paramInt2;
      break;
      n = paramInt1;
      break label24;
      paramInt2 = j;
      paramInt1 = i;
      if (i <= j) {
        break label84;
      }
      paramInt1 = g.b.f();
      paramInt2 = g.b.e();
      break label84;
      k = paramInt1;
      if (paramInt1 == 752) {
        k = 800;
      }
      j = paramInt2;
      i = k;
      if (paramInt2 != 1280) {
        break label166;
      }
      j = 1232;
      i = k;
      break label166;
      b = (int)(i * f2);
      c = n;
      break label202;
    }
  }
  
  public static void a(Boolean paramBoolean)
  {
    a = paramBoolean;
    Log.v("WorldSize", "Landscape: " + String.valueOf(a));
  }
  
  public static int b()
  {
    return c;
  }
  
  public static int c()
  {
    return Math.max(b, c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */