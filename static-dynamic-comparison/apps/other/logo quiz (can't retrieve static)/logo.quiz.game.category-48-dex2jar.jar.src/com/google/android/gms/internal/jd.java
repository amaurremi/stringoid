package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jd
  implements SafeParcelable
{
  public static final je CREATOR = new je();
  private final int BR;
  private final jf Mk;
  
  jd(int paramInt, jf paramjf)
  {
    this.BR = paramInt;
    this.Mk = paramjf;
  }
  
  private jd(jf paramjf)
  {
    this.BR = 1;
    this.Mk = paramjf;
  }
  
  public static jd a(ji.b<?, ?> paramb)
  {
    if ((paramb instanceof jf)) {
      return new jd((jf)paramb);
    }
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }
  
  public int describeContents()
  {
    je localje = CREATOR;
    return 0;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  jf ha()
  {
    return this.Mk;
  }
  
  public ji.b<?, ?> hb()
  {
    if (this.Mk != null) {
      return this.Mk;
    }
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    je localje = CREATOR;
    je.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/jd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */