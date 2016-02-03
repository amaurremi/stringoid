package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.dynamic.e;

public final class cq
  implements SafeParcelable
{
  public static final cp CREATOR = new cp();
  public final dg kX;
  public final cz kZ;
  public final db oT;
  public final Context oU;
  public final int versionCode;
  
  cq(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4)
  {
    this.versionCode = paramInt;
    this.kX = ((dg)e.e(d.a.ag(paramIBinder1)));
    this.kZ = ((cz)e.e(d.a.ag(paramIBinder2)));
    this.oT = ((db)e.e(d.a.ag(paramIBinder3)));
    this.oU = ((Context)e.e(d.a.ag(paramIBinder4)));
  }
  
  public cq(db paramdb, dg paramdg, cz paramcz, Context paramContext)
  {
    this.versionCode = 1;
    this.oT = paramdb;
    this.kX = paramdg;
    this.kZ = paramcz;
    this.oU = paramContext;
  }
  
  public static void a(Intent paramIntent, cq paramcq)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", paramcq);
    paramIntent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", localBundle);
  }
  
  public static cq b(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      paramIntent.setClassLoader(cq.class.getClassLoader());
      paramIntent = (cq)paramIntent.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  IBinder bd()
  {
    return e.h(this.kX).asBinder();
  }
  
  IBinder be()
  {
    return e.h(this.kZ).asBinder();
  }
  
  IBinder bf()
  {
    return e.h(this.oT).asBinder();
  }
  
  IBinder bg()
  {
    return e.h(this.oU).asBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cp.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */