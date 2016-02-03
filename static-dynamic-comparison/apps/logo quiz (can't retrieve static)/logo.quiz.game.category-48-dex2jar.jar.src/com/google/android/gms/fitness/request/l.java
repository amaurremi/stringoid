package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;

public class l
  implements SafeParcelable
{
  public static final Parcelable.Creator<l> CREATOR = new m();
  private final int BR;
  private final DataType SF;
  
  l(int paramInt, DataType paramDataType)
  {
    this.BR = paramInt;
    this.SF = paramDataType;
  }
  
  private l(a parama)
  {
    this.BR = 1;
    this.SF = a.a(parama);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DataType getDataType()
  {
    return this.SF;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    m.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private DataType SF;
    
    public a c(DataType paramDataType)
    {
      this.SF = paramDataType;
      return this;
    }
    
    public l jk()
    {
      return new l(this, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */