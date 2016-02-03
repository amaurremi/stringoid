package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.a;
import java.util.Date;
import java.util.HashSet;

public final class cb
{
  public static int a(AdRequest.ErrorCode paramErrorCode)
  {
    switch (1.b[paramErrorCode.ordinal()])
    {
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static AdSize b(al paramal)
  {
    int i = 0;
    AdSize[] arrayOfAdSize = new AdSize[6];
    arrayOfAdSize[0] = AdSize.SMART_BANNER;
    arrayOfAdSize[1] = AdSize.BANNER;
    arrayOfAdSize[2] = AdSize.IAB_MRECT;
    arrayOfAdSize[3] = AdSize.IAB_BANNER;
    arrayOfAdSize[4] = AdSize.IAB_LEADERBOARD;
    arrayOfAdSize[5] = AdSize.IAB_WIDE_SKYSCRAPER;
    while (i < arrayOfAdSize.length)
    {
      if ((arrayOfAdSize[i].getWidth() == paramal.width) && (arrayOfAdSize[i].getHeight() == paramal.height)) {
        return arrayOfAdSize[i];
      }
      i += 1;
    }
    return new AdSize(a.a(paramal.width, paramal.height, paramal.me));
  }
  
  public static MediationAdRequest e(ai paramai)
  {
    if (paramai.lU != null) {}
    for (HashSet localHashSet = new HashSet(paramai.lU);; localHashSet = null) {
      return new MediationAdRequest(new Date(paramai.lS), h(paramai.lT), localHashSet, paramai.lV, paramai.ma);
    }
  }
  
  public static AdRequest.Gender h(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return AdRequest.Gender.UNKNOWN;
    case 2: 
      return AdRequest.Gender.FEMALE;
    }
    return AdRequest.Gender.MALE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */