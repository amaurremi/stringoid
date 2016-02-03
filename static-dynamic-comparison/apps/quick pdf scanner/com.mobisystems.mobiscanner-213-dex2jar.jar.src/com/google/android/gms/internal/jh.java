package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jh
  implements SafeParcelable
{
  public static final Parcelable.Creator<jh> CREATOR = new fw();
  String label;
  private final int qh;
  String value;
  
  jh()
  {
    this.qh = 1;
  }
  
  jh(int paramInt, String paramString1, String paramString2)
  {
    this.qh = paramInt;
    this.label = paramString1;
    this.value = paramString2;
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
    fw.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/jh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */