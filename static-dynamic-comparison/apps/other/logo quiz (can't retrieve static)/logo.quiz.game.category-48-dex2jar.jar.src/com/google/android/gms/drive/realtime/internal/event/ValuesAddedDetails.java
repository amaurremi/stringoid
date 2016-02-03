package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValuesAddedDetails> CREATOR = new h();
  final int BR;
  final String RF;
  final int RG;
  final int Rj;
  final int Rk;
  final int mIndex;
  
  ValuesAddedDetails(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    this.BR = paramInt1;
    this.mIndex = paramInt2;
    this.Rj = paramInt3;
    this.Rk = paramInt4;
    this.RF = paramString;
    this.RG = paramInt5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ValuesAddedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */