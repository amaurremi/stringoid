package com.e.a.b.b;

import com.e.a.b.q;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

final class f
  implements b
{
  private final DataInputStream a;
  
  f(InputStream paramInputStream)
  {
    this.a = new DataInputStream(paramInputStream);
  }
  
  private static IOException a(String paramString, Object... paramVarArgs)
  {
    throw new IOException(String.format(paramString, paramVarArgs));
  }
  
  private void a(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramc.a(bool, paramInt3, this.a, paramInt2);
      return;
    }
  }
  
  private void b(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != 4) {
      throw a("TYPE_PRIORITY length: %d != 4", new Object[] { Integer.valueOf(paramInt2) });
    }
    if (paramInt3 == 0) {
      throw a("TYPE_PRIORITY streamId == 0", new Object[0]);
    }
    paramc.a(paramInt3, this.a.readInt() & 0x7FFFFFFF);
  }
  
  private void c(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != 4) {
      throw a("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(paramInt2) });
    }
    if (paramInt3 == 0) {
      throw a("TYPE_RST_STREAM streamId == 0", new Object[0]);
    }
    paramInt1 = this.a.readInt();
    a locala = a.b(paramInt1);
    if (locala == null) {
      throw a("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    paramc.a(paramInt3, locala);
  }
  
  private void d(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 % 8 != 0) {
      throw a("TYPE_SETTINGS length %% 8 != 0: %s", new Object[] { Integer.valueOf(paramInt2) });
    }
    if (paramInt3 != 0) {
      throw a("TYPE_SETTINGS streamId != 0", new Object[0]);
    }
    j localj = new j();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      localj.a(this.a.readInt() & 0xFFFFFF, 0, this.a.readInt());
      paramInt1 += 8;
    }
    paramc.a(false, localj);
  }
  
  private void e(c paramc, int paramInt1, int paramInt2, int paramInt3) {}
  
  private void f(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if (paramInt2 != 8) {
      throw a("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(paramInt2) });
    }
    if (paramInt3 != 0) {
      throw a("TYPE_PING streamId != 0", new Object[0]);
    }
    paramInt2 = this.a.readInt();
    paramInt3 = this.a.readInt();
    if ((paramInt1 & 0x1) != 0) {}
    for (;;)
    {
      paramc.a(bool, paramInt2, paramInt3);
      return;
      bool = false;
    }
  }
  
  private void g(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < 8) {
      throw a("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(paramInt2) });
    }
    paramInt1 = this.a.readInt();
    paramInt3 = this.a.readInt();
    paramInt2 -= 8;
    a locala = a.b(paramInt3);
    if (locala == null) {
      throw a("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt3) });
    }
    if (q.a(this.a, paramInt2) != paramInt2) {
      throw new IOException("TYPE_GOAWAY opaque data was truncated");
    }
    paramc.b(paramInt1, locala);
  }
  
  private void h(c paramc, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = this.a.readInt();
    if ((paramInt1 & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramc.a(paramInt3, 0x7FFFFFFF & paramInt2, bool);
      return;
    }
  }
  
  public boolean a(c paramc)
  {
    int m;
    int j;
    int k;
    try
    {
      int i = this.a.readInt();
      m = this.a.readInt();
      j = 0xFFFF & i;
      k = (i & 0xFF000000) >> 24;
      m &= 0x7FFFFFFF;
      switch ((0xFF0000 & i) >> 16)
      {
      case 1: 
      case 8: 
      default: 
        throw new UnsupportedOperationException("TODO");
      }
    }
    catch (IOException paramc)
    {
      return false;
    }
    a(paramc, k, j, m);
    return true;
    b(paramc, k, j, m);
    return true;
    c(paramc, k, j, m);
    return true;
    d(paramc, k, j, m);
    return true;
    e(paramc, k, j, m);
    return true;
    f(paramc, k, j, m);
    return true;
    g(paramc, k, j, m);
    return true;
    h(paramc, k, j, m);
    return true;
  }
  
  public void close()
  {
    this.a.close();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */