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

public class ak
{
  public static final ak md = new ak();
  
  public static ak aF()
  {
    return md;
  }
  
  public ai a(Context paramContext, at paramat)
  {
    Object localObject = paramat.getBirthday();
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
      str1 = paramat.getContentUrl();
      i = paramat.getGender();
      localObject = paramat.getKeywords();
      if (((Set)localObject).isEmpty()) {
        break label157;
      }
      localObject = Collections.unmodifiableList(new ArrayList((Collection)localObject));
      bool1 = paramat.isTestDevice(paramContext);
      j = paramat.aK();
      localLocation = paramat.getLocation();
      localBundle = paramat.getNetworkExtrasBundle(AdMobAdapter.class);
      bool2 = paramat.getManualImpressionsEnabled();
      str2 = paramat.getPublisherProvidedId();
      paramContext = paramat.aH();
      if (paramContext == null) {
        break label163;
      }
    }
    label157:
    label163:
    for (paramContext = new aw(paramContext);; paramContext = null)
    {
      return new ai(4, l, localBundle, i, (List)localObject, bool1, j, bool2, str2, paramContext, localLocation, str1, paramat.aJ());
      l = -1L;
      break;
      localObject = null;
      break label59;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */