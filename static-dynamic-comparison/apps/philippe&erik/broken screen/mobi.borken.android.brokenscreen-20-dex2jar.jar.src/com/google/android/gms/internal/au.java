package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class au
{
  public static final String DEVICE_ID_EMULATOR = eu.y("emulator");
  private final Date d;
  private final Set<String> f;
  private final Location h;
  private final String mi;
  private final int mj;
  private final boolean mk;
  private final Bundle ml;
  private final Map<Class<? extends NetworkExtras>, NetworkExtras> mm;
  private final String mn;
  private final SearchAdRequest mo;
  private final int mp;
  private final Set<String> mq;
  
  public au(a parama)
  {
    this(parama, null);
  }
  
  public au(a parama, SearchAdRequest paramSearchAdRequest)
  {
    this.d = a.a(parama);
    this.mi = a.b(parama);
    this.mj = a.c(parama);
    this.f = Collections.unmodifiableSet(a.d(parama));
    this.h = a.e(parama);
    this.mk = a.f(parama);
    this.ml = a.g(parama);
    this.mm = Collections.unmodifiableMap(a.h(parama));
    this.mn = a.i(parama);
    this.mo = paramSearchAdRequest;
    this.mp = a.j(parama);
    this.mq = Collections.unmodifiableSet(a.k(parama));
  }
  
  public SearchAdRequest aC()
  {
    return this.mo;
  }
  
  public Map<Class<? extends NetworkExtras>, NetworkExtras> aD()
  {
    return this.mm;
  }
  
  public Bundle aE()
  {
    return this.ml;
  }
  
  public int aF()
  {
    return this.mp;
  }
  
  public Date getBirthday()
  {
    return this.d;
  }
  
  public String getContentUrl()
  {
    return this.mi;
  }
  
  public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass)
  {
    Bundle localBundle = this.ml.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
    if (localBundle != null) {
      return localBundle.getBundle(paramClass.getClass().getName());
    }
    return null;
  }
  
  public int getGender()
  {
    return this.mj;
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
    return this.mk;
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return (NetworkExtras)this.mm.get(paramClass);
  }
  
  public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass)
  {
    return this.ml.getBundle(paramClass.getName());
  }
  
  public String getPublisherProvidedId()
  {
    return this.mn;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.mq.contains(eu.o(paramContext));
  }
  
  public static final class a
  {
    private Date d;
    private Location h;
    private String mi;
    private int mj = -1;
    private boolean mk = false;
    private final Bundle ml = new Bundle();
    private String mn;
    private int mp = -1;
    private final HashSet<String> mr = new HashSet();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> ms = new HashMap();
    private final HashSet<String> mt = new HashSet();
    
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
      this.ms.put(paramNetworkExtras.getClass(), paramNetworkExtras);
    }
    
    public void a(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.ml.putBundle(paramClass.getName(), paramBundle);
    }
    
    public void a(Date paramDate)
    {
      this.d = paramDate;
    }
    
    public void b(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      if (this.ml.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
        this.ml.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
      }
      this.ml.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(paramClass.getName(), paramBundle);
    }
    
    public void e(int paramInt)
    {
      this.mj = paramInt;
    }
    
    public void g(String paramString)
    {
      this.mr.add(paramString);
    }
    
    public void g(boolean paramBoolean)
    {
      this.mk = paramBoolean;
    }
    
    public void h(String paramString)
    {
      this.mt.add(paramString);
    }
    
    public void h(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        this.mp = i;
        return;
      }
    }
    
    public void i(String paramString)
    {
      this.mi = paramString;
    }
    
    public void j(String paramString)
    {
      this.mn = paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */