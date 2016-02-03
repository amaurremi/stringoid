package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Field
  implements SafeParcelable
{
  public static final Parcelable.Creator<Field> CREATOR = new j();
  public static final int FORMAT_FLOAT = 2;
  public static final int FORMAT_INT32 = 1;
  private final int BR;
  private final int ST;
  private final String mName;
  
  Field(int paramInt1, String paramString, int paramInt2)
  {
    this.BR = paramInt1;
    this.mName = paramString;
    this.ST = paramInt2;
  }
  
  public Field(String paramString, int paramInt)
  {
    this(1, paramString, paramInt);
  }
  
  private boolean a(Field paramField)
  {
    return (this.mName.equals(paramField.mName)) && (this.ST == paramField.ST);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Field)) && (a((Field)paramObject)));
  }
  
  public int getFormat()
  {
    return this.ST;
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
  
  public String toString()
  {
    String str2 = this.mName;
    if (this.ST == 1) {}
    for (String str1 = "i";; str1 = "f") {
      return String.format("%s(%s)", new Object[] { str2, str1 });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */