package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class as
{
  public static final String DEVICE_ID_EMULATOR = dv.u("emulator");
  private final Date d;
  private final Set<String> f;
  private final Location h;
  private final String lY;
  private final int lZ;
  private final boolean ma;
  private final Map<Class<? extends MediationAdapter>, Bundle> mb;
  private final Map<Class<? extends NetworkExtras>, NetworkExtras> mc;
  private final String md;
  private final SearchAdRequest me;
  private final int mf;
  private final Set<String> mg;
  
  public as(a parama)
  {
    this(parama, null);
  }
  
  public as(a parama, SearchAdRequest paramSearchAdRequest)
  {
    this.d = a.a(parama);
    this.lY = a.b(parama);
    this.lZ = a.c(parama);
    this.f = Collections.unmodifiableSet(a.d(parama));
    this.h = a.e(parama);
    this.ma = a.f(parama);
    this.mb = Collections.unmodifiableMap(a.g(parama));
    this.mc = Collections.unmodifiableMap(a.h(parama));
    this.md = a.i(parama);
    this.me = paramSearchAdRequest;
    this.mf = a.j(parama);
    this.mg = Collections.unmodifiableSet(a.k(parama));
  }
  
  public SearchAdRequest aB()
  {
    return this.me;
  }
  
  public Map<Class<? extends NetworkExtras>, NetworkExtras> aC()
  {
    return this.mc;
  }
  
  public Map<Class<? extends MediationAdapter>, Bundle> aD()
  {
    return this.mb;
  }
  
  public int aE()
  {
    return this.mf;
  }
  
  public Date getBirthday()
  {
    return this.d;
  }
  
  public String getContentUrl()
  {
    return this.lY;
  }
  
  public int getGender()
  {
    return this.lZ;
  }
  
  public Set<String> getKeywords()
  {
    return this.f;
  }
  
  public Location getLocation()
  {
    return this.h;
  }
  
  public boolean getManualImpressionsEnabled()
  {
    return this.ma;
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return (NetworkExtras)this.mc.get(paramClass);
  }
  
  public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass)
  {
    return (Bundle)this.mb.get(paramClass);
  }
  
  public String getPublisherProvidedId()
  {
    return this.md;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.mg.contains(dv.l(paramContext));
  }
  
  public static final class a
  {
    private Date d;
    private Location h;
    private String lY;
    private int lZ = -1;
    private boolean ma = false;
    private String md;
    private int mf = -1;
    private final HashSet<String> mh = new HashSet();
    private final HashMap<Class<? extends MediationAdapter>, Bundle> mi = new HashMap();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> mj = new HashMap();
    private final HashSet<String> mk = new HashSet();
    
    public void a(Location paramLocation)
    {
      this.h = paramLocation;
    }
    
    @Deprecated
    public void a(NetworkExtras paramNetworkExtras)
    {
      if ((paramNetworkExtras instanceof AdMobExtras))
      {
        a(AdMobAdapter.class, ((AdMobExtras)paramNetworkExtras).getExtras());
        return;
      }
      this.mj.put(paramNetworkExtras.getClass(), paramNetworkExtras);
    }
    
    public void a(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.mi.put(paramClass, paramBundle);
    }
    
    public void a(Date paramDate)
    {
      this.d = paramDate;
    }
    
    public void d(int paramInt)
    {
      this.lZ = paramInt;
    }
    
    public void f(boolean paramBoolean)
    {
      this.ma = paramBoolean;
    }
    
    public void g(String paramString)
    {
      this.mh.add(paramString);
    }
    
    public void g(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        this.mf = i;
        return;
      }
    }
    
    public void h(String paramString)
    {
      this.mk.add(paramString);
    }
    
    public void i(String paramString)
    {
      this.lY = paramString;
    }
    
    public void j(String paramString)
    {
      this.md = paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */