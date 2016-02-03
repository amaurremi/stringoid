package com.appbrain.a;

import android.content.Context;
import com.appbrain.b.k;
import com.appbrain.b.t;
import com.appbrain.b.u;
import com.appbrain.e.aa;
import com.appbrain.g.b;
import java.util.ArrayList;
import java.util.List;

public abstract class ag
{
  private final c a;
  
  public ag(Context paramContext)
  {
    this.a = new c(paramContext);
  }
  
  public static cmn.d a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = paramString1.split(",");
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString1[i];
      localArrayList.add(str + paramString2);
      i += 1;
    }
    return new cmn.d(localArrayList);
  }
  
  public final com.appbrain.g.c a(k paramk, String paramString)
  {
    paramk = paramk.d();
    a(paramk, this.a.a());
    com.appbrain.g.c localc = b.H();
    localc.a(com.appbrain.b.d.a(paramk.c().b()));
    localc.a(paramString);
    return localc;
  }
  
  public abstract void a(u paramu, aa paramaa);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */