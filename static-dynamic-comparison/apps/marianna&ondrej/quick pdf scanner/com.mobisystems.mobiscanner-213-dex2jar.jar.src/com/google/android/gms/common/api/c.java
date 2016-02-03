package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.internal.ee;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract interface c
{
  public abstract <C extends a.a> C a(a.b<C> paramb);
  
  public abstract <A extends a.a, T extends j.a<? extends f, A>> T a(T paramT);
  
  public abstract <A extends a.a, T extends j.a<? extends f, A>> T b(T paramT);
  
  public abstract void connect();
  
  public abstract boolean isConnected();
  
  public static abstract interface a {}
  
  public static final class b
  {
    private final Context mContext;
    private String qS;
    private final Set<String> qT = new HashSet();
    private int qU;
    private View qV;
    private String qW;
    private final Map<a, c.a> qX = new HashMap();
    private Looper qY;
    private final Set<c.c> qZ = new HashSet();
    private final Set<c.d> ra = new HashSet();
    
    public b(Context paramContext)
    {
      this.mContext = paramContext;
      this.qY = paramContext.getMainLooper();
      this.qW = paramContext.getPackageName();
    }
    
    public b a(a parama)
    {
      return a(parama, null);
    }
    
    public b a(a parama, c.a parama1)
    {
      this.qX.put(parama, parama1);
      parama = parama.mn();
      int j = parama.size();
      int i = 0;
      while (i < j)
      {
        this.qT.add(((h)parama.get(i)).mr());
        i += 1;
      }
      return this;
    }
    
    public b a(c.c paramc)
    {
      this.qZ.add(paramc);
      return this;
    }
    
    public b a(c.d paramd)
    {
      this.ra.add(paramd);
      return this;
    }
    
    public b a(h paramh)
    {
      this.qT.add(paramh.mr());
      return this;
    }
    
    public ee mo()
    {
      return new ee(this.qS, this.qT, this.qU, this.qV, this.qW);
    }
    
    public c mp()
    {
      return new k(this.mContext, this.qY, mo(), this.qX, this.qZ, this.ra);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(Bundle paramBundle);
    
    public abstract void bl(int paramInt);
  }
  
  public static abstract interface d
    extends com.google.android.gms.common.c.b
  {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/api/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */