package com.ideashower.readitlater.db.operation.action;

import com.ideashower.readitlater.db.operation.j;
import com.ideashower.readitlater.e.o;
import java.util.ArrayList;
import java.util.Iterator;

public class ad
  extends t
{
  public ad(String paramString, ArrayList paramArrayList, UiContext paramUiContext)
  {
    super("tags_replace", paramString, paramArrayList, paramUiContext);
  }
  
  protected int a()
  {
    if (this.d != null)
    {
      this.d.c(null);
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.d.d(str);
      }
      return 4;
    }
    return 3;
  }
  
  public void a(j paramj)
  {
    int i = c(paramj);
    if (o.m(i))
    {
      paramj.a(i);
      paramj.a(k(), i);
      return;
    }
    paramj.a(k());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/action/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */