package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jr;
import java.util.Collections;
import java.util.List;

public final class DataType
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataType> CREATOR = new h();
  private final int BR;
  private final List<Field> SN;
  private final String mName;
  
  DataType(int paramInt, String paramString, List<Field> paramList)
  {
    this.BR = paramInt;
    this.mName = paramString;
    this.SN = Collections.unmodifiableList(paramList);
  }
  
  public DataType(String paramString, Field... paramVarArgs)
  {
    this(1, paramString, jr.b(paramVarArgs));
  }
  
  private boolean a(DataType paramDataType)
  {
    return (this.mName.equals(paramDataType.mName)) && (this.SN.equals(paramDataType.SN));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataType)) && (a((DataType)paramObject)));
  }
  
  public List<Field> getFields()
  {
    return this.SN;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return this.mName.hashCode();
  }
  
  public String iL()
  {
    if (this.mName.startsWith("com.google.")) {
      return this.mName.substring(11);
    }
    return this.mName;
  }
  
  public int indexOf(Field paramField)
  {
    if (this.SN.contains(paramField)) {
      return this.SN.indexOf(paramField);
    }
    throw new IllegalArgumentException(String.format("%s not a field of %s", new Object[] { paramField, this }));
  }
  
  public String toString()
  {
    return String.format("DataType{%s%s}", new Object[] { this.mName, this.SN });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/DataType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */