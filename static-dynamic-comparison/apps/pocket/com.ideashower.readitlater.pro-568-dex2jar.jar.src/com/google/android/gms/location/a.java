package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator
{
  static void a(ActivityRecognitionResult paramActivityRecognitionResult, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.b(paramParcel, 1, paramActivityRecognitionResult.a, false);
    c.a(paramParcel, 1000, paramActivityRecognitionResult.a());
    c.a(paramParcel, 2, paramActivityRecognitionResult.b);
    c.a(paramParcel, 3, paramActivityRecognitionResult.c);
    c.a(paramParcel, paramInt);
  }
  
  public ActivityRecognitionResult a(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    long l2 = 0L;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.a(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, DetectedActivity.CREATOR);
        break;
      case 1000: 
        i = com.google.android.gms.common.internal.safeparcel.a.f(paramParcel, k);
        break;
      case 2: 
        l2 = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 3: 
        l1 = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new b("Overread allowed size end=" + j, paramParcel);
    }
    return new ActivityRecognitionResult(i, localArrayList, l2, l1);
  }
  
  public ActivityRecognitionResult[] a(int paramInt)
  {
    return new ActivityRecognitionResult[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/location/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */