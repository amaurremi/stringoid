package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class k
{
  public static final String lC = cb.aF("emulator");
  private final Date gO;
  private final Set<String> gQ;
  private final String xf;
  private final int xg;
  private final Location xh;
  private final boolean xi;
  private final Map<Class<? extends com.google.android.gms.ads.b.a>, com.google.android.gms.ads.b.a> xj;
  private final String xk;
  private final com.google.android.gms.ads.search.a xl;
  private final int xm;
  private final Set<String> xn;
  
  public k(a parama)
  {
    this(parama, null);
  }
  
  public k(a parama, com.google.android.gms.ads.search.a parama1)
  {
    this.gO = a.a(parama);
    this.xf = a.b(parama);
    this.xg = a.c(parama);
    this.gQ = Collections.unmodifiableSet(a.d(parama));
    this.xh = a.e(parama);
    this.xi = a.f(parama);
    this.xj = Collections.unmodifiableMap(a.g(parama));
    this.xk = a.h(parama);
    this.xl = parama1;
    this.xm = a.i(parama);
    this.xn = Collections.unmodifiableSet(a.j(parama));
  }
  
  public boolean C(Context paramContext)
  {
    return this.xn.contains(cb.H(paramContext));
  }
  
  public <T extends com.google.android.gms.ads.b.a> T c(Class<T> paramClass)
  {
    return (com.google.android.gms.ads.b.a)this.xj.get(paramClass);
  }
  
  public Date oP()
  {
    return this.gO;
  }
  
  public String oQ()
  {
    return this.xf;
  }
  
  public int oR()
  {
    return this.xg;
  }
  
  public Set<String> oS()
  {
    return this.gQ;
  }
  
  public Location oT()
  {
    return this.xh;
  }
  
  public boolean oU()
  {
    return this.xi;
  }
  
  public String oV()
  {
    return this.xk;
  }
  
  public com.google.android.gms.ads.search.a oW()
  {
    return this.xl;
  }
  
  public Map<Class<? extends com.google.android.gms.ads.b.a>, com.google.android.gms.ads.b.a> oX()
  {
    return this.xj;
  }
  
  public int oY()
  {
    return this.xm;
  }
  
  public static final class a
  {
    private Date gO;
    private String xf;
    private int xg = -1;
    private Location xh;
    private boolean xi = false;
    private String xk;
    private int xm = -1;
    private final HashSet<String> xo = new HashSet();
    private final HashMap<Class<? extends com.google.android.gms.ads.b.a>, com.google.android.gms.ads.b.a> xp = new HashMap();
    private final HashSet<String> xq = new HashSet();
    
    public void az(String paramString)
    {
      this.xq.add(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */