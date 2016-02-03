package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.i;

public class OnListEntriesResponse
  extends i
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnListEntriesResponse> CREATOR = new an();
  final int BR;
  final boolean Or;
  final DataHolder Pm;
  
  OnListEntriesResponse(int paramInt, DataHolder paramDataHolder, boolean paramBoolean)
  {
    this.BR = paramInt;
    this.Pm = paramDataHolder;
    this.Or = paramBoolean;
  }
  
  protected void I(Parcel paramParcel, int paramInt)
  {
    an.a(this, paramParcel, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DataHolder ii()
  {
    return this.Pm;
  }
  
  public boolean ij()
  {
    return this.Or;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/OnListEntriesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */