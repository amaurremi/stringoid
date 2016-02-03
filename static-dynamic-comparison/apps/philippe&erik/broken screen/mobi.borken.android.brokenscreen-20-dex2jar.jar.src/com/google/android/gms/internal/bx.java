package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class bx
  implements MediationAdRequest
{
  private final Date d;
  private final Set<String> f;
  private final boolean g;
  private final int mj;
  private final int nP;
  
  public bx(Date paramDate, int paramInt1, Set<String> paramSet, boolean paramBoolean, int paramInt2)
  {
    this.d = paramDate;
    this.mj = paramInt1;
    this.f = paramSet;
    this.g = paramBoolean;
    this.nP = paramInt2;
  }
  
  public Date getBirthday()
  {
    return this.d;
  }
  
  public int getGender()
  {
    return this.mj;
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
    return this.nP;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */