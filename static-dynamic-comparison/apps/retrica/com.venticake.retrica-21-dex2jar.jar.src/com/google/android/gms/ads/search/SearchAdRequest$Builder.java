package com.google.android.gms.ads.search;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.at.a;

public final class SearchAdRequest$Builder
{
  private final at.a kt = new at.a();
  private int tc;
  private int td;
  private int te;
  private int tf;
  private int tg;
  private int th;
  private int ti = 0;
  private int tj;
  private String tk;
  private int tl;
  private String tm;
  private int tn;
  private int to;
  private String tp;
  
  public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
  {
    this.kt.b(paramClass, paramBundle);
    return this;
  }
  
  public Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
  {
    this.kt.a(paramNetworkExtras);
    return this;
  }
  
  public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
  {
    this.kt.a(paramClass, paramBundle);
    return this;
  }
  
  public Builder addTestDevice(String paramString)
  {
    this.kt.h(paramString);
    return this;
  }
  
  public SearchAdRequest build()
  {
    return new SearchAdRequest(this, null);
  }
  
  public Builder setAnchorTextColor(int paramInt)
  {
    this.tc = paramInt;
    return this;
  }
  
  public Builder setBackgroundColor(int paramInt)
  {
    this.td = paramInt;
    this.te = Color.argb(0, 0, 0, 0);
    this.tf = Color.argb(0, 0, 0, 0);
    return this;
  }
  
  public Builder setBackgroundGradient(int paramInt1, int paramInt2)
  {
    this.td = Color.argb(0, 0, 0, 0);
    this.te = paramInt2;
    this.tf = paramInt1;
    return this;
  }
  
  public Builder setBorderColor(int paramInt)
  {
    this.tg = paramInt;
    return this;
  }
  
  public Builder setBorderThickness(int paramInt)
  {
    this.th = paramInt;
    return this;
  }
  
  public Builder setBorderType(int paramInt)
  {
    this.ti = paramInt;
    return this;
  }
  
  public Builder setCallButtonColor(int paramInt)
  {
    this.tj = paramInt;
    return this;
  }
  
  public Builder setCustomChannels(String paramString)
  {
    this.tk = paramString;
    return this;
  }
  
  public Builder setDescriptionTextColor(int paramInt)
  {
    this.tl = paramInt;
    return this;
  }
  
  public Builder setFontFace(String paramString)
  {
    this.tm = paramString;
    return this;
  }
  
  public Builder setHeaderTextColor(int paramInt)
  {
    this.tn = paramInt;
    return this;
  }
  
  public Builder setHeaderTextSize(int paramInt)
  {
    this.to = paramInt;
    return this;
  }
  
  public Builder setLocation(Location paramLocation)
  {
    this.kt.a(paramLocation);
    return this;
  }
  
  public Builder setQuery(String paramString)
  {
    this.tp = paramString;
    return this;
  }
  
  public Builder tagForChildDirectedTreatment(boolean paramBoolean)
  {
    this.kt.h(paramBoolean);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/ads/search/SearchAdRequest$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */