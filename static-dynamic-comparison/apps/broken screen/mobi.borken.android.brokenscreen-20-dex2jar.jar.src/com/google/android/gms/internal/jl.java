package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jl
  implements SafeParcelable
{
  public static final jm CREATOR = new jm();
  private final int UX;
  private final int VX;
  private final jn VY;
  private final int xJ;
  
  jl(int paramInt1, int paramInt2, int paramInt3, jn paramjn)
  {
    this.xJ = paramInt1;
    this.UX = paramInt2;
    this.VX = paramInt3;
    this.VY = paramjn;
  }
  
  public int describeContents()
  {
    jm localjm = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof jl)) {
        return false;
      }
      paramObject = (jl)paramObject;
    } while ((this.UX == ((jl)paramObject).UX) && (this.VX == ((jl)paramObject).VX) && (this.VY.equals(((jl)paramObject).VY)));
    return false;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Integer.valueOf(this.UX), Integer.valueOf(this.VX) });
  }
  
  public int iX()
  {
    return this.UX;
  }
  
  public int iZ()
  {
    return this.VX;
  }
  
  public jn ja()
  {
    return this.VY;
  }
  
  public String toString()
  {
    return hl.e(this).a("transitionTypes", Integer.valueOf(this.UX)).a("loiteringTimeMillis", Integer.valueOf(this.VX)).a("placeFilter", this.VY).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jm localjm = CREATOR;
    jm.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/jl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */