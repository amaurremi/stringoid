package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jb
  implements SafeParcelable
{
  public static final jc CREATOR = new jc();
  final int BR;
  public final String Mi;
  public final int Mj;
  
  public jb(int paramInt1, String paramString, int paramInt2)
  {
    this.BR = paramInt1;
    this.Mi = paramString;
    this.Mj = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jc.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/jb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */