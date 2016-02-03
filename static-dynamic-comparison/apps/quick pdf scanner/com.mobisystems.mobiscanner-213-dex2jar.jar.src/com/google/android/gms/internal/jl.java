package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jl
  implements SafeParcelable
{
  public static final Parcelable.Creator<jl> CREATOR = new ga();
  jm SD;
  jr SE;
  String label;
  private final int qh;
  String type;
  
  jl()
  {
    this.qh = 1;
  }
  
  jl(int paramInt, String paramString1, jm paramjm, String paramString2, jr paramjr)
  {
    this.qh = paramInt;
    this.label = paramString1;
    this.SD = paramjm;
    this.type = paramString2;
    this.SE = paramjr;
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
    ga.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/jl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */