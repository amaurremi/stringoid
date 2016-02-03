package com.a.c;

import android.os.Build.VERSION;
import android.view.View;
import java.util.WeakHashMap;

public abstract class c
{
  private static final WeakHashMap a = new WeakHashMap(0);
  
  public static c a(View paramView)
  {
    c localc = (c)a.get(paramView);
    Object localObject = localc;
    int i;
    if (localc == null)
    {
      i = Integer.valueOf(Build.VERSION.SDK).intValue();
      if (i < 14) {
        break label53;
      }
      localObject = new i(paramView);
    }
    for (;;)
    {
      a.put(paramView, localObject);
      return (c)localObject;
      label53:
      if (i >= 11) {
        localObject = new d(paramView);
      } else {
        localObject = new j(paramView);
      }
    }
  }
  
  public abstract c a(float paramFloat);
  
  public abstract c a(long paramLong);
  
  public abstract void a();
  
  public abstract c b(float paramFloat);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */