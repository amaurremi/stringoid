package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator<ActivityRecognitionResult>
{
  static void a(ActivityRecognitionResult paramActivityRecognitionResult, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.b(paramParcel, 1, paramActivityRecognitionResult.TV, false);
    b.c(paramParcel, 1000, paramActivityRecognitionResult.lX());
    b.a(paramParcel, 2, paramActivityRecognitionResult.TW);
    b.a(paramParcel, 3, paramActivityRecognitionResult.TX);
    b.D(paramParcel, paramInt);
  }
  
  public ActivityRecognitionResult bf(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = com.google.android.gms.common.internal.safeparcel.a.j(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    long l2 = 0L;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.br(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, DetectedActivity.TY);
        break;
      case 1000: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2: 
        l2 = com.google.android.gms.common.internal.safeparcel.a.h(paramParcel, k);
        break;
      case 3: 
        l1 = com.google.android.gms.common.internal.safeparcel.a.h(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ActivityRecognitionResult(i, localArrayList, l2, l1);
  }
  
  public ActivityRecognitionResult[] dG(int paramInt)
  {
    return new ActivityRecognitionResult[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/location/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */