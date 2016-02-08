package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.i;

public class OnListParentsResponse
  extends i
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnListParentsResponse> CREATOR = new ao();
  final int BR;
  final DataHolder Pn;
  
  OnListParentsResponse(int paramInt, DataHolder paramDataHolder)
  {
    this.BR = paramInt;
    this.Pn = paramDataHolder;
  }
  
  protected void I(Parcel paramParcel, int paramInt)
  {
    ao.a(this, paramParcel, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DataHolder ik()
  {
    return this.Pn;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/OnListParentsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */