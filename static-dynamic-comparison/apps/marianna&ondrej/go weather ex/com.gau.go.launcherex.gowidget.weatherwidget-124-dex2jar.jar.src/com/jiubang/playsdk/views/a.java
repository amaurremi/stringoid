package com.jiubang.playsdk.views;

import android.view.LayoutInflater;
import com.jiubang.playsdk.a.x;
import com.jiubang.playsdk.e.d;
import com.jiubang.playsdk.g;

public class a
{
  public static q a(LayoutInflater paramLayoutInflater, d paramd, x paramx)
  {
    if ((paramd == null) || (paramx == null)) {
      return (q)paramLayoutInflater.inflate(g.j, null);
    }
    int i = paramd.i();
    int j = paramd.j();
    q localq;
    if (i == 1) {
      if (j == 2) {
        localq = (q)paramLayoutInflater.inflate(g.w, null);
      }
    }
    for (;;)
    {
      if (localq != null)
      {
        localq.a(paramx);
        localq.a(paramd);
        return localq;
        if (j == 16)
        {
          localq = (q)paramLayoutInflater.inflate(g.B, null);
          continue;
        }
        if (j == 17)
        {
          localq = (q)paramLayoutInflater.inflate(g.k, null);
          continue;
          if (i == 2)
          {
            if (j == 27)
            {
              localq = (q)paramLayoutInflater.inflate(g.b, null);
              continue;
            }
            if (j == 6)
            {
              localq = (q)paramLayoutInflater.inflate(g.k, null);
              continue;
            }
            if (j == 28)
            {
              localq = (q)paramLayoutInflater.inflate(g.k, null);
              continue;
            }
            if (j == 18)
            {
              localq = (q)paramLayoutInflater.inflate(g.k, null);
              continue;
            }
            if (j == 31) {
              localq = (q)paramLayoutInflater.inflate(g.k, null);
            }
          }
        }
      }
      else
      {
        return (q)paramLayoutInflater.inflate(g.j, null);
      }
      localq = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */