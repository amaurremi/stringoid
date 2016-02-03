package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<BeginCompoundOperationRequest> CREATOR = new a();
  final int BR;
  final boolean Ra;
  final boolean Rb;
  final String mName;
  
  BeginCompoundOperationRequest(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    this.BR = paramInt;
    this.Ra = paramBoolean1;
    this.mName = paramString;
    this.Rb = paramBoolean2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/BeginCompoundOperationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */