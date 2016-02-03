package com.google.android.gms.internal;

import com.google.ads.AdRequest.Gender;
import com.google.android.gms.ads.d;
import java.util.Date;
import java.util.HashSet;

public final class ao
{
  public static com.google.ads.a b(ab paramab)
  {
    return new com.google.ads.a(d.b(paramab.width, paramab.height, paramab.wZ));
  }
  
  public static com.google.ads.mediation.a b(z paramz)
  {
    if (paramz.TN != null) {}
    for (HashSet localHashSet = new HashSet(paramz.TN);; localHashSet = null) {
      return new com.google.ads.mediation.a(new Date(paramz.TL), cv(paramz.TM), localHashSet, paramz.TO);
    }
  }
  
  public static AdRequest.Gender cv(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return AdRequest.Gender.gD;
    case 2: 
      return AdRequest.Gender.gF;
    }
    return AdRequest.Gender.gE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */