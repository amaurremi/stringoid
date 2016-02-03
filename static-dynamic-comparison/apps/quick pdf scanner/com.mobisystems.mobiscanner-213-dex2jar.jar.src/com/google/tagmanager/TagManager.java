package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager
{
  private static TagManager aiM;
  private final a aiI;
  private final c aiJ;
  private volatile RefreshMode aiK;
  private final ConcurrentMap<String, Container> aiL;
  private final Context mContext;
  
  TagManager(Context paramContext, a parama, c paramc)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.aiI = parama;
    this.aiK = RefreshMode.aiP;
    this.aiL = new ConcurrentHashMap();
    this.aiJ = paramc;
    this.aiJ.a(new c.a() {});
    this.aiJ.a(new a(this.mContext));
  }
  
  public static TagManager V(Context paramContext)
  {
    try
    {
      if (aiM == null) {
        aiM = new TagManager(paramContext, new a()new c {}, new c());
      }
      paramContext = aiM;
      return paramContext;
    }
    finally {}
  }
  
  public RefreshMode Ax()
  {
    return this.aiK;
  }
  
  boolean h(Uri paramUri)
  {
    for (;;)
    {
      PreviewManager localPreviewManager;
      boolean bool;
      try
      {
        localPreviewManager = PreviewManager.Au();
        if (!localPreviewManager.h(paramUri)) {
          break label212;
        }
        paramUri = localPreviewManager.vD();
        int i = 3.aiO[localPreviewManager.Av().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      paramUri = (Container)this.aiL.get(paramUri);
      if (paramUri != null)
      {
        paramUri.cQ(null);
        paramUri.refresh();
        continue;
        Iterator localIterator = this.aiL.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          Container localContainer = (Container)localEntry.getValue();
          if (((String)localEntry.getKey()).equals(paramUri))
          {
            localContainer.cQ(localPreviewManager.Aw());
            localContainer.refresh();
          }
          else if (localContainer.As() != null)
          {
            localContainer.cQ(null);
            localContainer.refresh();
          }
        }
        continue;
        label212:
        bool = false;
      }
    }
  }
  
  public static enum RefreshMode
  {
    private RefreshMode() {}
  }
  
  static abstract interface a {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/TagManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */