package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableIndexReference> CREATOR = new q();
  final String Ln;
  final boolean Lo;
  final int mIndex;
  final int xJ;
  
  ParcelableIndexReference(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.xJ = paramInt1;
    this.Ln = paramString;
    this.mIndex = paramInt2;
    this.Lo = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/ParcelableIndexReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */