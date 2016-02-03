package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class f
  implements SafeParcelable
{
  public static final Parcelable.Creator<f> CREATOR = new i();
  l ajs;
  g akS;
  String label;
  String type;
  private final int xM;
  
  f()
  {
    this.xM = 1;
  }
  
  f(int paramInt, String paramString1, g paramg, String paramString2, l paraml)
  {
    this.xM = paramInt;
    this.label = paramString1;
    this.akS = paramg;
    this.type = paramString2;
    this.ajs = paraml;
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
    i.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/wobs/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */