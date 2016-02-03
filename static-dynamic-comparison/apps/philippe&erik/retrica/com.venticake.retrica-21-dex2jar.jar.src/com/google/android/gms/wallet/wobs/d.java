package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ig;
import java.util.ArrayList;

public final class d
  implements SafeParcelable
{
  public static final Parcelable.Creator<d> CREATOR = new e();
  String akP;
  String akQ;
  ArrayList<b> akR;
  private final int xM;
  
  d()
  {
    this.xM = 1;
    this.akR = ig.ga();
  }
  
  d(int paramInt, String paramString1, String paramString2, ArrayList<b> paramArrayList)
  {
    this.xM = paramInt;
    this.akP = paramString1;
    this.akQ = paramString2;
    this.akR = paramArrayList;
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
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/wobs/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */