package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class f
  implements SafeParcelable
{
  public static final g CREATOR = new g();
  private final int kg;
  private final String xJ;
  private final PendingIntent xr;
  
  public f(int paramInt, PendingIntent paramPendingIntent, String paramString)
  {
    this.kg = paramInt;
    this.xr = paramPendingIntent;
    this.xJ = paramString;
  }
  
  public PendingIntent dB()
  {
    return this.xr;
  }
  
  public String dC()
  {
    return this.xJ;
  }
  
  public int describeContents()
  {
    g localg = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (f)paramObject;
        if (this.xr == null)
        {
          if (((f)paramObject).xr != null) {
            return false;
          }
        }
        else if (!this.xr.equals(((f)paramObject).xr)) {
          return false;
        }
        if (this.xJ != null) {
          break;
        }
      } while (((f)paramObject).xJ == null);
      return false;
    } while (this.xJ.equals(((f)paramObject).xJ));
    return false;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (this.xr == null)
    {
      i = 0;
      if (this.xJ != null) {
        break label39;
      }
    }
    for (;;)
    {
      return (i + 31) * 31 + j;
      i = this.xr.hashCode();
      break;
      label39:
      j = this.xJ.hashCode();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g localg = CREATOR;
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/location/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */