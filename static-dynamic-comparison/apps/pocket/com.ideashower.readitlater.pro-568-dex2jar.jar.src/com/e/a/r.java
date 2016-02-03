package com.e.a;

import com.e.a.b.a.s;
import com.e.a.b.q;

public final class r
{
  final String a;
  final int b;
  final String c;
  final String d;
  
  public r(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      throw new NullPointerException("host == null");
    }
    if (paramString2 == null) {
      throw new NullPointerException("userAgent == null");
    }
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  s a()
  {
    s locals = new s();
    locals.a("CONNECT " + this.a + ":" + this.b + " HTTP/1.1");
    if (this.b == q.a("https")) {}
    for (String str = this.a;; str = this.a + ":" + this.b)
    {
      locals.b("Host", str);
      locals.b("User-Agent", this.c);
      if (this.d != null) {
        locals.b("Proxy-Authorization", this.d);
      }
      locals.b("Proxy-Connection", "Keep-Alive");
      return locals;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */