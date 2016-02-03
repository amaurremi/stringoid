package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.af;
import com.google.android.gms.internal.af.a;

public final class SearchAdRequest
{
  public static final int BORDER_TYPE_DASHED = 1;
  public static final int BORDER_TYPE_DOTTED = 2;
  public static final int BORDER_TYPE_NONE = 0;
  public static final int BORDER_TYPE_SOLID = 3;
  public static final int CALL_BUTTON_COLOR_DARK = 2;
  public static final int CALL_BUTTON_COLOR_LIGHT = 0;
  public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
  public static final String DEVICE_ID_EMULATOR = af.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  private final af dW;
  private final int jj;
  private final int jk;
  private final int jl;
  private final int jm;
  private final int jn;
  private final int jo;
  private final int jp;
  private final int jq;
  private final String jr;
  private final int js;
  private final String jt;
  private final int ju;
  private final int jv;
  private final String jw;
  
  private SearchAdRequest(Builder paramBuilder)
  {
    this.jj = Builder.a(paramBuilder);
    this.jk = Builder.b(paramBuilder);
    this.jl = Builder.c(paramBuilder);
    this.jm = Builder.d(paramBuilder);
    this.jn = Builder.e(paramBuilder);
    this.jo = Builder.f(paramBuilder);
    this.jp = Builder.g(paramBuilder);
    this.jq = Builder.h(paramBuilder);
    this.jr = Builder.i(paramBuilder);
    this.js = Builder.j(paramBuilder);
    this.jt = Builder.k(paramBuilder);
    this.ju = Builder.l(paramBuilder);
    this.jv = Builder.m(paramBuilder);
    this.jw = Builder.n(paramBuilder);
    this.dW = new af(Builder.o(paramBuilder), this);
  }
  
  public int getAnchorTextColor()
  {
    return this.jj;
  }
  
  public int getBackgroundColor()
  {
    return this.jk;
  }
  
  public int getBackgroundGradientBottom()
  {
    return this.jl;
  }
  
  public int getBackgroundGradientTop()
  {
    return this.jm;
  }
  
  public int getBorderColor()
  {
    return this.jn;
  }
  
  public int getBorderThickness()
  {
    return this.jo;
  }
  
  public int getBorderType()
  {
    return this.jp;
  }
  
  public int getCallButtonColor()
  {
    return this.jq;
  }
  
  public String getCustomChannels()
  {
    return this.jr;
  }
  
  public int getDescriptionTextColor()
  {
    return this.js;
  }
  
  public String getFontFace()
  {
    return this.jt;
  }
  
  public int getHeaderTextColor()
  {
    return this.ju;
  }
  
  public int getHeaderTextSize()
  {
    return this.jv;
  }
  
  public Location getLocation()
  {
    return this.dW.getLocation();
  }
  
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return this.dW.getNetworkExtras(paramClass);
  }
  
  public String getQuery()
  {
    return this.jw;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.dW.isTestDevice(paramContext);
  }
  
  af v()
  {
    return this.dW;
  }
  
  public static final class Builder
  {
    private final af.a dX = new af.a();
    private int jj;
    private int jk;
    private int jl;
    private int jm;
    private int jn;
    private int jo;
    private int jp = 0;
    private int jq;
    private String jr;
    private int js;
    private String jt;
    private int ju;
    private int jv;
    private String jw;
    
    public Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
    {
      this.dX.a(paramNetworkExtras);
      return this;
    }
    
    public Builder addTestDevice(String paramString)
    {
      this.dX.h(paramString);
      return this;
    }
    
    public SearchAdRequest build()
    {
      return new SearchAdRequest(this, null);
    }
    
    public Builder setAnchorTextColor(int paramInt)
    {
      this.jj = paramInt;
      return this;
    }
    
    public Builder setBackgroundColor(int paramInt)
    {
      this.jk = paramInt;
      this.jl = Color.argb(0, 0, 0, 0);
      this.jm = Color.argb(0, 0, 0, 0);
      return this;
    }
    
    public Builder setBackgroundGradient(int paramInt1, int paramInt2)
    {
      this.jk = Color.argb(0, 0, 0, 0);
      this.jl = paramInt2;
      this.jm = paramInt1;
      return this;
    }
    
    public Builder setBorderColor(int paramInt)
    {
      this.jn = paramInt;
      return this;
    }
    
    public Builder setBorderThickness(int paramInt)
    {
      this.jo = paramInt;
      return this;
    }
    
    public Builder setBorderType(int paramInt)
    {
      this.jp = paramInt;
      return this;
    }
    
    public Builder setCallButtonColor(int paramInt)
    {
      this.jq = paramInt;
      return this;
    }
    
    public Builder setCustomChannels(String paramString)
    {
      this.jr = paramString;
      return this;
    }
    
    public Builder setDescriptionTextColor(int paramInt)
    {
      this.js = paramInt;
      return this;
    }
    
    public Builder setFontFace(String paramString)
    {
      this.jt = paramString;
      return this;
    }
    
    public Builder setHeaderTextColor(int paramInt)
    {
      this.ju = paramInt;
      return this;
    }
    
    public Builder setHeaderTextSize(int paramInt)
    {
      this.jv = paramInt;
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      this.dX.a(paramLocation);
      return this;
    }
    
    public Builder setQuery(String paramString)
    {
      this.jw = paramString;
      return this;
    }
    
    public Builder tagForChildDirectedTreatment(boolean paramBoolean)
    {
      this.dX.e(paramBoolean);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/ads/search/SearchAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */