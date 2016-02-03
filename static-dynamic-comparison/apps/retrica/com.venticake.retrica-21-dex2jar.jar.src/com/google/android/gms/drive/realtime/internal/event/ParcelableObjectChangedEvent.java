package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableObjectChangedEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableObjectChangedEvent> CREATOR = new c();
  final int LF;
  final int LG;
  final String Lm;
  final String Lq;
  final boolean Ls;
  final String Lt;
  final String rR;
  final int xM;
  
  ParcelableObjectChangedEvent(int paramInt1, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, int paramInt2, int paramInt3)
  {
    this.rR = paramString1;
    this.Lm = paramString2;
    this.Ls = paramBoolean;
    this.Lq = paramString3;
    this.Lt = paramString4;
    this.xM = paramInt1;
    this.LF = paramInt2;
    this.LG = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ParcelableObjectChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */