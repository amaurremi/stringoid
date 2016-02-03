package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.a;
import java.util.Date;
import java.util.HashSet;

public final class cc
{
  public static int a(AdRequest.ErrorCode paramErrorCode)
  {
    switch (1.nX[paramErrorCode.ordinal()])
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
  
  public static AdSize b(am paramam)
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
      if ((arrayOfAdSize[i].getWidth() == paramam.width) && (arrayOfAdSize[i].getHeight() == paramam.height)) {
        return arrayOfAdSize[i];
      }
      i += 1;
    }
    return new AdSize(a.a(paramam.width, paramam.height, paramam.mc));
  }
  
  public static MediationAdRequest e(aj paramaj)
  {
    if (paramaj.lS != null) {}
    for (HashSet localHashSet = new HashSet(paramaj.lS);; localHashSet = null) {
      return new MediationAdRequest(new Date(paramaj.lQ), h(paramaj.lR), localHashSet, paramaj.lT, paramaj.lY);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */