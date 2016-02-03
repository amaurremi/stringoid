package com.mapbar.android.maps;

public enum u
{
  private u() {}
  
  public static u a(int paramInt)
  {
    u[] arrayOfu = (u[])c.clone();
    int j = arrayOfu.length;
    int i = 0;
    while (i < j)
    {
      u localu = arrayOfu[i];
      if (localu.ordinal() == paramInt) {
        return localu;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */