package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public class a$a
  extends RuntimeException
{
  public a$a(String paramString, Parcel paramParcel)
  {
    super(paramString + " Parcel: pos=" + paramParcel.dataPosition() + " size=" + paramParcel.dataSize());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/internal/safeparcel/a$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */