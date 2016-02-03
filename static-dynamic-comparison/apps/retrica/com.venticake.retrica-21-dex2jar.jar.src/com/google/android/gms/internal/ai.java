package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class ai
  implements SafeParcelable
{
  public static final aj CREATOR = new aj();
  public final Bundle extras;
  public final long lS;
  public final int lT;
  public final List<String> lU;
  public final boolean lV;
  public final int lW;
  public final boolean lX;
  public final String lY;
  public final aw lZ;
  public final Location ma;
  public final String mb;
  public final Bundle mc;
  public final int versionCode;
  
  public ai(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List<String> paramList, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, aw paramaw, Location paramLocation, String paramString2, Bundle paramBundle2)
  {
    this.versionCode = paramInt1;
    this.lS = paramLong;
    this.extras = paramBundle1;
    this.lT = paramInt2;
    this.lU = paramList;
    this.lV = paramBoolean1;
    this.lW = paramInt3;
    this.lX = paramBoolean2;
    this.lY = paramString1;
    this.lZ = paramaw;
    this.ma = paramLocation;
    this.mb = paramString2;
    this.mc = paramBundle2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */