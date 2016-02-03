package com.e.a.b.b;

import com.e.a.b.j;
import com.e.a.b.q;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;

final class m
  implements d
{
  private final DataOutputStream a;
  private final ByteArrayOutputStream b;
  private final DataOutputStream c;
  private final boolean d;
  
  m(OutputStream paramOutputStream, boolean paramBoolean)
  {
    this.a = new DataOutputStream(paramOutputStream);
    this.d = paramBoolean;
    paramOutputStream = new Deflater();
    paramOutputStream.setDictionary(k.a);
    this.b = new ByteArrayOutputStream();
    this.c = new DataOutputStream(j.a().a(this.b, paramOutputStream, true));
  }
  
  private void a(List paramList)
  {
    this.b.reset();
    int i = paramList.size() / 2;
    this.c.writeInt(i);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      this.c.writeInt(str.length());
      this.c.write(str.getBytes("UTF-8"));
    }
    this.c.flush();
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      this.a.writeInt(-2147287031);
      this.a.writeInt(8);
      this.a.writeInt(paramInt1);
      this.a.writeInt(paramInt2);
      this.a.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(int paramInt, a parama)
  {
    try
    {
      if (parama.p == -1) {
        throw new IllegalArgumentException();
      }
    }
    finally {}
    this.a.writeInt(-2147287037);
    this.a.writeInt(8);
    this.a.writeInt(0x7FFFFFFF & paramInt);
    this.a.writeInt(parama.p);
    this.a.flush();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    for (;;)
    {
      boolean bool3;
      try
      {
        bool3 = this.d;
        if (paramInt1 % 2 != 1) {
          break label47;
        }
        bool1 = true;
      }
      finally {}
      if (paramBoolean != bool1)
      {
        throw new IllegalArgumentException("payload != reply");
        label47:
        bool1 = false;
      }
      while (bool3 == bool1)
      {
        bool1 = false;
        break;
        this.a.writeInt(-2147287034);
        this.a.writeInt(4);
        this.a.writeInt(paramInt1);
        this.a.flush();
        return;
      }
      boolean bool1 = bool2;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      try
      {
        this.a.writeInt(0x7FFFFFFF & paramInt1);
        this.a.writeInt((i & 0xFF) << 24 | 0xFFFFFF & paramInt3);
        this.a.write(paramArrayOfByte, paramInt2, paramInt3);
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List paramList)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        a(paramList);
        int k = this.b.size();
        int i;
        if (paramBoolean1)
        {
          i = 1;
          break label148;
          this.a.writeInt(-2147287039);
          this.a.writeInt(((j | i) & 0xFF) << 24 | k + 10 & 0xFFFFFF);
          this.a.writeInt(paramInt1 & 0x7FFFFFFF);
          this.a.writeInt(paramInt2 & 0x7FFFFFFF);
          this.a.writeShort((paramInt3 & 0x7) << 13 | 0x0 | paramInt4 & 0xFF);
          this.b.writeTo(this.a);
          this.a.flush();
        }
        else
        {
          i = 0;
        }
      }
      finally {}
      label148:
      if (paramBoolean2) {
        j = 2;
      }
    }
  }
  
  public void b()
  {
    try
    {
      this.a.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b(int paramInt, a parama)
  {
    try
    {
      if (parama.q == -1) {
        throw new IllegalArgumentException();
      }
    }
    finally {}
    this.a.writeInt(-2147287033);
    this.a.writeInt(8);
    this.a.writeInt(paramInt);
    this.a.writeInt(parama.q);
    this.a.flush();
  }
  
  public void close()
  {
    q.a(this.a, this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */