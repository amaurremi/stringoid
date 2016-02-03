package com.vungle.sdk.a.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class g
  implements Parcelable
{
  final Bundle a = new Bundle();
  j b;
  private p c;
  
  g()
  {
    d();
  }
  
  abstract b a();
  
  final void a(j paramj)
  {
    this.b = paramj;
  }
  
  abstract a b();
  
  g b(Parcel paramParcel)
  {
    ClassLoader localClassLoader = g.class.getClassLoader();
    this.b = ((j)paramParcel.readParcelable(localClassLoader));
    this.c = ((p)paramParcel.readParcelable(localClassLoader));
    return this;
  }
  
  abstract String c();
  
  void d()
  {
    this.a.putString("User-Agent", "VungleDroid/1.3.4");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  final Bundle e()
  {
    return f();
  }
  
  Bundle f()
  {
    return (Bundle)this.a.clone();
  }
  
  String g()
  {
    return null;
  }
  
  final void h()
  {
    if (this.c == null)
    {
      this.c = new p();
      return;
    }
    this.c.d();
  }
  
  final p i()
  {
    return this.c;
  }
  
  final j j()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "{" + a() + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeParcelable(this.c, paramInt);
  }
  
  public static enum a
  {
    private a() {}
  }
  
  static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */