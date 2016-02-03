package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValuesRemovedDetails> CREATOR = new i();
  final int BR;
  final String RH;
  final int RI;
  final int Rj;
  final int Rk;
  final int mIndex;
  
  ValuesRemovedDetails(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    this.BR = paramInt1;
    this.mIndex = paramInt2;
    this.Rj = paramInt3;
    this.Rk = paramInt4;
    this.RH = paramString;
    this.RI = paramInt5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ValuesRemovedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */