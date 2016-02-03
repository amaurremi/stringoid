package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class af
{
  public static final String DEVICE_ID_EMULATOR = cs.q("emulator");
  private final Date d;
  private final int eL;
  private final Location eM;
  private final boolean eN;
  private final Map<Class<? extends NetworkExtras>, NetworkExtras> eO;
  private final String eP;
  private final SearchAdRequest eQ;
  private final int eR;
  private final Set<String> eS;
  private final Set<String> f;
  
  public af(a parama)
  {
    this(parama, null);
  }
  
  public af(a parama, SearchAdRequest paramSearchAdRequest)
  {
    this.d = a.a(parama);
    this.eL = a.b(parama);
    this.f = Collections.unmodifiableSet(a.c(parama));
    this.eM = a.d(parama);
    this.eN = a.e(parama);
    this.eO = Collections.unmodifiableMap(a.f(parama));
    this.eP = a.g(parama);
    this.eQ = paramSearchAdRequest;
    this.eR = a.h(parama);
    this.eS = Collections.unmodifiableSet(a.i(parama));
  }
  
  public SearchAdRequest Q()
  {
    return this.eQ;
  }
  
  public Map<Class<? extends NetworkExtras>, NetworkExtras> R()
  {
    return this.eO;
  }
  
  public int S()
  {
    return this.eR;
  }
  
  public Date getBirthday()
  {
    return this.d;
  }
  
  public int getGender()
  {
    return this.eL;
  }
  
  public Set<String> getKeywords()
  {
    return this.f;
  }
  
  public Location getLocation()
  {
    return this.eM;
  }
  
  public boolean getManualImpressionsEnabled()
  {
    return this.eN;
  }
  
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return (NetworkExtras)this.eO.get(paramClass);
  }
  
  public String getPublisherProvidedId()
  {
    return this.eP;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.eS.contains(cs.l(paramContext));
  }
  
  public static final class a
  {
    private Date d;
    private int eL = -1;
    private Location eM;
    private boolean eN = false;
    private String eP;
    private int eR = -1;
    private final HashSet<String> eT = new HashSet();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> eU = new HashMap();
    private final HashSet<String> eV = new HashSet();
    
    public void a(Location paramLocation)
    {
      this.eM = paramLocation;
    }
    
    public void a(NetworkExtras paramNetworkExtras)
    {
      this.eU.put(paramNetworkExtras.getClass(), paramNetworkExtras);
    }
    
    public void a(Date paramDate)
    {
      this.d = paramDate;
    }
    
    public void d(int paramInt)
    {
      this.eL = paramInt;
    }
    
    public void d(boolean paramBoolean)
    {
      this.eN = paramBoolean;
    }
    
    public void e(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        this.eR = i;
        return;
      }
    }
    
    public void g(String paramString)
    {
      this.eT.add(paramString);
    }
    
    public void h(String paramString)
    {
      this.eV.add(paramString);
    }
    
    public void i(String paramString)
    {
      this.eP = paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */