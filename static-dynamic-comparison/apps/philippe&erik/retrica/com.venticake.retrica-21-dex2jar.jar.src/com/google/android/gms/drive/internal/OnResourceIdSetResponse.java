package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class OnResourceIdSetResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnResourceIdSetResponse> CREATOR = new ao();
  private final List<String> It;
  private final int xM;
  
  OnResourceIdSetResponse(int paramInt, List<String> paramList)
  {
    this.xM = paramInt;
    this.It = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public List<String> go()
  {
    return this.It;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ao.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/OnResourceIdSetResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */