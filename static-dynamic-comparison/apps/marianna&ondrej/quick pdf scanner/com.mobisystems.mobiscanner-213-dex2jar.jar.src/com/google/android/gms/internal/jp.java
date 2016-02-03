package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jp
  implements SafeParcelable
{
  public static final Parcelable.Creator<jp> CREATOR = new gb();
  String DL;
  String SL;
  private final int qh;
  
  jp()
  {
    this.qh = 1;
  }
  
  jp(int paramInt, String paramString1, String paramString2)
  {
    this.qh = paramInt;
    this.SL = paramString1;
    this.DL = paramString2;
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
    gb.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/jp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */