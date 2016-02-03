package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class om
  implements SafeParcelable
{
  public static final Parcelable.Creator<om> CREATOR = new on();
  private final int BR;
  int[] atC;
  
  om()
  {
    this(1, null);
  }
  
  om(int paramInt, int[] paramArrayOfInt)
  {
    this.BR = paramInt;
    this.atC = paramArrayOfInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    on.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/om.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */