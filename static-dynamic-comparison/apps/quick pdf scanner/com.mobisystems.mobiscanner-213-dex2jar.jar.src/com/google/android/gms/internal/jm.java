package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jm
  implements SafeParcelable
{
  public static final Parcelable.Creator<jm> CREATOR = new fz();
  int SF;
  String SG;
  double SH;
  String SI;
  long SJ;
  int SK;
  private final int qh;
  
  jm()
  {
    this.qh = 1;
    this.SK = -1;
    this.SF = -1;
    this.SH = -1.0D;
  }
  
  jm(int paramInt1, int paramInt2, String paramString1, double paramDouble, String paramString2, long paramLong, int paramInt3)
  {
    this.qh = paramInt1;
    this.SF = paramInt2;
    this.SG = paramString1;
    this.SH = paramDouble;
    this.SI = paramString2;
    this.SJ = paramLong;
    this.SK = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fz.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/jm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */