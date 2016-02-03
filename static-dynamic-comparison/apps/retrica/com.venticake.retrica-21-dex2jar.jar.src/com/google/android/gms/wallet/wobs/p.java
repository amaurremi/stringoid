package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class p
  implements SafeParcelable
{
  public static final Parcelable.Creator<p> CREATOR = new q();
  String akZ;
  l ald;
  n ale;
  n alf;
  String qe;
  private final int xM;
  
  p()
  {
    this.xM = 1;
  }
  
  p(int paramInt, String paramString1, String paramString2, l paraml, n paramn1, n paramn2)
  {
    this.xM = paramInt;
    this.akZ = paramString1;
    this.qe = paramString2;
    this.ald = paraml;
    this.ale = paramn1;
    this.alf = paramn2;
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
    q.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/wobs/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */