package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ee;

public class d
  implements SafeParcelable
{
  public static final e CREATOR = new e();
  private final int kg;
  int xG;
  int xH;
  long xI;
  
  d(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.kg = paramInt1;
    this.xG = paramInt2;
    this.xH = paramInt3;
    this.xI = paramLong;
  }
  
  private String aQ(int paramInt)
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
    if (!(paramObject instanceof d)) {}
    do
    {
      return false;
      paramObject = (d)paramObject;
    } while ((this.xG != ((d)paramObject).xG) || (this.xH != ((d)paramObject).xH) || (this.xI != ((d)paramObject).xI));
    return true;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { Integer.valueOf(this.xG), Integer.valueOf(this.xH), Long.valueOf(this.xI) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationStatus[cell status: ").append(aQ(this.xG));
    localStringBuilder.append(", wifi status: ").append(aQ(this.xH));
    localStringBuilder.append(", elapsed realtime ns: ").append(this.xI);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/location/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */