package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableObjectChangedEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableObjectChangedEvent> CREATOR = new c();
  final int LC;
  final int LD;
  final String Lj;
  final String Ln;
  final boolean Lp;
  final String Lq;
  final String rO;
  final int xJ;
  
  ParcelableObjectChangedEvent(int paramInt1, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, int paramInt2, int paramInt3)
  {
    this.rO = paramString1;
    this.Lj = paramString2;
    this.Lp = paramBoolean;
    this.Ln = paramString3;
    this.Lq = paramString4;
    this.xJ = paramInt1;
    this.LC = paramInt2;
    this.LD = paramInt3;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ParcelableObjectChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */