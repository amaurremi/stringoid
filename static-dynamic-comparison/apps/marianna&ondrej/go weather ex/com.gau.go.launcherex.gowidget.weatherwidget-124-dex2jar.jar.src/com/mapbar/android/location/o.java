package com.mapbar.android.location;

public enum o
{
  private o() {}
  
  public static o a(int paramInt)
  {
    o[] arrayOfo = (o[])c.clone();
    int j = arrayOfo.length;
    int i = 0;
    while (i < j)
    {
      o localo = arrayOfo[i];
      if (localo.ordinal() == paramInt) {
        return localo;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */