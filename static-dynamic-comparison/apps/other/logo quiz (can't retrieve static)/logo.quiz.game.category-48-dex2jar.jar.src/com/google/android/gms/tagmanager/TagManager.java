package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
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
  private static TagManager arC;
  private final DataLayer anS;
  private final r aqj;
  private final cx arA;
  private final ConcurrentMap<n, Boolean> arB;
  private final a arz;
  private final Context mContext;
  
  TagManager(Context paramContext, a parama, DataLayer paramDataLayer, cx paramcx)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.arA = paramcx;
    this.arz = parama;
    this.arB = new ConcurrentHashMap();
    this.anS = paramDataLayer;
    this.anS.a(new DataLayer.b()
    {
      public void D(Map<String, Object> paramAnonymousMap)
      {
        paramAnonymousMap = paramAnonymousMap.get("event");
        if (paramAnonymousMap != null) {
          TagManager.a(TagManager.this, paramAnonymousMap.toString());
        }
      }
    });
    this.anS.a(new d(this.mContext));
    this.aqj = new r();
    pw();
  }
  
  private void cQ(String paramString)
  {
    Iterator localIterator = this.arB.keySet().iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).cm(paramString);
    }
  }
  
  public static TagManager getInstance(Context paramContext)
  {
    try
    {
      if (arC != null) {
        break label68;
      }
      if (paramContext == null)
      {
        bh.T("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
      }
    }
    finally {}
    arC = new TagManager(paramContext, new a()new DataLayernew v
    {
      public o a(Context paramAnonymousContext, TagManager paramAnonymousTagManager, Looper paramAnonymousLooper, String paramAnonymousString, int paramAnonymousInt, r paramAnonymousr)
      {
        return new o(paramAnonymousContext, paramAnonymousTagManager, paramAnonymousLooper, paramAnonymousString, paramAnonymousInt, paramAnonymousr);
      }
    }, new DataLayer(new v(paramContext)), cy.pu());
    label68:
    paramContext = arC;
    return paramContext;
  }
  
  private void pw()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.mContext.registerComponentCallbacks(new ComponentCallbacks2()
      {
        public void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
        
        public void onLowMemory() {}
        
        public void onTrimMemory(int paramAnonymousInt)
        {
          if (paramAnonymousInt == 20) {
            TagManager.this.dispatch();
          }
        }
      });
    }
  }
  
  void a(n paramn)
  {
    this.arB.put(paramn, Boolean.valueOf(true));
  }
  
  boolean b(n paramn)
  {
    return this.arB.remove(paramn) != null;
  }
  
  public void dispatch()
  {
    this.arA.dispatch();
  }
  
  public DataLayer getDataLayer()
  {
    return this.anS;
  }
  
  boolean i(Uri paramUri)
  {
    for (;;)
    {
      boolean bool;
      Object localObject2;
      try
      {
        localObject1 = ce.oH();
        if (!((ce)localObject1).i(paramUri)) {
          break label229;
        }
        paramUri = ((ce)localObject1).getContainerId();
        int i = 4.arE[localObject1.oI().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      Object localObject1 = this.arB.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (n)((Iterator)localObject1).next();
        if (((n)localObject2).getContainerId().equals(paramUri))
        {
          ((n)localObject2).co(null);
          ((n)localObject2).refresh();
        }
      }
      else
      {
        continue;
        localObject2 = this.arB.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          n localn = (n)((Iterator)localObject2).next();
          if (localn.getContainerId().equals(paramUri))
          {
            localn.co(((ce)localObject1).oJ());
            localn.refresh();
          }
          else if (localn.nS() != null)
          {
            localn.co(null);
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
    paramString = this.arz.a(this.mContext, this, null, paramString, paramInt, this.aqj);
    paramString.nV();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.arz.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.aqj);
    paramString.nV();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt)
  {
    paramString = this.arz.a(this.mContext, this, null, paramString, paramInt, this.aqj);
    paramString.nX();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.arz.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.aqj);
    paramString.nX();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt)
  {
    paramString = this.arz.a(this.mContext, this, null, paramString, paramInt, this.aqj);
    paramString.nW();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt, Handler paramHandler)
  {
    paramString = this.arz.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.aqj);
    paramString.nW();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/TagManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */