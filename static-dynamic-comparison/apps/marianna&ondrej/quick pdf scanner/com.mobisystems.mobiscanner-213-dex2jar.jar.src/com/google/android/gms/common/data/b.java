package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<DataHolder>
{
  static void a(DataHolder paramDataHolder, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.k(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 1, paramDataHolder.mJ(), false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1000, paramDataHolder.lX());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramDataHolder.mK(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 3, paramDataHolder.getStatusCode());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 4, paramDataHolder.mL(), false);
    com.google.android.gms.common.internal.safeparcel.b.D(paramParcel, i);
  }
  
  public DataHolder[] bp(int paramInt)
  {
    return new DataHolder[paramInt];
  }
  
  public DataHolder g(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int k = a.j(paramParcel);
    CursorWindow[] arrayOfCursorWindow = null;
    String[] arrayOfString = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.i(paramParcel);
      switch (a.br(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        arrayOfString = a.x(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        arrayOfCursorWindow = (CursorWindow[])a.b(paramParcel, m, CursorWindow.CREATOR);
        break;
      case 3: 
        i = a.g(paramParcel, m);
        break;
      case 4: 
        localBundle = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    paramParcel = new DataHolder(j, arrayOfString, arrayOfCursorWindow, i, localBundle);
    paramParcel.mI();
    return paramParcel;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/data/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */