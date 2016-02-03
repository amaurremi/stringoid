package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

public class lf
  implements SafeParcelable
{
  public static final Parcelable.Creator<lf> CREATOR = new lg();
  private final int BR;
  private final List<DataType> Su;
  
  lf(int paramInt, List<DataType> paramList)
  {
    this.BR = paramInt;
    this.Su = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<DataType> getDataTypes()
  {
    return Collections.unmodifiableList(this.Su);
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public String toString()
  {
    return m.h(this).a("dataTypes", this.Su).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lg.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */