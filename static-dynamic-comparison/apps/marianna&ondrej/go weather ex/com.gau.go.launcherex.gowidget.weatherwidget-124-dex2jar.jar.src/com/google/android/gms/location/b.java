package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;

public class b
  implements SafeParcelable
{
  public static final c CREATOR = new c();
  int Oh;
  int Oi;
  long Oj;
  private final int xH;
  
  b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.xH = paramInt1;
    this.Oh = paramInt2;
    this.Oi = paramInt3;
    this.Oj = paramLong;
  }
  
  private String by(int paramInt)
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
    } while ((this.Oh != ((b)paramObject).Oh) || (this.Oi != ((b)paramObject).Oi) || (this.Oj != ((b)paramObject).Oj));
    return true;
  }
  
  int getVersionCode()
  {
    return this.xH;
  }
  
  public int hashCode()
  {
    return fo.hashCode(new Object[] { Integer.valueOf(this.Oh), Integer.valueOf(this.Oi), Long.valueOf(this.Oj) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationStatus[cell status: ").append(by(this.Oh));
    localStringBuilder.append(", wifi status: ").append(by(this.Oi));
    localStringBuilder.append(", elapsed realtime ns: ").append(this.Oj);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/location/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */