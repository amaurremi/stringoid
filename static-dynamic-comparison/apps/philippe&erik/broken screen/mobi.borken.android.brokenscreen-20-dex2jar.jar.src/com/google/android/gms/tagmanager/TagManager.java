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
  private static TagManager aid;
  private final DataLayer aer;
  private final r agL;
  private final a aib;
  private final ConcurrentMap<n, Boolean> aic;
  private final Context mContext;
  
  TagManager(Context paramContext, a parama, DataLayer paramDataLayer)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.aib = parama;
    this.aic = new ConcurrentHashMap();
    this.aer = paramDataLayer;
    this.aer.a(new DataLayer.b()
    {
      public void x(Map<String, Object> paramAnonymousMap)
      {
        paramAnonymousMap = paramAnonymousMap.get("event");
        if (paramAnonymousMap != null) {
          TagManager.a(TagManager.this, paramAnonymousMap.toString());
        }
      }
    });
    this.aer.a(new d(this.mContext));
    this.agL = new r();
  }
  
  private void cl(String paramString)
  {
    Iterator localIterator = this.aic.keySet().iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).bH(paramString);
    }
  }
  
  public static TagManager getInstance(Context paramContext)
  {
    try
    {
      if (aid != null) {
        break label65;
      }
      if (paramContext == null)
      {
        bh.A("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
      }
    }
    finally {}
    aid = new TagManager(paramContext, new a()new DataLayernew v
    {
      public o a(Context paramAnonymousContext, TagManager paramAnonymousTagManager, Looper paramAnonymousLooper, String paramAnonymousString, int paramAnonymousInt, r paramAnonymousr)
      {
        return new o(paramAnonymousContext, paramAnonymousTagManager, paramAnonymousLooper, paramAnonymousString, paramAnonymousInt, paramAnonymousr);
      }
    }, new DataLayer(new v(paramContext)));
    label65:
    paramContext = aid;
    return paramContext;
  }
  
  void a(n paramn)
  {
    this.aic.put(paramn, Boolean.valueOf(true));
  }
  
  boolean b(n paramn)
  {
    return this.aic.remove(paramn) != null;
  }
  
  public DataLayer getDataLayer()
  {
    return this.aer;
  }
  
  boolean h(Uri paramUri)
  {
    for (;;)
    {
      boolean bool;
      Object localObject2;
      try
      {
        localObject1 = cd.lY();
        if (!((cd)localObject1).h(paramUri)) {
          break label229;
        }
        paramUri = ((cd)localObject1).getContainerId();
        int i = 3.aif[localObject1.lZ().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      Object localObject1 = this.aic.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (n)((Iterator)localObject1).next();
        if (((n)localObject2).getContainerId().equals(paramUri))
        {
          ((n)localObject2).bJ(null);
          ((n)localObject2).refresh();
        }
      }
      else
      {
        continue;
        localObject2 = this.aic.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          n localn = (n)((Iterator)localObject2).next();
          if (localn.getContainerId().equals(paramUri))
          {
            localn.bJ(((cd)localObject1).ma());
            localn.refresh();
          }
          else if (localn.lj() != null)
          {
            localn.bJ(null);
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
    paramString = this.aib.a(this.mContext, this, null, paramString, paramInt, this.agL);
    paramString.lm();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.aib.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.agL);
    paramString.lm();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt)
  {
    paramString = this.aib.a(this.mContext, this, null, paramString, paramInt, this.agL);
    paramString.lo();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.aib.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.agL);
    paramString.lo();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt)
  {
    paramString = this.aib.a(this.mContext, this, null, paramString, paramInt, this.agL);
    paramString.ln();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.aib.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.agL);
    paramString.ln();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/TagManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */