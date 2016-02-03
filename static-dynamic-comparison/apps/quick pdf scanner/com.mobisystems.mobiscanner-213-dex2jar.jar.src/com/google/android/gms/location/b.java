package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cz;

public class b
  implements SafeParcelable
{
  public static final g Um = new g();
  int Uj;
  int Uk;
  long Ul;
  private final int qh;
  
  b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.qh = paramInt1;
    this.Uj = paramInt2;
    this.Uk = paramInt3;
    this.Ul = paramLong;
  }
  
  private String dN(int paramInt)
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
    } while ((this.Uj != ((b)paramObject).Uj) || (this.Uk != ((b)paramObject).Uk) || (this.Ul != ((b)paramObject).Ul));
    return true;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { Integer.valueOf(this.Uj), Integer.valueOf(this.Uk), Long.valueOf(this.Ul) });
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationStatus[cell status: ").append(dN(this.Uj));
    localStringBuilder.append(", wifi status: ").append(dN(this.Uk));
    localStringBuilder.append(", elapsed realtime ns: ").append(this.Ul);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/location/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */