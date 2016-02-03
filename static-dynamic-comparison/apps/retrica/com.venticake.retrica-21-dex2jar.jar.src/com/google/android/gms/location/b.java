package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public class b
  implements SafeParcelable
{
  public static final c CREATOR = new c();
  int Vq;
  int Vr;
  long Vs;
  private final int xM;
  
  b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.xM = paramInt1;
    this.Vq = paramInt2;
    this.Vr = paramInt3;
    this.Vs = paramLong;
  }
  
  private String cI(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return "STATUS_UNKNOWN";
    case 0: 
      return "STATUS_SUCCESSFUL";
    case 2: 
      return "STATUS_TIMED_OUT_ON_SCAN";
    case 3: 
      return "STATUS_NO_INFO_IN_DATABASE";
    case 4: 
      return "STATUS_INVALID_SCAN";
    case 5: 
      return "STATUS_UNABLE_TO_QUERY_DATABASE";
    case 6: 
      return "STATUS_SCANS_DISABLED_IN_SETTINGS";
    case 7: 
      return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
    }
    return "STATUS_IN_PROGRESS";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {}
    do
    {
      return false;
      paramObject = (b)paramObject;
    } while ((this.Vq != ((b)paramObject).Vq) || (this.Vr != ((b)paramObject).Vr) || (this.Vs != ((b)paramObject).Vs));
    return true;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Integer.valueOf(this.Vq), Integer.valueOf(this.Vr), Long.valueOf(this.Vs) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationStatus[cell status: ").append(cI(this.Vq));
    localStringBuilder.append(", wifi status: ").append(cI(this.Vr));
    localStringBuilder.append(", elapsed realtime ns: ").append(this.Vs);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/location/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */