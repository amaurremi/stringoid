package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class c
  implements SafeParcelable
{
  public static final d CREATOR = new d();
  private final int BR;
  int aem;
  int aen;
  long aeo;
  
  c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.BR = paramInt1;
    this.aem = paramInt2;
    this.aen = paramInt3;
    this.aeo = paramLong;
  }
  
  private String ed(int paramInt)
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
    if (!(paramObject instanceof c)) {}
    do
    {
      return false;
      paramObject = (c)paramObject;
    } while ((this.aem != ((c)paramObject).aem) || (this.aen != ((c)paramObject).aen) || (this.aeo != ((c)paramObject).aeo));
    return true;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Integer.valueOf(this.aem), Integer.valueOf(this.aen), Long.valueOf(this.aeo) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationStatus[cell status: ").append(ed(this.aem));
    localStringBuilder.append(", wifi status: ").append(ed(this.aen));
    localStringBuilder.append(", elapsed realtime ns: ").append(this.aeo);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/location/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */