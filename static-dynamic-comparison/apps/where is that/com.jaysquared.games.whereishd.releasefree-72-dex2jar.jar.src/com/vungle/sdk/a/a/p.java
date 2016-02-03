package com.vungle.sdk.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vungle.sdk.e;

public final class p
  implements Parcelable
{
  public static final Parcelable.Creator<p> CREATOR = new q();
  private long a = System.currentTimeMillis();
  private int b = 1;
  private int c = 1;
  
  public final long a()
  {
    return this.a;
  }
  
  final p a(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    return this;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  final void d()
  {
    this.b += 1;
    this.c += 1;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  final int e()
  {
    int i = this.c - 1;
    this.c = i;
    if (i < 0)
    {
      String str = e.t;
      this.c = 0;
    }
    return this.c;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */