package com.e.a.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class d
{
  private final f b;
  private final boolean[] c;
  private boolean d;
  private boolean e;
  
  private d(c paramc, f paramf)
  {
    this.b = paramf;
    if (f.d(paramf)) {}
    for (paramc = null;; paramc = new boolean[c.e(paramc)])
    {
      this.c = paramc;
      return;
    }
  }
  
  public OutputStream a(int paramInt)
  {
    synchronized (this.a)
    {
      if (f.a(this.b) != this) {
        throw new IllegalStateException();
      }
    }
    if (!f.d(this.b)) {
      this.c[paramInt] = true;
    }
    File localFile = this.b.b(paramInt);
    try
    {
      Object localObject2 = new FileOutputStream(localFile);
      localObject2 = new e(this, (OutputStream)localObject2, null);
      return (OutputStream)localObject2;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        c.f(this.a).mkdirs();
        try
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          OutputStream localOutputStream = c.a();
          return localOutputStream;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.d)
    {
      c.a(this.a, this, false);
      this.a.c(f.c(this.b));
    }
    for (;;)
    {
      this.e = true;
      return;
      c.a(this.a, this, true);
    }
  }
  
  public void b()
  {
    c.a(this.a, this, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */