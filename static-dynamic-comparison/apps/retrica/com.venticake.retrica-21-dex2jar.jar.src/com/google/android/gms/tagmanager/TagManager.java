package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager
{
  private static TagManager aig;
  private final DataLayer aeu;
  private final dz agO;
  private final f aie;
  private final ConcurrentMap<n, Boolean> aif;
  private final Context mContext;
  
  TagManager(Context paramContext, f paramf, DataLayer paramDataLayer)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.aie = paramf;
    this.aif = new ConcurrentHashMap();
    this.aeu = paramDataLayer;
    this.aeu.a(new e()
    {
      public void a(Map<String, Object> paramAnonymousMap)
      {
        paramAnonymousMap = paramAnonymousMap.get("event");
        if (paramAnonymousMap != null) {
          TagManager.a(TagManager.this, paramAnonymousMap.toString());
        }
      }
    });
    this.aeu.a(new cv(this.mContext));
    this.agO = new dz();
  }
  
  private void cl(String paramString)
  {
    Iterator localIterator = this.aif.keySet().iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).a(paramString);
    }
  }
  
  public static TagManager getInstance(Context paramContext)
  {
    try
    {
      if (aig != null) {
        break label65;
      }
      if (paramContext == null)
      {
        as.a("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
      }
    }
    finally {}
    aig = new TagManager(paramContext, new f()new DataLayernew ec
    {
      public dq a(Context paramAnonymousContext, TagManager paramAnonymousTagManager, Looper paramAnonymousLooper, String paramAnonymousString, int paramAnonymousInt, dz paramAnonymousdz)
      {
        return new dq(paramAnonymousContext, paramAnonymousTagManager, paramAnonymousLooper, paramAnonymousString, paramAnonymousInt, paramAnonymousdz);
      }
    }, new DataLayer(new ec(paramContext)));
    label65:
    paramContext = aig;
    return paramContext;
  }
  
  void a(n paramn)
  {
    this.aif.put(paramn, Boolean.valueOf(true));
  }
  
  boolean b(n paramn)
  {
    return this.aif.remove(paramn) != null;
  }
  
  public DataLayer getDataLayer()
  {
    return this.aeu;
  }
  
  boolean i(Uri paramUri)
  {
    for (;;)
    {
      boolean bool;
      Object localObject2;
      try
      {
        localObject1 = br.a();
        if (!((br)localObject1).a(paramUri)) {
          break label229;
        }
        paramUri = ((br)localObject1).d();
        int i = 3.a[localObject1.b().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      Object localObject1 = this.aif.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (n)((Iterator)localObject1).next();
        if (((n)localObject2).a().equals(paramUri))
        {
          ((n)localObject2).b(null);
          ((n)localObject2).refresh();
        }
      }
      else
      {
        continue;
        localObject2 = this.aif.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          n localn = (n)((Iterator)localObject2).next();
          if (localn.a().equals(paramUri))
          {
            localn.b(((br)localObject1).c());
            localn.refresh();
          }
          else if (localn.b() != null)
          {
            localn.b(null);
            localn.refresh();
          }
        }
        continue;
        label229:
        bool = false;
      }
    }
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt)
  {
    paramString = this.aie.a(this.mContext, this, null, paramString, paramInt, this.agO);
    paramString.a();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.aie.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.agO);
    paramString.a();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt)
  {
    paramString = this.aie.a(this.mContext, this, null, paramString, paramInt, this.agO);
    paramString.c();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.aie.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.agO);
    paramString.c();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt)
  {
    paramString = this.aie.a(this.mContext, this, null, paramString, paramInt, this.agO);
    paramString.b();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.aie.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.agO);
    paramString.b();
    return paramString;
  }
  
  public void setVerboseLoggingEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 5)
    {
      as.a(i);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/TagManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */