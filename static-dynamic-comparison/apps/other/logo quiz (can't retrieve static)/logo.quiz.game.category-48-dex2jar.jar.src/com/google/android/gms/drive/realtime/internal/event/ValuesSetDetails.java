package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesSetDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValuesSetDetails> CREATOR = new j();
  final int BR;
  final int Rj;
  final int Rk;
  final int mIndex;
  
  ValuesSetDetails(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.BR = paramInt1;
    this.mIndex = paramInt2;
    this.Rj = paramInt3;
    this.Rk = paramInt4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ValuesSetDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */