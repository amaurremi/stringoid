package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hk
  implements SafeParcelable
{
  public static final hl CREATOR = new hl();
  final int BR;
  final Bundle Ci;
  public final int id;
  
  hk(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.BR = paramInt1;
    this.id = paramInt2;
    this.Ci = paramBundle;
  }
  
  public int describeContents()
  {
    hl localhl = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hl localhl = CREATOR;
    hl.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/hk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */