package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class me
  implements SafeParcelable
{
  public static final mf CREATOR = new mf();
  final int BR;
  private final boolean afc;
  private final List<mo> afd;
  
  me(int paramInt, boolean paramBoolean, List<mo> paramList)
  {
    this.BR = paramInt;
    this.afc = paramBoolean;
    this.afd = paramList;
  }
  
  public int describeContents()
  {
    mf localmf = CREATOR;
    return 0;
  }
  
  public boolean mc()
  {
    return this.afc;
  }
  
  public List<mo> md()
  {
    return this.afd;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mf localmf = CREATOR;
    mf.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/me.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */