package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jv
  implements SafeParcelable
{
  public static final Parcelable.Creator<jv> CREATOR = new ge();
  String DL;
  String SL;
  jr SP;
  jt SQ;
  jt SR;
  private final int qh;
  
  jv()
  {
    this.qh = 1;
  }
  
  jv(int paramInt, String paramString1, String paramString2, jr paramjr, jt paramjt1, jt paramjt2)
  {
    this.qh = paramInt;
    this.SL = paramString1;
    this.DL = paramString2;
    this.SP = paramjr;
    this.SQ = paramjt1;
    this.SR = paramjt2;
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
    ge.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/jv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */