package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.b.a;
import com.google.android.gms.dynamic.c;

public final class bm
  implements SafeParcelable
{
  public static final bl CREATOR = new bl();
  public final cu ej;
  public final bj gG;
  public final q gH;
  public final bn gI;
  public final cw gJ;
  public final al gK;
  public final String gL;
  public final boolean gM;
  public final String gN;
  public final bq gO;
  public final int gP;
  public final String go;
  public final int orientation;
  public final int versionCode;
  
  bm(int paramInt1, bj parambj, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, cu paramcu)
  {
    this.versionCode = paramInt1;
    this.gG = parambj;
    this.gH = ((q)c.b(b.a.E(paramIBinder1)));
    this.gI = ((bn)c.b(b.a.E(paramIBinder2)));
    this.gJ = ((cw)c.b(b.a.E(paramIBinder3)));
    this.gK = ((al)c.b(b.a.E(paramIBinder4)));
    this.gL = paramString1;
    this.gM = paramBoolean;
    this.gN = paramString2;
    this.gO = ((bq)c.b(b.a.E(paramIBinder5)));
    this.orientation = paramInt2;
    this.gP = paramInt3;
    this.go = paramString3;
    this.ej = paramcu;
  }
  
  public bm(bj parambj, q paramq, bn parambn, bq parambq, cu paramcu)
  {
    this.versionCode = 1;
    this.gG = parambj;
    this.gH = paramq;
    this.gI = parambn;
    this.gJ = null;
    this.gK = null;
    this.gL = null;
    this.gM = false;
    this.gN = null;
    this.gO = parambq;
    this.orientation = -1;
    this.gP = 4;
    this.go = null;
    this.ej = paramcu;
  }
  
  public bm(q paramq, bn parambn, al paramal, bq parambq, cw paramcw, boolean paramBoolean, int paramInt, String paramString, cu paramcu)
  {
    this.versionCode = 1;
    this.gG = null;
    this.gH = paramq;
    this.gI = parambn;
    this.gJ = paramcw;
    this.gK = paramal;
    this.gL = null;
    this.gM = paramBoolean;
    this.gN = null;
    this.gO = parambq;
    this.orientation = paramInt;
    this.gP = 3;
    this.go = paramString;
    this.ej = paramcu;
  }
  
  public bm(q paramq, bn parambn, al paramal, bq parambq, cw paramcw, boolean paramBoolean, int paramInt, String paramString1, String paramString2, cu paramcu)
  {
    this.versionCode = 1;
    this.gG = null;
    this.gH = paramq;
    this.gI = parambn;
    this.gJ = paramcw;
    this.gK = paramal;
    this.gL = paramString2;
    this.gM = paramBoolean;
    this.gN = paramString1;
    this.gO = parambq;
    this.orientation = paramInt;
    this.gP = 3;
    this.go = null;
    this.ej = paramcu;
  }
  
  public bm(q paramq, bn parambn, bq parambq, cw paramcw, int paramInt, cu paramcu)
  {
    this.versionCode = 1;
    this.gG = null;
    this.gH = paramq;
    this.gI = parambn;
    this.gJ = paramcw;
    this.gK = null;
    this.gL = null;
    this.gM = false;
    this.gN = null;
    this.gO = parambq;
    this.orientation = paramInt;
    this.gP = 1;
    this.go = null;
    this.ej = paramcu;
  }
  
  public bm(q paramq, bn parambn, bq parambq, cw paramcw, boolean paramBoolean, int paramInt, cu paramcu)
  {
    this.versionCode = 1;
    this.gG = null;
    this.gH = paramq;
    this.gI = parambn;
    this.gJ = paramcw;
    this.gK = null;
    this.gL = null;
    this.gM = paramBoolean;
    this.gN = null;
    this.gO = parambq;
    this.orientation = paramInt;
    this.gP = 2;
    this.go = null;
    this.ej = paramcu;
  }
  
  public static bm a(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      paramIntent.setClassLoader(bm.class.getClassLoader());
      paramIntent = (bm)paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public static void a(Intent paramIntent, bm parambm)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", parambm);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  IBinder aa()
  {
    return c.h(this.gH).asBinder();
  }
  
  IBinder ab()
  {
    return c.h(this.gI).asBinder();
  }
  
  IBinder ac()
  {
    return c.h(this.gJ).asBinder();
  }
  
  IBinder ad()
  {
    return c.h(this.gK).asBinder();
  }
  
  IBinder ae()
  {
    return c.h(this.gO).asBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bl.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */