package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.FileConflictEvent;

public class aj
  implements Parcelable.Creator<OnEventResponse>
{
  static void a(OnEventResponse paramOnEventResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnEventResponse.xJ);
    b.c(paramParcel, 2, paramOnEventResponse.In);
    b.a(paramParcel, 3, paramOnEventResponse.Jv, paramInt, false);
    b.a(paramParcel, 4, paramOnEventResponse.Jw, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OnEventResponse ak(Parcel paramParcel)
  {
    FileConflictEvent localFileConflictEvent = null;
    int j = 0;
    int m = a.B(paramParcel);
    ChangeEvent localChangeEvent = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        k = j;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = a.g(paramParcel, k);
        i = j;
        j = k;
        continue;
        k = a.g(paramParcel, k);
        j = i;
        i = k;
        continue;
        localChangeEvent = (ChangeEvent)a.a(paramParcel, k, ChangeEvent.CREATOR);
        k = i;
        i = j;
        j = k;
        continue;
        localFileConflictEvent = (FileConflictEvent)a.a(paramParcel, k, FileConflictEvent.CREATOR);
        k = i;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new OnEventResponse(i, j, localChangeEvent, localFileConflictEvent);
  }
  
  public OnEventResponse[] bg(int paramInt)
  {
    return new OnEventResponse[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */