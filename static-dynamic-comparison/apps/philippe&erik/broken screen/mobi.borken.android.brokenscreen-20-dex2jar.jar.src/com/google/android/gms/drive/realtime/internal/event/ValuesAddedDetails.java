package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValuesAddedDetails> CREATOR = new h();
  final int LC;
  final int LD;
  final String LK;
  final int LL;
  final int mIndex;
  final int xJ;
  
  ValuesAddedDetails(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    this.xJ = paramInt1;
    this.mIndex = paramInt2;
    this.LC = paramInt3;
    this.LD = paramInt4;
    this.LK = paramString;
    this.LL = paramInt5;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ValuesAddedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */