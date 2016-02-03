package com.appbrain.f;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import cmn.z;
import com.appbrain.b.k;
import com.appbrain.b.t;
import com.appbrain.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
  protected Context a;
  private final f b = new f(new b());
  private cmn.c c;
  private final List d = new ArrayList();
  
  protected c(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  protected com.appbrain.g.c a(k paramk, String paramString)
  {
    com.appbrain.g.c localc = com.appbrain.g.b.H();
    localc.a(com.appbrain.b.d.a(paramk.b()));
    localc.a(paramString);
    localc.a(z.a(this.a).f());
    paramk = this.d.iterator();
    while (paramk.hasNext())
    {
      paramString = (d)paramk.next();
      t localt = paramString.a();
      if (localt != null)
      {
        localc.b(localt.a());
        localc.b(paramString.b());
      }
    }
    return localc;
  }
  
  protected final void a(cmn.d paramd)
  {
    this.c = new cmn.c(paramd);
  }
  
  protected byte[] b(k paramk, String paramString)
  {
    Object localObject = paramString;
    if (paramString.indexOf('$') != -1) {
      localObject = paramString.substring(paramString.lastIndexOf('$') + 1);
    }
    paramk = a(paramk, (String)localObject);
    paramk = this.c.a((String)localObject, this.b.a(paramk).b());
    if (paramk == null)
    {
      paramk = null;
      if (paramk.b != null) {
        throw new a(paramk.b);
      }
    }
    else
    {
      localObject = com.appbrain.g.b.a(paramk);
      this.b.a((com.appbrain.g.b)localObject);
      paramk = e.a((com.appbrain.g.b)localObject);
      if (((com.appbrain.g.b)localObject).G() != 0)
      {
        if (((com.appbrain.g.b)localObject).G() == ((com.appbrain.g.b)localObject).F()) {
          break label165;
        }
        Log.e("RPC", "RPC extension count not matching " + ((com.appbrain.g.b)localObject).G() + " " + ((com.appbrain.g.b)localObject).F());
      }
      for (;;)
      {
        break;
        label165:
        paramString = new SparseArray(((com.appbrain.g.b)localObject).G());
        int i = 0;
        while (i < ((com.appbrain.g.b)localObject).G())
        {
          paramString.put(((com.appbrain.g.b)localObject).a(i), ((com.appbrain.g.b)localObject).b(i));
          i += 1;
        }
        localObject = this.d.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramString.get(((d)((Iterator)localObject).next()).b());
        }
      }
    }
    return paramk.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */