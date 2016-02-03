package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class g
  implements SafeParcelable
{
  public static final Parcelable.Creator<g> CREATOR = new h();
  private final int BR;
  int aus;
  String aut;
  double auu;
  String auv;
  long auw;
  int aux;
  
  g()
  {
    this.BR = 1;
    this.aux = -1;
    this.aus = -1;
    this.auu = -1.0D;
  }
  
  g(int paramInt1, int paramInt2, String paramString1, double paramDouble, String paramString2, long paramLong, int paramInt3)
  {
    this.BR = paramInt1;
    this.aus = paramInt2;
    this.aut = paramString1;
    this.auu = paramDouble;
    this.auv = paramString2;
    this.auw = paramLong;
    this.aux = paramInt3;
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
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wallet/wobs/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */