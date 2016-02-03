package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class aj
  implements SafeParcelable
{
  public static final ak CREATOR = new ak();
  public final Bundle extras;
  public final long lQ;
  public final int lR;
  public final List<String> lS;
  public final boolean lT;
  public final int lU;
  public final boolean lV;
  public final String lW;
  public final ax lX;
  public final Location lY;
  public final String lZ;
  public final Bundle ma;
  public final int versionCode;
  
  public aj(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List<String> paramList, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, ax paramax, Location paramLocation, String paramString2, Bundle paramBundle2)
  {
    this.versionCode = paramInt1;
    this.lQ = paramLong;
    this.extras = paramBundle1;
    this.lR = paramInt2;
    this.lS = paramList;
    this.lT = paramBoolean1;
    this.lU = paramInt3;
    this.lV = paramBoolean2;
    this.lW = paramString1;
    this.lX = paramax;
    this.lY = paramLocation;
    this.lZ = paramString2;
    this.ma = paramBundle2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ak.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */