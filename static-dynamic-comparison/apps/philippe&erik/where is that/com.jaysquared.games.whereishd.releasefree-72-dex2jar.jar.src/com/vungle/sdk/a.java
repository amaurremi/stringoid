package com.vungle.sdk;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

final class a
{
  String a;
  String b;
  String c;
  String d;
  String e;
  String f = e.B;
  String g;
  String h = e.B;
  String i;
  String j;
  int k = 3;
  int l;
  long m = 0L;
  long n = 0L;
  int o = 0;
  int p = 0;
  int q = 0;
  private long r = -1L;
  private int s = -1;
  private long t = 0L;
  
  public final void a(int paramInt)
  {
    if (paramInt > 0) {}
    for (this.s = paramInt;; this.s = e.f)
    {
      ak.a(this.s);
      return;
    }
  }
  
  public final void a(long paramLong)
  {
    if ((paramLong == 0L) || (paramLong >= e.g)) {}
    for (this.r = paramLong;; this.r = e.g)
    {
      ak.b(this.r);
      return;
    }
  }
  
  public final void a(String paramString)
  {
    this.b = paramString;
    if (!ba.b(this.b)) {
      ak.g = this.b.substring(this.b.lastIndexOf(File.separator) + 1, this.b.length());
    }
    try
    {
      paramString = e.w;
      new StringBuilder("before encoding: ").append(ak.g);
      ak.g = URLDecoder.decode(ak.g, "UTF-8");
      paramString = e.w;
      new StringBuilder("After encoding: ").append(ak.g);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      av.a(e.u, "UnsupportedEncodingException", paramString);
    }
  }
  
  public final void b(String paramString)
  {
    this.i = paramString;
    if (!ba.b(this.i)) {
      ak.d = this.i.substring(this.i.lastIndexOf(File.separator) + 1, this.i.lastIndexOf("."));
    }
  }
  
  public final void c(String paramString)
  {
    this.h = paramString;
    if (!ba.b(this.h))
    {
      ak.e = this.h.substring(this.h.lastIndexOf(File.separator) + 1, this.h.lastIndexOf("."));
      return;
    }
    this.h = e.B;
    ak.e = e.B;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */