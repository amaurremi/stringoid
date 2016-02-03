package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class g
  implements SafeParcelable
{
  public static final Parcelable.Creator<g> CREATOR = new h();
  int akQ;
  String akR;
  double akS;
  String akT;
  long akU;
  int akV;
  private final int xJ;
  
  g()
  {
    this.xJ = 1;
    this.akV = -1;
    this.akQ = -1;
    this.akS = -1.0D;
  }
  
  g(int paramInt1, int paramInt2, String paramString1, double paramDouble, String paramString2, long paramLong, int paramInt3)
  {
    this.xJ = paramInt1;
    this.akQ = paramInt2;
    this.akR = paramString1;
    this.akS = paramDouble;
    this.akT = paramString2;
    this.akU = paramLong;
    this.akV = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/wobs/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */