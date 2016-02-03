package com.vungle.sdk.a.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  extends g
{
  public static final Parcelable.Creator<a> CREATOR = new b();
  private String c;
  
  a() {}
  
  a(String paramString)
  {
    this.c = paramString;
    this.b = c.a();
  }
  
  final a a(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    super.b(paramParcel);
    return this;
  }
  
  final g.b a()
  {
    return g.b.a;
  }
  
  final g.a b()
  {
    return g.a.a;
  }
  
  final String c()
  {
    return this.c;
  }
  
  public final String toString()
  {
    return "{" + g.b.a + ": " + this.c + "}";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */