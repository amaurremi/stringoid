package com.ideashower.readitlater.util.a;

import android.graphics.Bitmap;
import android.support.v4.c.e;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
  extends e
{
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, b paramb)
  {
    if (paramb.c())
    {
      paramString = paramb.b();
      int i = paramString.getRowBytes();
      return paramString.getHeight() * i;
    }
    return 0;
  }
  
  protected void a(boolean paramBoolean, String paramString, b paramb1, b paramb2)
  {
    paramb1.a(false);
  }
  
  public b b(String paramString, b paramb)
  {
    paramb.a(true);
    return (b)super.a(paramString, paramb);
  }
  
  public void b()
  {
    Iterator localIterator = a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      b localb = (b)localEntry.getValue();
      if ((localb == null) || (!localb.a())) {
        b(localEntry.getKey());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */