package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ReferenceShiftedDetails> CREATOR = new d();
  final String LH;
  final String LI;
  final int LJ;
  final int LK;
  final int xM;
  
  ReferenceShiftedDetails(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.xM = paramInt1;
    this.LH = paramString1;
    this.LI = paramString2;
    this.LJ = paramInt2;
    this.LK = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ReferenceShiftedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */