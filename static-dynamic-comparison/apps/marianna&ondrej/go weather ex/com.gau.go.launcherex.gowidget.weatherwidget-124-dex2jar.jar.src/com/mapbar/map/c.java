package com.mapbar.map;

import com.mapbar.android.maps.D;

public final class c
{
  private static final c[] c = new c[14];
  private final int a;
  private final int b;
  
  static
  {
    int j = 20;
    int i = 0;
    while (i <= 13)
    {
      c[i] = new c(i, j);
      j = (int)(j * D.a(i) / D.a(i + 1));
      i += 1;
    }
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.a = paramInt2;
  }
  
  public static c a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 13) {
        localObject1 = c[paramInt];
      }
    }
    return (c)localObject1;
  }
  
  public final float a(c paramc)
  {
    return paramc.a / this.a;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final c b()
  {
    return a(this.b + 1);
  }
  
  public final boolean b(c paramc)
  {
    return this.b > paramc.b;
  }
  
  public final c c()
  {
    return a(this.b - 1);
  }
  
  public final String toString()
  {
    return super.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/map/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */