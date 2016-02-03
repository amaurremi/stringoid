package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class j
  implements SafeParcelable
{
  public static final Parcelable.Creator<j> CREATOR = new k();
  String akZ;
  String qe;
  private final int xM;
  
  j()
  {
    this.xM = 1;
  }
  
  j(int paramInt, String paramString1, String paramString2)
  {
    this.xM = paramInt;
    this.akZ = paramString1;
    this.qe = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/wobs/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */