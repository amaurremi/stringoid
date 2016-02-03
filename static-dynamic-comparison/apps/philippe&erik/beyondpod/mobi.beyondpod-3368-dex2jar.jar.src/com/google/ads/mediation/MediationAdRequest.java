package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest
{
  private final Date d;
  private final AdRequest.Gender e;
  private final Set<String> f;
  private final boolean g;
  
  public MediationAdRequest(Date paramDate, AdRequest.Gender paramGender, Set<String> paramSet, boolean paramBoolean)
  {
    this.d = paramDate;
    this.e = paramGender;
    this.f = paramSet;
    this.g = paramBoolean;
  }
  
  public Integer getAgeInYears()
  {
    return null;
  }
  
  public Date getBirthday()
  {
    return this.d;
  }
  
  public AdRequest.Gender getGender()
  {
    return this.e;
  }
  
  public Set<String> getKeywords()
  {
    return this.f;
  }
  
  public Location getLocation()
  {
    return null;
  }
  
  public boolean isTesting()
  {
    return this.g;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/ads/mediation/MediationAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */