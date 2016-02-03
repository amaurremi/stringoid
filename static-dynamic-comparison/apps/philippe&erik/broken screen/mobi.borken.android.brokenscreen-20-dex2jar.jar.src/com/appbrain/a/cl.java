package com.appbrain.a;

import android.content.Context;
import cmn.ac.a;
import com.appbrain.b.c;
import com.appbrain.b.g;
import com.appbrain.b.m;
import com.appbrain.b.m.a;
import com.appbrain.e.h.a;
import com.appbrain.g.a.a;
import com.appbrain.g.a.a.a;
import java.util.ArrayList;
import java.util.List;

public abstract class cl
{
  private final br a;
  
  public cl(Context paramContext)
  {
    this.a = br.a(paramContext);
  }
  
  public static ac.a a(String paramString1, String paramString2)
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
    return new ac.a(localArrayList);
  }
  
  public final a.a.a a(g paramg, String paramString)
  {
    paramg = paramg.d();
    a(paramg, this.a.a());
    a.a.a locala = a.a.H();
    locala.a(c.a(paramg.c().b()));
    locala.a(paramString);
    return locala;
  }
  
  public abstract void a(m.a parama, h.a parama1);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */