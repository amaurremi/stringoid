package com.vungle.sdk.a.a;

import android.os.Parcel;
import com.vungle.sdk.e;

abstract class k
  extends j
{
  int a = 100;
  private int b;
  private long c;
  private long d = 2000L;
  private long e = 300000L;
  
  k() {}
  
  k(byte paramByte)
  {
    this('\000');
  }
  
  private k(char paramChar)
  {
    this.b = 1;
    this.c = 0L;
  }
  
  k a(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.e = paramParcel.readLong();
    return this;
  }
  
  public void a(g paramg, i parami, r paramr)
  {
    int j = 1;
    int k = parami.a();
    if (k / 100 == 2) {}
    for (int i = 1; i != 0; i = 0)
    {
      a(parami);
      return;
    }
    parami = paramg.i();
    i = parami.b();
    if ((this.a > 0) && (i >= this.a))
    {
      i = 1;
      label68:
      if (i != 0) {
        break label251;
      }
      l = parami.a();
      if ((this.c <= 0L) || (System.currentTimeMillis() - l < this.c)) {
        break label253;
      }
      i = 1;
      label105:
      if (i != 0) {
        break label257;
      }
      if ((!j.a(k)) && (k != 602) && (k != 408)) {
        break label259;
      }
      i = 1;
      label137:
      if (i == 0) {
        break label263;
      }
      i = parami.c();
      boolean bool = a(k);
      if (!bool) {
        i = parami.e();
      }
      if ((this.b <= 0) || (i < this.b)) {
        break label265;
      }
      label182:
      if (j != 0) {
        break label269;
      }
      if (!bool) {
        break label302;
      }
      if (i > 0) {
        break label271;
      }
    }
    label251:
    label253:
    label257:
    label259:
    label263:
    label265:
    label269:
    label271:
    for (long l = 0L;; l = Math.min(this.d * Math.pow(2.0D, i - 1), this.e))
    {
      parami = e.t;
      new StringBuilder("Retrying ").append(paramg).append(" request in ").append(l / 1000L).append(" seconds");
      paramr.a(paramg, l);
      return;
      i = 0;
      break label68;
      break;
      i = 0;
      break label105;
      break;
      i = 0;
      break label137;
      break;
      j = 0;
      break label182;
      break;
    }
    label302:
    parami = e.t;
    new StringBuilder("Retrying ").append(paramg).append(" request soon");
    paramr.a(paramg);
  }
  
  abstract void a(i parami);
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeLong(this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */