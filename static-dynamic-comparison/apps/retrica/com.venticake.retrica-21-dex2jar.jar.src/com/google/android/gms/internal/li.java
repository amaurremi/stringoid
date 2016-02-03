package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class li
  implements SafeParcelable
{
  public static final Parcelable.Creator<li> CREATOR = new lj();
  String[] ake;
  byte[][] akf;
  private final int xM;
  
  li()
  {
    this(1, new String[0], new byte[0][]);
  }
  
  li(int paramInt, String[] paramArrayOfString, byte[][] paramArrayOfByte)
  {
    this.xM = paramInt;
    this.ake = paramArrayOfString;
    this.akf = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/li.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */