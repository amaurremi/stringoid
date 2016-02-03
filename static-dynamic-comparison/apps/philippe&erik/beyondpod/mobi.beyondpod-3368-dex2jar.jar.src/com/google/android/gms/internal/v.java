package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class v
  implements SafeParcelable
{
  public static final w CREATOR = new w();
  public final boolean eA;
  public final boolean eB;
  public final String eC;
  public final ai eD;
  public final Location eE;
  public final long ex;
  public final Bundle extras;
  public final int ey;
  public final List<String> ez;
  public final int tagForChildDirectedTreatment;
  public final int versionCode;
  
  v(int paramInt1, long paramLong, Bundle paramBundle, int paramInt2, List<String> paramList, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString, ai paramai, Location paramLocation)
  {
    this.versionCode = paramInt1;
    this.ex = paramLong;
    this.extras = paramBundle;
    this.ey = paramInt2;
    this.ez = paramList;
    this.eA = paramBoolean1;
    this.tagForChildDirectedTreatment = paramInt3;
    this.eB = paramBoolean2;
    this.eC = paramString;
    this.eD = paramai;
    this.eE = paramLocation;
  }
  
  public v(Context paramContext, af paramaf)
  {
    this.versionCode = 2;
    Object localObject1 = paramaf.getBirthday();
    long l;
    if (localObject1 != null)
    {
      l = ((Date)localObject1).getTime();
      this.ex = l;
      this.ey = paramaf.getGender();
      localObject1 = paramaf.getKeywords();
      if (((Set)localObject1).isEmpty()) {
        break label177;
      }
      localObject1 = Collections.unmodifiableList(new ArrayList((Collection)localObject1));
      label72:
      this.ez = ((List)localObject1);
      this.eA = paramaf.isTestDevice(paramContext);
      this.tagForChildDirectedTreatment = paramaf.S();
      this.eE = paramaf.getLocation();
      paramContext = (AdMobExtras)paramaf.getNetworkExtras(AdMobExtras.class);
      if (paramContext == null) {
        break label183;
      }
    }
    label177:
    label183:
    for (paramContext = paramContext.getExtras();; paramContext = null)
    {
      this.extras = paramContext;
      this.eB = paramaf.getManualImpressionsEnabled();
      this.eC = paramaf.getPublisherProvidedId();
      paramaf = paramaf.Q();
      paramContext = (Context)localObject2;
      if (paramaf != null) {
        paramContext = new ai(paramaf);
      }
      this.eD = paramContext;
      return;
      l = -1L;
      break;
      localObject1 = null;
      break label72;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    w.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */