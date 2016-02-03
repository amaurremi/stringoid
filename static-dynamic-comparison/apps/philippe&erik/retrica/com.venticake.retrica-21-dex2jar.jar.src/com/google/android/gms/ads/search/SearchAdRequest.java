package com.google.android.gms.ads.search;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.at;

public final class SearchAdRequest
{
  public static final int BORDER_TYPE_DASHED = 1;
  public static final int BORDER_TYPE_DOTTED = 2;
  public static final int BORDER_TYPE_NONE = 0;
  public static final int BORDER_TYPE_SOLID = 3;
  public static final int CALL_BUTTON_COLOR_DARK = 2;
  public static final int CALL_BUTTON_COLOR_LIGHT = 0;
  public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
  public static final String DEVICE_ID_EMULATOR = at.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  private final at ks;
  private final int tc;
  private final int td;
  private final int te;
  private final int tf;
  private final int tg;
  private final int th;
  private final int ti;
  private final int tj;
  private final String tk;
  private final int tl;
  private final String tm;
  private final int tn;
  private final int to;
  private final String tp;
  
  private SearchAdRequest(SearchAdRequest.Builder paramBuilder)
  {
    this.tc = SearchAdRequest.Builder.a(paramBuilder);
    this.td = SearchAdRequest.Builder.b(paramBuilder);
    this.te = SearchAdRequest.Builder.c(paramBuilder);
    this.tf = SearchAdRequest.Builder.d(paramBuilder);
    this.tg = SearchAdRequest.Builder.e(paramBuilder);
    this.th = SearchAdRequest.Builder.f(paramBuilder);
    this.ti = SearchAdRequest.Builder.g(paramBuilder);
    this.tj = SearchAdRequest.Builder.h(paramBuilder);
    this.tk = SearchAdRequest.Builder.i(paramBuilder);
    this.tl = SearchAdRequest.Builder.j(paramBuilder);
    this.tm = SearchAdRequest.Builder.k(paramBuilder);
    this.tn = SearchAdRequest.Builder.l(paramBuilder);
    this.to = SearchAdRequest.Builder.m(paramBuilder);
    this.tp = SearchAdRequest.Builder.n(paramBuilder);
    this.ks = new at(SearchAdRequest.Builder.o(paramBuilder), this);
  }
  
  at T()
  {
    return this.ks;
  }
  
  public int getAnchorTextColor()
  {
    return this.tc;
  }
  
  public int getBackgroundColor()
  {
    return this.td;
  }
  
  public int getBackgroundGradientBottom()
  {
    return this.te;
  }
  
  public int getBackgroundGradientTop()
  {
    return this.tf;
  }
  
  public int getBorderColor()
  {
    return this.tg;
  }
  
  public int getBorderThickness()
  {
    return this.th;
  }
  
  public int getBorderType()
  {
    return this.ti;
  }
  
  public int getCallButtonColor()
  {
    return this.tj;
  }
  
  public String getCustomChannels()
  {
    return this.tk;
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return this.ks.getCustomEventExtrasBundle(paramClass);
  }
  
  public int getDescriptionTextColor()
  {
    return this.tl;
  }
  
  public String getFontFace()
  {
    return this.tm;
  }
  
  public int getHeaderTextColor()
  {
    return this.tn;
  }
  
  public int getHeaderTextSize()
  {
    return this.to;
  }
  
  public Location getLocation()
  {
    return this.ks.getLocation();
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return this.ks.getNetworkExtras(paramClass);
  }
  
  public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return this.ks.getNetworkExtrasBundle(paramClass);
  }
  
  public String getQuery()
  {
    return this.tp;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.ks.isTestDevice(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/ads/search/SearchAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */