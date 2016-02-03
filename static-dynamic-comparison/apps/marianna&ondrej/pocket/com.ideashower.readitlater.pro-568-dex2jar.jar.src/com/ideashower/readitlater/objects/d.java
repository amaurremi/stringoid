package com.ideashower.readitlater.objects;

import com.ideashower.readitlater.db.operation.j;
import com.pocket.m.a.c;
import com.pocket.m.a.l;
import java.io.File;

public abstract class d
{
  public static d a(com.pocket.m.a.d paramd)
  {
    new d()
    {
      public void a(j paramAnonymousj)
      {
        paramAnonymousj.a(d.this);
      }
    };
  }
  
  public static d a(final com.pocket.m.a.d paramd, String paramString)
  {
    new d()
    {
      public void a(j paramAnonymousj)
      {
        String str = a(d.this);
        paramAnonymousj.d(str);
        paramAnonymousj.a(str, paramd);
      }
    };
  }
  
  public static d a(String paramString, final long paramLong)
  {
    new d()
    {
      public void a(j paramAnonymousj)
      {
        paramAnonymousj.a(a(d.this), paramLong);
      }
    };
  }
  
  public static String a(String paramString)
  {
    return paramString.substring(l.c().a().length() + 1);
  }
  
  public static String b(String paramString)
  {
    return l.c().a() + File.separator + paramString;
  }
  
  public abstract void a(j paramj);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/objects/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */