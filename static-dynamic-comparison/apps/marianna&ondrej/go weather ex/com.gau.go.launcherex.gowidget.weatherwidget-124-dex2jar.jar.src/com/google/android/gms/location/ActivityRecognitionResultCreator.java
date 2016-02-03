package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator
  implements Parcelable.Creator<ActivityRecognitionResult>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void a(ActivityRecognitionResult paramActivityRecognitionResult, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.b(paramParcel, 1, paramActivityRecognitionResult.NP, false);
    b.c(paramParcel, 1000, paramActivityRecognitionResult.getVersionCode());
    b.a(paramParcel, 2, paramActivityRecognitionResult.NQ);
    b.a(paramParcel, 3, paramActivityRecognitionResult.NR);
    b.F(paramParcel, paramInt);
  }
  
  public ActivityRecognitionResult createFromParcel(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = a.o(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    long l2 = 0L;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.n(paramParcel);
      switch (a.R(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localArrayList = a.c(paramParcel, k, DetectedActivity.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        l2 = a.i(paramParcel, k);
        break;
      case 3: 
        l1 = a.i(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ActivityRecognitionResult(i, localArrayList, l2, l1);
  }
  
  public ActivityRecognitionResult[] newArray(int paramInt)
  {
    return new ActivityRecognitionResult[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/location/ActivityRecognitionResultCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */