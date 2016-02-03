package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class bw
  implements MediationAdRequest
{
  private final Date d;
  private final Set<String> f;
  private final boolean g;
  private final int ml;
  private final int nR;
  
  public bw(Date paramDate, int paramInt1, Set<String> paramSet, boolean paramBoolean, int paramInt2)
  {
    this.d = paramDate;
    this.ml = paramInt1;
    this.f = paramSet;
    this.g = paramBoolean;
    this.nR = paramInt2;
  }
  
  public Date getBirthday()
  {
    return this.d;
  }
  
  public int getGender()
  {
    return this.ml;
  }
  
  public Set<String> getKeywords()
  {
    return this.f;
  }
  
  public boolean isTesting()
  {
    return this.g;
  }
  
  public int taggedForChildDirectedTreatment()
  {
    return this.nR;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */