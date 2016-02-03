package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

public final class jj
  implements SafeParcelable
{
  public static final Parcelable.Creator<jj> CREATOR = new fx();
  String SA;
  String SB;
  ArrayList<jh> SC;
  private final int qh;
  
  jj()
  {
    this.qh = 1;
    this.SC = dr.qW();
  }
  
  jj(int paramInt, String paramString1, String paramString2, ArrayList<jh> paramArrayList)
  {
    this.qh = paramInt;
    this.SA = paramString1;
    this.SB = paramString2;
    this.SC = paramArrayList;
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
    fx.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/jj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */