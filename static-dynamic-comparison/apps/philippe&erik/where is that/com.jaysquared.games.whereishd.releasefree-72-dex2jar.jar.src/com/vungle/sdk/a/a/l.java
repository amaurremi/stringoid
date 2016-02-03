package com.vungle.sdk.a.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.vungle.sdk.e;

final class l
  extends s
{
  public static final Parcelable.Creator<l> CREATOR = new m();
  private String c;
  
  l() {}
  
  l(String paramString)
  {
    this.c = paramString;
  }
  
  final g.b a()
  {
    return g.b.b;
  }
  
  final l a(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    super.b(paramParcel);
    return this;
  }
  
  final g.a b()
  {
    return g.a.a;
  }
  
  final String c()
  {
    return e.a();
  }
  
  final void d()
  {
    super.d();
    this.a.putString("Content-Type", "application/json");
  }
  
  final String g()
  {
    return this.c;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */