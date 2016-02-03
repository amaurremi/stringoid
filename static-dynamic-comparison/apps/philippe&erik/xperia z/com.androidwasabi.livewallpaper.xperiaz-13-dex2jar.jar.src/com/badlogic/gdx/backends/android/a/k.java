package com.badlogic.gdx.backends.android.a;

import android.view.MotionEvent;
import com.badlogic.gdx.a;
import com.badlogic.gdx.g;
import com.badlogic.gdx.h;
import com.badlogic.gdx.utils.p;
import java.util.ArrayList;

public class k
  implements l
{
  private void a(f paramf, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    try
    {
      i locali = (i)paramf.a.c();
      locali.a = paramLong;
      locali.e = 0;
      locali.c = paramInt2;
      locali.d = paramInt3;
      locali.b = paramInt1;
      paramf.b.add(locali);
      g.a.a().h();
      return;
    }
    finally {}
  }
  
  public void a(MotionEvent paramMotionEvent, f paramf)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramf.c[0];
    int m = paramf.d[0];
    paramf.c[0] = i;
    paramf.d[0] = j;
    long l = paramMotionEvent.getEventTime() * 1000000L;
    if (paramMotionEvent.getAction() == 0)
    {
      a(paramf, 0, i, j, 0, l);
      paramf.g[0] = true;
      paramf.e[0] = 0;
      paramf.f[0] = 0;
    }
    do
    {
      return;
      if (paramMotionEvent.getAction() == 2)
      {
        a(paramf, 2, i, j, 0, l);
        paramf.g[0] = true;
        paramf.e[0] = (i - k);
        paramf.f[0] = (j - m);
        return;
      }
      if (paramMotionEvent.getAction() == 1)
      {
        a(paramf, 1, i, j, 0, l);
        paramf.g[0] = false;
        paramf.e[0] = 0;
        paramf.f[0] = 0;
        return;
      }
    } while (paramMotionEvent.getAction() != 3);
    a(paramf, 1, i, j, 0, l);
    paramf.g[0] = false;
    paramf.e[0] = 0;
    paramf.f[0] = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */