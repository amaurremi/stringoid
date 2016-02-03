package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jk
  implements SafeParcelable
{
  public static final jl CREATOR = new jl();
  private final int Va;
  private final int Wa;
  private final jm Wb;
  private final int xM;
  
  jk(int paramInt1, int paramInt2, int paramInt3, jm paramjm)
  {
    this.xM = paramInt1;
    this.Va = paramInt2;
    this.Wa = paramInt3;
    this.Wb = paramjm;
  }
  
  public int describeContents()
  {
    jl localjl = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof jk)) {
        return false;
      }
      paramObject = (jk)paramObject;
    } while ((this.Va == ((jk)paramObject).Va) && (this.Wa == ((jk)paramObject).Wa) && (this.Wb.equals(((jk)paramObject).Wb)));
    return false;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Integer.valueOf(this.Va), Integer.valueOf(this.Wa) });
  }
  
  public int jc()
  {
    return this.Va;
  }
  
  public int je()
  {
    return this.Wa;
  }
  
  public jm jf()
  {
    return this.Wb;
  }
  
  public String toString()
  {
    return hk.e(this).a("transitionTypes", Integer.valueOf(this.Va)).a("loiteringTimeMillis", Integer.valueOf(this.Wa)).a("placeFilter", this.Wb).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jl localjl = CREATOR;
    jl.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */