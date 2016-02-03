package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.at;
import java.util.Date;
import java.util.Set;

public final class PublisherAdRequest
{
  public static final String DEVICE_ID_EMULATOR = at.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  public static final int GENDER_FEMALE = 2;
  public static final int GENDER_MALE = 1;
  public static final int GENDER_UNKNOWN = 0;
  private final at ks;
  
  private PublisherAdRequest(PublisherAdRequest.Builder paramBuilder)
  {
    this.ks = new at(PublisherAdRequest.Builder.a(paramBuilder));
  }
  
  at T()
  {
    return this.ks;
  }
  
  public Date getBirthday()
  {
    return this.ks.getBirthday();
  }
  
  public String getContentUrl()
  {
    return this.ks.getContentUrl();
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return this.ks.getCustomEventExtrasBundle(paramClass);
  }
  
  public int getGender()
  {
    return this.ks.getGender();
  }
  
  public Set<String> getKeywords()
  {
    return this.ks.getKeywords();
  }
  
  public Location getLocation()
  {
    return this.ks.getLocation();
  }
  
  public boolean getManualImpressionsEnabled()
  {
    return this.ks.getManualImpressionsEnabled();
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
  
  public String getPublisherProvidedId()
  {
    return this.ks.getPublisherProvidedId();
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.ks.isTestDevice(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/ads/doubleclick/PublisherAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */