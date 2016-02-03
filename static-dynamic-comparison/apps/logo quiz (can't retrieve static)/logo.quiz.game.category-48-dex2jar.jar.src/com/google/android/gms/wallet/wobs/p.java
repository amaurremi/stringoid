package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class p
  implements SafeParcelable
{
  public static final Parcelable.Creator<p> CREATOR = new q();
  private final int BR;
  l auC;
  n auD;
  n auE;
  String auy;
  String tG;
  
  p()
  {
    this.BR = 1;
  }
  
  p(int paramInt, String paramString1, String paramString2, l paraml, n paramn1, n paramn2)
  {
    this.BR = paramInt;
    this.auy = paramString1;
    this.tG = paramString2;
    this.auC = paraml;
    this.auD = paramn1;
    this.auE = paramn2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wallet/wobs/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */