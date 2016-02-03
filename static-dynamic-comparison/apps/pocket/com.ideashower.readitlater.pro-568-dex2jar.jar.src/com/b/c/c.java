package com.b.c;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import com.b.a.b;
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
      localObject = new h(paramView);
    }
    for (;;)
    {
      a.put(paramView, localObject);
      return (c)localObject;
      label53:
      if (i >= 11) {
        localObject = new d(paramView);
      } else {
        localObject = new i(paramView);
      }
    }
  }
  
  public abstract c a(float paramFloat);
  
  public abstract c a(long paramLong);
  
  public abstract c a(Interpolator paramInterpolator);
  
  public abstract c a(b paramb);
  
  public abstract void a();
  
  public abstract c b(float paramFloat);
  
  public abstract c b(long paramLong);
  
  public abstract c c(float paramFloat);
  
  public abstract c d(float paramFloat);
  
  public abstract c e(float paramFloat);
  
  public abstract c f(float paramFloat);
  
  public abstract c g(float paramFloat);
  
  public abstract c h(float paramFloat);
  
  public abstract c i(float paramFloat);
  
  public abstract c j(float paramFloat);
  
  public abstract c k(float paramFloat);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */