package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class n
  implements SafeParcelable
{
  public static final Parcelable.Creator<n> CREATOR = new o();
  String alc;
  String description;
  private final int xM;
  
  n()
  {
    this.xM = 1;
  }
  
  n(int paramInt, String paramString1, String paramString2)
  {
    this.xM = paramInt;
    this.alc = paramString1;
    this.description = paramString2;
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
    o.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/wobs/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */