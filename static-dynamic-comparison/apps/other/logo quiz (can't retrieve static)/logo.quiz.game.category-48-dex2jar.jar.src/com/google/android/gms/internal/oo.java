package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class oo
  implements SafeParcelable
{
  public static final Parcelable.Creator<oo> CREATOR = new op();
  private final int BR;
  String[] atD;
  byte[][] atE;
  
  oo()
  {
    this(1, new String[0], new byte[0][]);
  }
  
  oo(int paramInt, String[] paramArrayOfString, byte[][] paramArrayOfByte)
  {
    this.BR = paramInt;
    this.atD = paramArrayOfString;
    this.atE = paramArrayOfByte;
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
    op.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/oo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */