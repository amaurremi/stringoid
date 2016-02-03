package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DrivePreferences
  implements SafeParcelable
{
  public static final Parcelable.Creator<DrivePreferences> CREATOR = new d();
  final int BR;
  final boolean Ne;
  
  DrivePreferences(int paramInt, boolean paramBoolean)
  {
    this.BR = paramInt;
    this.Ne = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/DrivePreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */