package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextDeletedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<TextDeletedDetails> CREATOR = new e();
  final int BR;
  final int RD;
  final int mIndex;
  
  TextDeletedDetails(int paramInt1, int paramInt2, int paramInt3)
  {
    this.BR = paramInt1;
    this.mIndex = paramInt2;
    this.RD = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/TextDeletedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */