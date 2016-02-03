package com.vungle.publisher;

import java.util.ArrayList;
import java.util.List;

public abstract class bz<T extends ch>
  implements ce, ch.a
{
  public final String a;
  protected final int b;
  protected final List<ce.a> c = new ArrayList();
  
  protected bz(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public void a(ce.a... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        ce.a locala = paramVarArgs[i];
        this.c.add(locala);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */