package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.FileConflictEvent;

public class OnEventResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnEventResponse> CREATOR = new aj();
  final int In;
  final ChangeEvent Jv;
  final FileConflictEvent Jw;
  final int xJ;
  
  OnEventResponse(int paramInt1, int paramInt2, ChangeEvent paramChangeEvent, FileConflictEvent paramFileConflictEvent)
  {
    this.xJ = paramInt1;
    this.In = paramInt2;
    this.Jv = paramChangeEvent;
    this.Jw = paramFileConflictEvent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getEventType()
  {
    return this.In;
  }
  
  public ChangeEvent gr()
  {
    return this.Jv;
  }
  
  public FileConflictEvent gs()
  {
    return this.Jw;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/OnEventResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */