package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class gk
  implements SafeParcelable
{
  public static final Parcelable.Creator<gk> CREATOR = new gl();
  private double AM;
  private boolean AN;
  private int BO;
  private final int xJ;
  
  public gk()
  {
    this(1, NaN.0D, false, -1);
  }
  
  gk(int paramInt1, double paramDouble, boolean paramBoolean, int paramInt2)
  {
    this.xJ = paramInt1;
    this.AM = paramDouble;
    this.AN = paramBoolean;
    this.BO = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public double ec()
  {
    return this.AM;
  }
  
  public boolean ei()
  {
    return this.AN;
  }
  
  public int ej()
  {
    return this.BO;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof gk)) {
        return false;
      }
      paramObject = (gk)paramObject;
    } while ((this.AM == ((gk)paramObject).AM) && (this.AN == ((gk)paramObject).AN) && (this.BO == ((gk)paramObject).BO));
    return false;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Double.valueOf(this.AM), Boolean.valueOf(this.AN), Integer.valueOf(this.BO) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gl.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/gk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */