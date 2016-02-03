package com.e.a.b.b;

import com.e.a.b.q;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

final class l
  implements b
{
  private final DataInputStream a;
  private final DataInputStream b;
  private final boolean c;
  private int d;
  
  l(InputStream paramInputStream, boolean paramBoolean)
  {
    this.a = new DataInputStream(paramInputStream);
    this.b = a();
    this.c = paramBoolean;
  }
  
  private DataInputStream a()
  {
    new DataInputStream(new InflaterInputStream(new InputStream()new Inflater
    {
      public void close()
      {
        l.b(l.this).close();
      }
      
      public int read()
      {
        return q.a(this);
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        paramAnonymousInt2 = Math.min(paramAnonymousInt2, l.a(l.this));
        paramAnonymousInt1 = l.b(l.this).read(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        l.a(l.this, paramAnonymousInt1);
        return paramAnonymousInt1;
      }
    }, new Inflater()
    {
      public int inflate(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = super.inflate(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        int i = j;
        if (j == 0)
        {
          i = j;
          if (needsDictionary())
          {
            setDictionary(k.a);
            i = super.inflate(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          }
        }
        return i;
      }
    }));
  }
  
  private static IOException a(String paramString, Object... paramVarArgs)
  {
    throw new IOException(String.format(paramString, paramVarArgs));
  }
  
  private List a(int paramInt)
  {
    int i = 0;
    this.d += paramInt;
    int j;
    try
    {
      j = this.b.readInt();
      if (j * 2 < 0)
      {
        Logger.getLogger(getClass().getName()).warning("numberOfPairs < 0: " + j);
        throw a("numberOfPairs < 0", new Object[0]);
      }
    }
    catch (DataFormatException localDataFormatException)
    {
      throw new IOException(localDataFormatException.getMessage());
    }
    ArrayList localArrayList = new ArrayList(j * 2);
    paramInt = i;
    while (paramInt < j)
    {
      String str1 = b();
      String str2 = b();
      if (str1.length() == 0) {
        throw a("name.length == 0", new Object[0]);
      }
      localArrayList.add(str1);
      localArrayList.add(str2);
      paramInt += 1;
    }
    if (this.d != 0) {
      Logger.getLogger(getClass().getName()).warning("compressedLimit > 0: " + this.d);
    }
    return localArrayList;
  }
  
  private void a(c paramc, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    int i = this.a.readInt();
    int j = this.a.readInt();
    int k = this.a.readShort();
    List localList = a(paramInt2 - 10);
    boolean bool1;
    if ((paramInt1 & 0x1) != 0)
    {
      bool1 = true;
      if ((paramInt1 & 0x2) == 0) {
        break label98;
      }
    }
    for (;;)
    {
      paramc.a(bool2, bool1, i & 0x7FFFFFFF, j & 0x7FFFFFFF, (0xE000 & k) >>> 13, k & 0xFF, localList);
      return;
      bool1 = false;
      break;
      label98:
      bool2 = false;
    }
  }
  
  private String b()
  {
    int i = this.b.readInt();
    byte[] arrayOfByte = new byte[i];
    q.a(this.b, arrayOfByte);
    return new String(arrayOfByte, 0, i, "UTF-8");
  }
  
  private void b(c paramc, int paramInt1, int paramInt2)
  {
    int i = this.a.readInt();
    List localList = a(paramInt2 - 4);
    if ((paramInt1 & 0x1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramc.a(bool, 0x7FFFFFFF & i, localList);
      return;
    }
  }
  
  private void c(c paramc, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 8) {
      throw a("TYPE_RST_STREAM length: %d != 8", new Object[] { Integer.valueOf(paramInt2) });
    }
    paramInt1 = this.a.readInt();
    paramInt2 = this.a.readInt();
    a locala = a.a(paramInt2);
    if (locala == null) {
      throw a("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
    }
    paramc.a(paramInt1 & 0x7FFFFFFF, locala);
  }
  
  private void d(c paramc, int paramInt1, int paramInt2)
  {
    paramc.a(this.a.readInt() & 0x7FFFFFFF, a(paramInt2 - 4));
  }
  
  private void e(c paramc, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 8) {
      throw a("TYPE_WINDOW_UPDATE length: %d != 8", new Object[] { Integer.valueOf(paramInt2) });
    }
    paramc.a(this.a.readInt() & 0x7FFFFFFF, this.a.readInt() & 0x7FFFFFFF, false);
  }
  
  private void f(c paramc, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if (paramInt2 != 4) {
      throw a("TYPE_PING length: %d != 4", new Object[] { Integer.valueOf(paramInt2) });
    }
    paramInt1 = this.a.readInt();
    boolean bool3 = this.c;
    if (paramInt1 % 2 == 1)
    {
      bool1 = true;
      if (bool3 != bool1) {
        break label77;
      }
    }
    label77:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramc.a(bool1, paramInt1, 0);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void g(c paramc, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 8) {
      throw a("TYPE_GOAWAY length: %d != 8", new Object[] { Integer.valueOf(paramInt2) });
    }
    paramInt1 = this.a.readInt();
    paramInt2 = this.a.readInt();
    a locala = a.c(paramInt2);
    if (locala == null) {
      throw a("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
    }
    paramc.b(paramInt1 & 0x7FFFFFFF, locala);
  }
  
  private void h(c paramc, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int i = this.a.readInt();
    if (paramInt2 != i * 8 + 4) {
      throw a("TYPE_SETTINGS length: %d != 4 + 8 * %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i) });
    }
    j localj = new j();
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      int j = this.a.readInt();
      localj.a(j & 0xFFFFFF, (0xFF000000 & j) >>> 24, this.a.readInt());
      paramInt2 += 1;
    }
    if ((paramInt1 & 0x1) != 0) {}
    for (;;)
    {
      paramc.a(bool, localj);
      return;
      bool = false;
    }
  }
  
  public boolean a(c paramc)
  {
    boolean bool = false;
    int j;
    int k;
    int m;
    for (;;)
    {
      try
      {
        j = this.a.readInt();
        k = this.a.readInt();
        if ((0x80000000 & j) != 0)
        {
          i = 1;
          m = (0xFF000000 & k) >>> 24;
          k &= 0xFFFFFF;
          if (i == 0) {
            break label330;
          }
          i = (0x7FFF0000 & j) >>> 16;
          if (i == 3) {
            break;
          }
          throw new ProtocolException("version != 3: " + i);
        }
      }
      catch (IOException paramc)
      {
        return false;
      }
      int i = 0;
    }
    switch (j & 0xFFFF)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      throw new IOException("Unexpected frame");
    case 1: 
      a(paramc, m, k);
      return true;
    case 2: 
      b(paramc, m, k);
      return true;
    case 3: 
      c(paramc, m, k);
      return true;
    case 4: 
      h(paramc, m, k);
      return true;
    case 5: 
      if (k != 0) {
        throw a("TYPE_NOOP length: %d != 0", new Object[] { Integer.valueOf(k) });
      }
      paramc.a();
      return true;
    case 6: 
      f(paramc, m, k);
      return true;
    case 7: 
      g(paramc, m, k);
      return true;
    case 8: 
      d(paramc, m, k);
      return true;
    case 9: 
      e(paramc, m, k);
      return true;
    }
    q.a(this.a, k);
    throw new UnsupportedOperationException("TODO");
    label330:
    if ((m & 0x1) != 0) {
      bool = true;
    }
    paramc.a(bool, 0x7FFFFFFF & j, this.a, k);
    return true;
  }
  
  public void close()
  {
    q.a(this.a, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */