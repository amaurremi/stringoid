package com.e.a;

import com.e.a.b.q;
import java.net.Proxy;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a
{
  final Proxy a;
  final String b;
  final int c;
  final SSLSocketFactory d;
  final HostnameVerifier e;
  final j f;
  final List g;
  
  public a(String paramString, int paramInt, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, j paramj, Proxy paramProxy, List paramList)
  {
    if (paramString == null) {
      throw new NullPointerException("uriHost == null");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("uriPort <= 0: " + paramInt);
    }
    if (paramj == null) {
      throw new IllegalArgumentException("authenticator == null");
    }
    if (paramList == null) {
      throw new IllegalArgumentException("transports == null");
    }
    this.a = paramProxy;
    this.b = paramString;
    this.c = paramInt;
    this.d = paramSSLSocketFactory;
    this.e = paramHostnameVerifier;
    this.f = paramj;
    this.g = q.a(paramList);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public SSLSocketFactory b()
  {
    return this.d;
  }
  
  public Proxy c()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (q.a(this.a, ((a)paramObject).a))
      {
        bool1 = bool2;
        if (this.b.equals(((a)paramObject).b))
        {
          bool1 = bool2;
          if (this.c == ((a)paramObject).c)
          {
            bool1 = bool2;
            if (q.a(this.d, ((a)paramObject).d))
            {
              bool1 = bool2;
              if (q.a(this.e, ((a)paramObject).e))
              {
                bool1 = bool2;
                if (q.a(this.f, ((a)paramObject).f))
                {
                  bool1 = bool2;
                  if (q.a(this.g, ((a)paramObject).g)) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = this.b.hashCode();
    int i1 = this.c;
    int i;
    int j;
    if (this.d != null)
    {
      i = this.d.hashCode();
      if (this.e == null) {
        break label131;
      }
      j = this.e.hashCode();
      label48:
      if (this.f == null) {
        break label136;
      }
    }
    label131:
    label136:
    for (int k = this.f.hashCode();; k = 0)
    {
      if (this.a != null) {
        m = this.a.hashCode();
      }
      return ((k + (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31) * 31 + m) * 31 + this.g.hashCode();
      i = 0;
      break;
      j = 0;
      break label48;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */