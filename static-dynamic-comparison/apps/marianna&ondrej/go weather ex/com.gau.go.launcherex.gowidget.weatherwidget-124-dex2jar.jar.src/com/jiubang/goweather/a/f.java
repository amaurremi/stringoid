package com.jiubang.goweather.a;

import java.util.ArrayList;

public class f
{
  public long a;
  public float b;
  public ArrayList c;
  
  public f(long paramLong, float paramFloat, ArrayList paramArrayList)
  {
    this.a = paramLong;
    this.b = paramFloat;
    this.c = paramArrayList;
  }
  
  public int a()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public g a(int paramInt)
  {
    if ((this.c == null) || (paramInt < 0) || (paramInt >= this.c.size())) {
      return null;
    }
    return (g)this.c.get(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */