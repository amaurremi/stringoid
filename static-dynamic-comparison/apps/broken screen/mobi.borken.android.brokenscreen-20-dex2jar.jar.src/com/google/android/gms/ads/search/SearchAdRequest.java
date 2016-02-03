package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.au;
import com.google.android.gms.internal.au.a;

public final class SearchAdRequest
{
  public static final int BORDER_TYPE_DASHED = 1;
  public static final int BORDER_TYPE_DOTTED = 2;
  public static final int BORDER_TYPE_NONE = 0;
  public static final int BORDER_TYPE_SOLID = 3;
  public static final int CALL_BUTTON_COLOR_DARK = 2;
  public static final int CALL_BUTTON_COLOR_LIGHT = 0;
  public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
  public static final String DEVICE_ID_EMULATOR = au.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  private final au kq;
  private final int sZ;
  private final int ta;
  private final int tb;
  private final int tc;
  private final int td;
  private final int te;
  private final int tf;
  private final int tg;
  private final String th;
  private final int ti;
  private final String tj;
  private final int tk;
  private final int tl;
  private final String tm;
  
  private SearchAdRequest(Builder paramBuilder)
  {
    this.sZ = Builder.a(paramBuilder);
    this.ta = Builder.b(paramBuilder);
    this.tb = Builder.c(paramBuilder);
    this.tc = Builder.d(paramBuilder);
    this.td = Builder.e(paramBuilder);
    this.te = Builder.f(paramBuilder);
    this.tf = Builder.g(paramBuilder);
    this.tg = Builder.h(paramBuilder);
    this.th = Builder.i(paramBuilder);
    this.ti = Builder.j(paramBuilder);
    this.tj = Builder.k(paramBuilder);
    this.tk = Builder.l(paramBuilder);
    this.tl = Builder.m(paramBuilder);
    this.tm = Builder.n(paramBuilder);
    this.kq = new au(Builder.o(paramBuilder), this);
  }
  
  au O()
  {
    return this.kq;
  }
  
  public int getAnchorTextColor()
  {
    return this.sZ;
  }
  
  public int getBackgroundColor()
  {
    return this.ta;
  }
  
  public int getBackgroundGradientBottom()
  {
    return this.tb;
  }
  
  public int getBackgroundGradientTop()
  {
    return this.tc;
  }
  
  public int getBorderColor()
  {
    return this.td;
  }
  
  public int getBorderThickness()
  {
    return this.te;
  }
  
  public int getBorderType()
  {
    return this.tf;
  }
  
  public int getCallButtonColor()
  {
    return this.tg;
  }
  
  public String getCustomChannels()
  {
    return this.th;
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return this.kq.getCustomEventExtrasBundle(paramClass);
  }
  
  public int getDescriptionTextColor()
  {
    return this.ti;
  }
  
  public String getFontFace()
  {
    return this.tj;
  }
  
  public int getHeaderTextColor()
  {
    return this.tk;
  }
  
  public int getHeaderTextSize()
  {
    return this.tl;
  }
  
  public Location getLocation()
  {
    return this.kq.getLocation();
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return this.kq.getNetworkExtras(paramClass);
  }
  
  public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return this.kq.getNetworkExtrasBundle(paramClass);
  }
  
  public String getQuery()
  {
    return this.tm;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.kq.isTestDevice(paramContext);
  }
  
  public static final class Builder
  {
    private final au.a kr = new au.a();
    private int sZ;
    private int ta;
    private int tb;
    private int tc;
    private int td;
    private int te;
    private int tf = 0;
    private int tg;
    private String th;
    private int ti;
    private String tj;
    private int tk;
    private int tl;
    private String tm;
    
    public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      this.kr.b(paramClass, paramBundle);
      return this;
    }
    
    public Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
    {
      this.kr.a(paramNetworkExtras);
      return this;
    }
    
    public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.kr.a(paramClass, paramBundle);
      return this;
    }
    
    public Builder addTestDevice(String paramString)
    {
      this.kr.h(paramString);
      return this;
    }
    
    public SearchAdRequest build()
    {
      return new SearchAdRequest(this, null);
    }
    
    public Builder setAnchorTextColor(int paramInt)
    {
      this.sZ = paramInt;
      return this;
    }
    
    public Builder setBackgroundColor(int paramInt)
    {
      this.ta = paramInt;
      this.tb = Color.argb(0, 0, 0, 0);
      this.tc = Color.argb(0, 0, 0, 0);
      return this;
    }
    
    public Builder setBackgroundGradient(int paramInt1, int paramInt2)
    {
      this.ta = Color.argb(0, 0, 0, 0);
      this.tb = paramInt2;
      this.tc = paramInt1;
      return this;
    }
    
    public Builder setBorderColor(int paramInt)
    {
      this.td = paramInt;
      return this;
    }
    
    public Builder setBorderThickness(int paramInt)
    {
      this.te = paramInt;
      return this;
    }
    
    public Builder setBorderType(int paramInt)
    {
      this.tf = paramInt;
      return this;
    }
    
    public Builder setCallButtonColor(int paramInt)
    {
      this.tg = paramInt;
      return this;
    }
    
    public Builder setCustomChannels(String paramString)
    {
      this.th = paramString;
      return this;
    }
    
    public Builder setDescriptionTextColor(int paramInt)
    {
      this.ti = paramInt;
      return this;
    }
    
    public Builder setFontFace(String paramString)
    {
      this.tj = paramString;
      return this;
    }
    
    public Builder setHeaderTextColor(int paramInt)
    {
      this.tk = paramInt;
      return this;
    }
    
    public Builder setHeaderTextSize(int paramInt)
    {
      this.tl = paramInt;
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      this.kr.a(paramLocation);
      return this;
    }
    
    public Builder setQuery(String paramString)
    {
      this.tm = paramString;
      return this;
    }
    
    public Builder tagForChildDirectedTreatment(boolean paramBoolean)
    {
      this.kr.h(paramBoolean);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/ads/search/SearchAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */