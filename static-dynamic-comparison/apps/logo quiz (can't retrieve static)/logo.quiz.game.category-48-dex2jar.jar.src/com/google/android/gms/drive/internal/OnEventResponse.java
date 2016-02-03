package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;

public class OnEventResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnEventResponse> CREATOR = new am();
  final int BR;
  final int NS;
  final ChangeEvent Pk;
  final CompletionEvent Pl;
  
  OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, CompletionEvent paramCompletionEvent)
  {
    this.BR = paramInt1;
    this.NS = paramInt2;
    this.Pk = paramChangeEvent;
    this.Pl = paramCompletionEvent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveEvent ih()
  {
    switch (this.NS)
    {
    default: 
      throw new IllegalStateException("Unexpected event type " + this.NS);
    case 1: 
      return this.Pk;
    }
    return this.Pl;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    am.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/OnEventResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */