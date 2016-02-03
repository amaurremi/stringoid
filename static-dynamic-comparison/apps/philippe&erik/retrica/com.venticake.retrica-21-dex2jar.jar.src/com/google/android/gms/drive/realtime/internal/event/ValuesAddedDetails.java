package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValuesAddedDetails> CREATOR = new h();
  final int LF;
  final int LG;
  final String LN;
  final int LO;
  final int mIndex;
  final int xM;
  
  ValuesAddedDetails(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    this.xM = paramInt1;
    this.mIndex = paramInt2;
    this.LF = paramInt3;
    this.LG = paramInt4;
    this.LN = paramString;
    this.LO = paramInt5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ValuesAddedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */