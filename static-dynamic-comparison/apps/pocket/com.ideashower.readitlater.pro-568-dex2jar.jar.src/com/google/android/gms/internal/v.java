package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class v
  implements SafeParcelable
{
  public static final cr CREATOR = new cr();
  public final int a;
  public final long b;
  public final Bundle c;
  public final int d;
  public final List e;
  public final boolean f;
  public final int g;
  
  v(int paramInt1, long paramLong, Bundle paramBundle, int paramInt2, List paramList, boolean paramBoolean, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramLong;
    this.c = paramBundle;
    this.d = paramInt2;
    this.e = paramList;
    this.f = paramBoolean;
    this.g = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cr.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */