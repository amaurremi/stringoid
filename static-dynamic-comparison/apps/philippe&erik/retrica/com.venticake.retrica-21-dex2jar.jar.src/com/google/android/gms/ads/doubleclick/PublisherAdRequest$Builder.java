package com.google.android.gms.ads.doubleclick;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.at.a;
import com.google.android.gms.internal.hm;
import java.util.Date;

public final class PublisherAdRequest$Builder
{
  private final at.a kt = new at.a();
  
  public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
  {
    this.kt.b(paramClass, paramBundle);
    return this;
  }
  
  public Builder addKeyword(String paramString)
  {
    this.kt.g(paramString);
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
  
  public PublisherAdRequest build()
  {
    return new PublisherAdRequest(this, null);
  }
  
  public Builder setBirthday(Date paramDate)
  {
    this.kt.a(paramDate);
    return this;
  }
  
  public Builder setContentUrl(String paramString)
  {
    hm.b(paramString, "Content URL must be non-null.");
    hm.b(paramString, "Content URL must be non-empty.");
    if (paramString.length() <= 512) {}
    for (boolean bool = true;; bool = false)
    {
      hm.b(bool, "Content URL must not exceed %d in length.  Provided length was %d.", new Object[] { Integer.valueOf(512), Integer.valueOf(paramString.length()) });
      this.kt.i(paramString);
      return this;
    }
  }
  
  public Builder setGender(int paramInt)
  {
    this.kt.e(paramInt);
    return this;
  }
  
  public Builder setLocation(Location paramLocation)
  {
    this.kt.a(paramLocation);
    return this;
  }
  
  public Builder setManualImpressionsEnabled(boolean paramBoolean)
  {
    this.kt.g(paramBoolean);
    return this;
  }
  
  public Builder setPublisherProvidedId(String paramString)
  {
    this.kt.j(paramString);
    return this;
  }
  
  public Builder tagForChildDirectedTreatment(boolean paramBoolean)
  {
    this.kt.h(paramBoolean);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/ads/doubleclick/PublisherAdRequest$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */