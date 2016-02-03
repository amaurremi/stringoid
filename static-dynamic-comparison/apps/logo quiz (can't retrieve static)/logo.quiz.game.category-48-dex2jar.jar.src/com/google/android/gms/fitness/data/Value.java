package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Value
  implements SafeParcelable
{
  public static final Parcelable.Creator<Value> CREATOR = new u();
  private final int BR;
  private final int ST;
  private boolean Tk;
  private float Tl;
  
  Value(int paramInt)
  {
    this(1, paramInt, false, 0.0F);
  }
  
  Value(int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat)
  {
    this.BR = paramInt1;
    this.ST = paramInt2;
    this.Tk = paramBoolean;
    this.Tl = paramFloat;
  }
  
  private boolean a(Value paramValue)
  {
    if ((this.ST == paramValue.ST) && (this.Tk == paramValue.Tk))
    {
      switch (this.ST)
      {
      default: 
        if (this.Tl != paramValue.Tl) {
          break;
        }
      case 1: 
      case 2: 
        do
        {
          do
          {
            return true;
          } while (asInt() == paramValue.asInt());
          return false;
        } while (asFloat() == paramValue.asFloat());
        return false;
      }
      return false;
    }
    return false;
  }
  
  public float asFloat()
  {
    if (this.ST == 2) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "Value is not in float format");
      return this.Tl;
    }
  }
  
  public int asInt()
  {
    boolean bool = true;
    if (this.ST == 1) {}
    for (;;)
    {
      n.a(bool, "Value is not in int format");
      return Float.floatToRawIntBits(this.Tl);
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Value)) && (a((Value)paramObject)));
  }
  
  public int getFormat()
  {
    return this.ST;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Float.valueOf(this.Tl), Integer.valueOf(this.ST), Boolean.valueOf(this.Tk) });
  }
  
  float iS()
  {
    return this.Tl;
  }
  
  public boolean isSet()
  {
    return this.Tk;
  }
  
  public void setFloat(float paramFloat)
  {
    if (this.ST == 2) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
      this.Tk = true;
      this.Tl = paramFloat;
      return;
    }
  }
  
  public void setInt(int paramInt)
  {
    if (this.ST == 1) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
      this.Tk = true;
      this.Tl = Float.intBitsToFloat(paramInt);
      return;
    }
  }
  
  public String toString()
  {
    switch (this.ST)
    {
    default: 
      return "unknown";
    case 1: 
      return Integer.toString(asInt());
    }
    return Float.toString(asFloat());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    u.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/data/Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */