package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.as;
import com.google.android.gms.internal.as.a;
import com.google.android.gms.internal.fq;
import java.util.Date;
import java.util.Set;

public final class AdRequest
{
  public static final String DEVICE_ID_EMULATOR = as.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  public static final int GENDER_FEMALE = 2;
  public static final int GENDER_MALE = 1;
  public static final int GENDER_UNKNOWN = 0;
  public static final int MAX_CONTENT_URL_LENGTH = 512;
  private final as kp;
  
  private AdRequest(Builder paramBuilder)
  {
    this.kp = new as(Builder.a(paramBuilder));
  }
  
  as O()
  {
    return this.kp;
  }
  
  public Date getBirthday()
  {
    return this.kp.getBirthday();
  }
  
  public String getContentUrl()
  {
    return this.kp.getContentUrl();
  }
  
  public int getGender()
  {
    return this.kp.getGender();
  }
  
  public Set<String> getKeywords()
  {
    return this.kp.getKeywords();
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
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.kp.isTestDevice(paramContext);
  }
  
  public static final class Builder
  {
    private final as.a kq = new as.a();
    
    public Builder addKeyword(String paramString)
    {
      this.kq.g(paramString);
      return this;
    }
    
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
    
    public AdRequest build()
    {
      return new AdRequest(this, null);
    }
    
    public Builder setBirthday(Date paramDate)
    {
      this.kq.a(paramDate);
      return this;
    }
    
    public Builder setContentUrl(String paramString)
    {
      fq.b(paramString, "Content URL must be non-null.");
      fq.b(paramString, "Content URL must be non-empty.");
      if (paramString.length() <= 512) {}
      for (boolean bool = true;; bool = false)
      {
        fq.a(bool, "Content URL must not exceed %d in length.  Provided length was %d.", new Object[] { Integer.valueOf(512), Integer.valueOf(paramString.length()) });
        this.kq.i(paramString);
        return this;
      }
    }
    
    public Builder setGender(int paramInt)
    {
      this.kq.d(paramInt);
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      this.kq.a(paramLocation);
      return this;
    }
    
    public Builder tagForChildDirectedTreatment(boolean paramBoolean)
    {
      this.kq.g(paramBoolean);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/ads/AdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */