package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.c.a;
import com.google.android.gms.dynamic.d;

public final class bq
  implements SafeParcelable
{
  public static final ar CM = new ar();
  public final bn CN;
  public final gu CO;
  public final as CP;
  public final dd CQ;
  public final q CS;
  public final String CT;
  public final boolean CU;
  public final String CV;
  public final at CW;
  public final int CX;
  public final db CY;
  public final String Cu;
  public final int orientation;
  public final int versionCode;
  
  bq(int paramInt1, bn parambn, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, db paramdb)
  {
    this.versionCode = paramInt1;
    this.CN = parambn;
    this.CO = ((gu)d.a(c.a.h(paramIBinder1)));
    this.CP = ((as)d.a(c.a.h(paramIBinder2)));
    this.CQ = ((dd)d.a(c.a.h(paramIBinder3)));
    this.CS = ((q)d.a(c.a.h(paramIBinder4)));
    this.CT = paramString1;
    this.CU = paramBoolean;
    this.CV = paramString2;
    this.CW = ((at)d.a(c.a.h(paramIBinder5)));
    this.orientation = paramInt2;
    this.CX = paramInt3;
    this.Cu = paramString3;
    this.CY = paramdb;
  }
  
  public bq(bn parambn, gu paramgu, as paramas, at paramat, db paramdb)
  {
    this.versionCode = 1;
    this.CN = parambn;
    this.CO = paramgu;
    this.CP = paramas;
    this.CQ = null;
    this.CS = null;
    this.CT = null;
    this.CU = false;
    this.CV = null;
    this.CW = paramat;
    this.orientation = -1;
    this.CX = 4;
    this.Cu = null;
    this.CY = paramdb;
  }
  
  public bq(gu paramgu, as paramas, at paramat, dd paramdd, int paramInt, db paramdb)
  {
    this.versionCode = 1;
    this.CN = null;
    this.CO = paramgu;
    this.CP = paramas;
    this.CQ = paramdd;
    this.CS = null;
    this.CT = null;
    this.CU = false;
    this.CV = null;
    this.CW = paramat;
    this.orientation = paramInt;
    this.CX = 1;
    this.Cu = null;
    this.CY = paramdb;
  }
  
  public bq(gu paramgu, as paramas, at paramat, dd paramdd, boolean paramBoolean, int paramInt, db paramdb)
  {
    this.versionCode = 1;
    this.CN = null;
    this.CO = paramgu;
    this.CP = paramas;
    this.CQ = paramdd;
    this.CS = null;
    this.CT = null;
    this.CU = paramBoolean;
    this.CV = null;
    this.CW = paramat;
    this.orientation = paramInt;
    this.CX = 2;
    this.Cu = null;
    this.CY = paramdb;
  }
  
  public bq(gu paramgu, as paramas, q paramq, at paramat, dd paramdd, boolean paramBoolean, int paramInt, String paramString, db paramdb)
  {
    this.versionCode = 1;
    this.CN = null;
    this.CO = paramgu;
    this.CP = paramas;
    this.CQ = paramdd;
    this.CS = paramq;
    this.CT = null;
    this.CU = paramBoolean;
    this.CV = null;
    this.CW = paramat;
    this.orientation = paramInt;
    this.CX = 3;
    this.Cu = paramString;
    this.CY = paramdb;
  }
  
  public bq(gu paramgu, as paramas, q paramq, at paramat, dd paramdd, boolean paramBoolean, int paramInt, String paramString1, String paramString2, db paramdb)
  {
    this.versionCode = 1;
    this.CN = null;
    this.CO = paramgu;
    this.CP = paramas;
    this.CQ = paramdd;
    this.CS = paramq;
    this.CT = paramString2;
    this.CU = paramBoolean;
    this.CV = paramString1;
    this.CW = paramat;
    this.orientation = paramInt;
    this.CX = 3;
    this.Cu = null;
    this.CY = paramdb;
  }
  
  public static bq a(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      paramIntent.setClassLoader(bq.class.getClassLoader());
      paramIntent = (bq)paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public static void a(Intent paramIntent, bq parambq)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", parambq);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  IBinder pn()
  {
    return d.J(this.CO).asBinder();
  }
  
  IBinder po()
  {
    return d.J(this.CP).asBinder();
  }
  
  IBinder pp()
  {
    return d.J(this.CQ).asBinder();
  }
  
  IBinder pq()
  {
    return d.J(this.CS).asBinder();
  }
  
  IBinder pr()
  {
    return d.J(this.CW).asBinder();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ar.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */