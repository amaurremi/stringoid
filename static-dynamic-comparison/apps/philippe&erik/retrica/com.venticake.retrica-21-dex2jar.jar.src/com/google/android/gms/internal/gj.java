package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class gj
  implements SafeParcelable
{
  public static final Parcelable.Creator<gj> CREATOR = new gk();
  private double AP;
  private boolean AQ;
  private int BR;
  private final int xM;
  
  public gj()
  {
    this(1, NaN.0D, false, -1);
  }
  
  gj(int paramInt1, double paramDouble, boolean paramBoolean, int paramInt2)
  {
    this.xM = paramInt1;
    this.AP = paramDouble;
    this.AQ = paramBoolean;
    this.BR = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public double eh()
  {
    return this.AP;
  }
  
  public boolean en()
  {
    return this.AQ;
  }
  
  public int eo()
  {
    return this.BR;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof gj)) {
        return false;
      }
      paramObject = (gj)paramObject;
    } while ((this.AP == ((gj)paramObject).AP) && (this.AQ == ((gj)paramObject).AQ) && (this.BR == ((gj)paramObject).BR));
    return false;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Double.valueOf(this.AP), Boolean.valueOf(this.AQ), Integer.valueOf(this.BR) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gk.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */