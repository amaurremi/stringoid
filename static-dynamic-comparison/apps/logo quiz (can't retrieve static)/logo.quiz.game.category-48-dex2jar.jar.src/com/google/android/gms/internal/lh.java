package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class lh
  implements SafeParcelable
{
  public static final Parcelable.Creator<lh> CREATOR = new li();
  private final int BR;
  private final DataSource Sh;
  
  lh(int paramInt, DataSource paramDataSource)
  {
    this.BR = paramInt;
    this.Sh = paramDataSource;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DataSource getDataSource()
  {
    return this.Sh;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public String toString()
  {
    return String.format("ApplicationUnregistrationRequest{%s}", new Object[] { this.Sh });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    li.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */