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
  private static TagManager aay;
  private final DataLayer WK;
  private final r Zg;
  private final a aaw;
  private final ConcurrentMap<n, Boolean> aax;
  private final Context mContext;
  
  TagManager(Context paramContext, a parama, DataLayer paramDataLayer)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.aaw = parama;
    this.aax = new ConcurrentHashMap();
    this.WK = paramDataLayer;
    this.WK.a(new DataLayer.b()
    {
      public void y(Map<String, Object> paramAnonymousMap)
      {
        paramAnonymousMap = paramAnonymousMap.get("event");
        if (paramAnonymousMap != null) {
          TagManager.a(TagManager.this, paramAnonymousMap.toString());
        }
      }
    });
    this.WK.a(new d(this.mContext));
    this.Zg = new r();
  }
  
  private void bT(String paramString)
  {
    Iterator localIterator = this.aax.keySet().iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).bp(paramString);
    }
  }
  
  public static TagManager getInstance(Context paramContext)
  {
    try
    {
      if (aay != null) {
        break label65;
      }
      if (paramContext == null)
      {
        bh.w("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
      }
    }
    finally {}
    aay = new TagManager(paramContext, new a()new DataLayernew v
    {
      public o a(Context paramAnonymousContext, TagManager paramAnonymousTagManager, Looper paramAnonymousLooper, String paramAnonymousString, int paramAnonymousInt, r paramAnonymousr)
      {
        return new o(paramAnonymousContext, paramAnonymousTagManager, paramAnonymousLooper, paramAnonymousString, paramAnonymousInt, paramAnonymousr);
      }
    }, new DataLayer(new v(paramContext)));
    label65:
    paramContext = aay;
    return paramContext;
  }
  
  void a(n paramn)
  {
    this.aax.put(paramn, Boolean.valueOf(true));
  }
  
  boolean b(n paramn)
  {
    return this.aax.remove(paramn) != null;
  }
  
  boolean g(Uri paramUri)
  {
    for (;;)
    {
      boolean bool;
      Object localObject2;
      try
      {
        localObject1 = cd.kT();
        if (!((cd)localObject1).g(paramUri)) {
          break label229;
        }
        paramUri = ((cd)localObject1).getContainerId();
        int i = 3.aaA[localObject1.kU().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      Object localObject1 = this.aax.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (n)((Iterator)localObject1).next();
        if (((n)localObject2).getContainerId().equals(paramUri))
        {
          ((n)localObject2).br(null);
          ((n)localObject2).refresh();
        }
      }
      else
      {
        continue;
        localObject2 = this.aax.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          n localn = (n)((Iterator)localObject2).next();
          if (localn.getContainerId().equals(paramUri))
          {
            localn.br(((cd)localObject1).kV());
            localn.refresh();
          }
          else if (localn.ke() != null)
          {
            localn.br(null);
            localn.refresh();
          }
        }
        continue;
        label229:
        bool = false;
      }
    }
  }
  
  public DataLayer getDataLayer()
  {
    return this.WK;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt)
  {
    paramString = this.aaw.a(this.mContext, this, null, paramString, paramInt, this.Zg);
    paramString.kh();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.aaw.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.Zg);
    paramString.kh();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt)
  {
    paramString = this.aaw.a(this.mContext, this, null, paramString, paramInt, this.Zg);
    paramString.kj();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.aaw.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.Zg);
    paramString.kj();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt)
  {
    paramString = this.aaw.a(this.mContext, this, null, paramString, paramInt, this.Zg);
    paramString.ki();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.aaw.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.Zg);
    paramString.ki();
    return paramString;
  }
  
  public void setVerboseLoggingEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 5)
    {
      bh.setLogLevel(i);
      return;
    }
  }
  
  static abstract interface a
  {
    public abstract o a(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, r paramr);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/TagManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */