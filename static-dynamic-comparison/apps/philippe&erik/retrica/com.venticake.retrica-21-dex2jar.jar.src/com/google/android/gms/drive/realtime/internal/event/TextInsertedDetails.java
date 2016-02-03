package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextInsertedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<TextInsertedDetails> CREATOR = new f();
  final int LL;
  final int mIndex;
  final int xM;
  
  TextInsertedDetails(int paramInt1, int paramInt2, int paramInt3)
  {
    this.xM = paramInt1;
    this.mIndex = paramInt2;
    this.LL = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/TextInsertedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */