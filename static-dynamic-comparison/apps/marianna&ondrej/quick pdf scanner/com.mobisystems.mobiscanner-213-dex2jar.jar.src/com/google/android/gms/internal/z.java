package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class z
  implements SafeParcelable
{
  public static final a TK = new a();
  public final long TL;
  public final int TM;
  public final List<String> TN;
  public final boolean TO;
  public final boolean TP;
  public final String TQ;
  public final am TR;
  public final Location TS;
  public final String TT;
  public final Bundle extras;
  public final int gU;
  public final int versionCode;
  
  z(int paramInt1, long paramLong, Bundle paramBundle, int paramInt2, List<String> paramList, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, am paramam, Location paramLocation, String paramString2)
  {
    this.versionCode = paramInt1;
    this.TL = paramLong;
    this.extras = paramBundle;
    this.TM = paramInt2;
    this.TN = paramList;
    this.TO = paramBoolean1;
    this.gU = paramInt3;
    this.TP = paramBoolean2;
    this.TQ = paramString1;
    this.TR = paramam;
    this.TS = paramLocation;
    this.TT = paramString2;
  }
  
  public z(Context paramContext, k paramk)
  {
    this.versionCode = 3;
    Object localObject1 = paramk.oP();
    long l;
    if (localObject1 != null)
    {
      l = ((Date)localObject1).getTime();
      this.TL = l;
      this.TT = paramk.oQ();
      this.TM = paramk.oR();
      localObject1 = paramk.oS();
      if (((Set)localObject1).isEmpty()) {
        break label185;
      }
      localObject1 = Collections.unmodifiableList(new ArrayList((Collection)localObject1));
      label80:
      this.TN = ((List)localObject1);
      this.TO = paramk.C(paramContext);
      this.gU = paramk.oY();
      this.TS = paramk.oT();
      paramContext = (com.google.android.gms.ads.b.a.a)paramk.c(com.google.android.gms.ads.b.a.a.class);
      if (paramContext == null) {
        break label191;
      }
    }
    label185:
    label191:
    for (paramContext = paramContext.getExtras();; paramContext = null)
    {
      this.extras = paramContext;
      this.TP = paramk.oU();
      this.TQ = paramk.oV();
      paramk = paramk.oW();
      paramContext = (Context)localObject2;
      if (paramk != null) {
        paramContext = new am(paramk);
      }
      this.TR = paramContext;
      return;
      l = -1L;
      break;
      localObject1 = null;
      break label80;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */