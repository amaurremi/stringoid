package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class aj
{
  public static final aj lR = new aj();
  
  public static aj az()
  {
    return lR;
  }
  
  public ah a(Context paramContext, as paramas)
  {
    Object localObject = paramas.getBirthday();
    long l;
    String str1;
    int i;
    label59:
    boolean bool1;
    int j;
    Location localLocation;
    Bundle localBundle;
    boolean bool2;
    String str2;
    if (localObject != null)
    {
      l = ((Date)localObject).getTime();
      str1 = paramas.getContentUrl();
      i = paramas.getGender();
      localObject = paramas.getKeywords();
      if (((Set)localObject).isEmpty()) {
        break label153;
      }
      localObject = Collections.unmodifiableList(new ArrayList((Collection)localObject));
      bool1 = paramas.isTestDevice(paramContext);
      j = paramas.aE();
      localLocation = paramas.getLocation();
      localBundle = paramas.getNetworkExtrasBundle(AdMobAdapter.class);
      bool2 = paramas.getManualImpressionsEnabled();
      str2 = paramas.getPublisherProvidedId();
      paramContext = paramas.aB();
      if (paramContext == null) {
        break label159;
      }
    }
    label153:
    label159:
    for (paramContext = new av(paramContext);; paramContext = null)
    {
      return new ah(3, l, localBundle, i, (List)localObject, bool1, j, bool2, str2, paramContext, localLocation, str1);
      l = -1L;
      break;
      localObject = null;
      break label59;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */