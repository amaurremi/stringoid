package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class d
{
  private static d WL;
  private final a WH;
  private final c WI;
  private final ConcurrentMap<af, Boolean> WJ;
  private final ag WK;
  private final Context mContext;
  
  d(Context paramContext, a parama, c paramc)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.WH = parama;
    this.WJ = new ConcurrentHashMap();
    this.WI = paramc;
    this.WI.a(new c.b()
    {
      public void K(Map<String, Object> paramAnonymousMap)
      {
        paramAnonymousMap = paramAnonymousMap.get("event");
        if (paramAnonymousMap != null) {
          d.a(d.this, paramAnonymousMap.toString());
        }
      }
    });
    this.WI.a(new aa(this.mContext));
    this.WK = new ag();
  }
  
  public static d U(Context paramContext)
  {
    try
    {
      if (WL != null) {
        break label65;
      }
      if (paramContext == null)
      {
        j.Z("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
      }
    }
    finally {}
    WL = new d(paramContext, new a()new cnew ai {}, new c(new ai(paramContext)));
    label65:
    paramContext = WL;
    return paramContext;
  }
  
  private void bn(String paramString)
  {
    Iterator localIterator = this.WJ.keySet().iterator();
    while (localIterator.hasNext()) {
      ((af)localIterator.next()).bl(paramString);
    }
  }
  
  boolean a(af paramaf)
  {
    return this.WJ.remove(paramaf) != null;
  }
  
  boolean f(Uri paramUri)
  {
    for (;;)
    {
      boolean bool;
      Object localObject2;
      try
      {
        localObject1 = ce.vX();
        if (!((ce)localObject1).f(paramUri)) {
          break label229;
        }
        paramUri = ((ce)localObject1).vD();
        int i = 3.WN[localObject1.vY().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      Object localObject1 = this.WJ.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (af)((Iterator)localObject1).next();
        if (((af)localObject2).vD().equals(paramUri))
        {
          ((af)localObject2).bv(null);
          ((af)localObject2).refresh();
        }
      }
      else
      {
        continue;
        localObject2 = this.WJ.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          af localaf = (af)((Iterator)localObject2).next();
          if (localaf.vD().equals(paramUri))
          {
            localaf.bv(((ce)localObject1).vZ());
            localaf.refresh();
          }
          else if (localaf.wy() != null)
          {
            localaf.bv(null);
            localaf.refresh();
          }
        }
        continue;
        label229:
        bool = false;
      }
    }
  }
  
  static abstract interface a {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */