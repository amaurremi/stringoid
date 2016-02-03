package com.pocket.l.a;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;

public class f
  extends b
{
  private final ArrayList c = new ArrayList();
  
  private f(e parame, boolean paramBoolean)
  {
    super(parame);
    parame = e.a(parame).iterator();
    while (parame.hasNext())
    {
      a locala = (a)parame.next();
      this.c.add(locala.a(paramBoolean));
    }
  }
  
  public b a(Bitmap paramBitmap)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a(paramBitmap);
    }
    return this;
  }
  
  public b a(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a(paramString);
    }
    return this;
  }
  
  public void a()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a();
    }
  }
  
  public b b(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).b(paramString);
    }
    return this;
  }
  
  public b c(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).c(paramString);
    }
    return this;
  }
  
  public b d(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).d(paramString);
    }
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/l/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */