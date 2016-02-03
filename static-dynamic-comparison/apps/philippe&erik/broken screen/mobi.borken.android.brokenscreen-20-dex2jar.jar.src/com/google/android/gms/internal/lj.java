package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class lj
  implements SafeParcelable
{
  public static final Parcelable.Creator<lj> CREATOR = new lk();
  String[] akb;
  byte[][] akc;
  private final int xJ;
  
  lj()
  {
    this(1, new String[0], new byte[0][]);
  }
  
  lj(int paramInt, String[] paramArrayOfString, byte[][] paramArrayOfByte)
  {
    this.xJ = paramInt;
    this.akb = paramArrayOfString;
    this.akc = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lk.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/lj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */