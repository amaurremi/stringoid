package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.as;
import com.google.android.gms.internal.as.a;

public final class SearchAdRequest
{
  public static final int BORDER_TYPE_DASHED = 1;
  public static final int BORDER_TYPE_DOTTED = 2;
  public static final int BORDER_TYPE_NONE = 0;
  public static final int BORDER_TYPE_SOLID = 3;
  public static final int CALL_BUTTON_COLOR_DARK = 2;
  public static final int CALL_BUTTON_COLOR_LIGHT = 0;
  public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
  public static final String DEVICE_ID_EMULATOR = as.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  private final as kp;
  private final int rR;
  private final int rS;
  private final int rT;
  private final int rU;
  private final int rV;
  private final int rW;
  private final int rX;
  private final int rY;
  private final String rZ;
  private final int sa;
  private final String sb;
  private final int sc;
  private final int sd;
  private final String se;
  
  private SearchAdRequest(Builder paramBuilder)
  {
    this.rR = Builder.a(paramBuilder);
    this.rS = Builder.b(paramBuilder);
    this.rT = Builder.c(paramBuilder);
    this.rU = Builder.d(paramBuilder);
    this.rV = Builder.e(paramBuilder);
    this.rW = Builder.f(paramBuilder);
    this.rX = Builder.g(paramBuilder);
    this.rY = Builder.h(paramBuilder);
    this.rZ = Builder.i(paramBuilder);
    this.sa = Builder.j(paramBuilder);
    this.sb = Builder.k(paramBuilder);
    this.sc = Builder.l(paramBuilder);
    this.sd = Builder.m(paramBuilder);
    this.se = Builder.n(paramBuilder);
    this.kp = new as(Builder.o(paramBuilder), this);
  }
  
  as O()
  {
    return this.kp;
  }
  
  public int getAnchorTextColor()
  {
    return this.rR;
  }
  
  public int getBackgroundColor()
  {
    return this.rS;
  }
  
  public int getBackgroundGradientBottom()
  {
    return this.rT;
  }
  
  public int getBackgroundGradientTop()
  {
    return this.rU;
  }
  
  public int getBorderColor()
  {
    return this.rV;
  }
  
  public int getBorderThickness()
  {
    return this.rW;
  }
  
  public int getBorderType()
  {
    return this.rX;
  }
  
  public int getCallButtonColor()
  {
    return this.rY;
  }
  
  public String getCustomChannels()
  {
    return this.rZ;
  }
  
  public int getDescriptionTextColor()
  {
    return this.sa;
  }
  
  public String getFontFace()
  {
    return this.sb;
  }
  
  public int getHeaderTextColor()
  {
    return this.sc;
  }
  
  public int getHeaderTextSize()
  {
    return this.sd;
  }
  
  public Location getLocation()
  {
    return this.kp.getLocation();
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return this.kp.getNetworkExtras(paramClass);
  }
  
  public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return this.kp.getNetworkExtrasBundle(paramClass);
  }
  
  public String getQuery()
  {
    return this.se;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.kp.isTestDevice(paramContext);
  }
  
  public static final class Builder
  {
    private final as.a kq = new as.a();
    private int rR;
    private int rS;
    private int rT;
    private int rU;
    private int rV;
    private int rW;
    private int rX = 0;
    private int rY;
    private String rZ;
    private int sa;
    private String sb;
    private int sc;
    private int sd;
    private String se;
    
    public Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
    {
      this.kq.a(paramNetworkExtras);
      return this;
    }
    
    public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.kq.a(paramClass, paramBundle);
      return this;
    }
    
    public Builder addTestDevice(String paramString)
    {
      this.kq.h(paramString);
      return this;
    }
    
    public SearchAdRequest build()
    {
      return new SearchAdRequest(this, null);
    }
    
    public Builder setAnchorTextColor(int paramInt)
    {
      this.rR = paramInt;
      return this;
    }
    
    public Builder setBackgroundColor(int paramInt)
    {
      this.rS = paramInt;
      this.rT = Color.argb(0, 0, 0, 0);
      this.rU = Color.argb(0, 0, 0, 0);
      return this;
    }
    
    public Builder setBackgroundGradient(int paramInt1, int paramInt2)
    {
      this.rS = Color.argb(0, 0, 0, 0);
      this.rT = paramInt2;
      this.rU = paramInt1;
      return this;
    }
    
    public Builder setBorderColor(int paramInt)
    {
      this.rV = paramInt;
      return this;
    }
    
    public Builder setBorderThickness(int paramInt)
    {
      this.rW = paramInt;
      return this;
    }
    
    public Builder setBorderType(int paramInt)
    {
      this.rX = paramInt;
      return this;
    }
    
    public Builder setCallButtonColor(int paramInt)
    {
      this.rY = paramInt;
      return this;
    }
    
    public Builder setCustomChannels(String paramString)
    {
      this.rZ = paramString;
      return this;
    }
    
    public Builder setDescriptionTextColor(int paramInt)
    {
      this.sa = paramInt;
      return this;
    }
    
    public Builder setFontFace(String paramString)
    {
      this.sb = paramString;
      return this;
    }
    
    public Builder setHeaderTextColor(int paramInt)
    {
      this.sc = paramInt;
      return this;
    }
    
    public Builder setHeaderTextSize(int paramInt)
    {
      this.sd = paramInt;
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      this.kq.a(paramLocation);
      return this;
    }
    
    public Builder setQuery(String paramString)
    {
      this.se = paramString;
      return this;
    }
    
    public Builder tagForChildDirectedTreatment(boolean paramBoolean)
    {
      this.kq.g(paramBoolean);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/ads/search/SearchAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */