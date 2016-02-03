package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;

public final class hr
  implements SafeParcelable
{
  public static final ev Ni = new ev();
  private final LocationRequest Nj;
  private final hn Nk;
  final int qh;
  
  public hr(int paramInt, LocationRequest paramLocationRequest, hn paramhn)
  {
    this.qh = paramInt;
    this.Nj = paramLocationRequest;
    this.Nk = paramhn;
  }
  
  public int describeContents()
  {
    ev localev = Ni;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof hr)) {
        return false;
      }
      paramObject = (hr)paramObject;
    } while ((this.Nj.equals(((hr)paramObject).Nj)) && (this.Nk.equals(((hr)paramObject).Nk)));
    return false;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { this.Nj, this.Nk });
  }
  
  public LocationRequest rq()
  {
    return this.Nj;
  }
  
  public hn rr()
  {
    return this.Nk;
  }
  
  public String toString()
  {
    return cz.M(this).a("locationRequest", this.Nj).a("filter", this.Nk).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ev localev = Ni;
    ev.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/hr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */