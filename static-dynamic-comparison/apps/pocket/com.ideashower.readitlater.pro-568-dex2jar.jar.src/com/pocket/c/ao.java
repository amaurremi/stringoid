package com.pocket.c;

import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;

public class ao
  extends f
{
  private final String a;
  
  private ao(String paramString, final ap paramap)
  {
    super(1);
    this.a = paramString;
    a(new g()
    {
      public void a(f paramAnonymousf, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          paramap.a();
          return;
        }
        paramAnonymousf = paramAnonymousf.t();
        if (paramAnonymousf != null)
        {
          paramap.a(paramAnonymousf.b());
          return;
        }
        paramap.a(null);
      }
    });
  }
  
  public static void a(String paramString, ap paramap)
  {
    new ao(paramString, paramap).h();
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/validateEmail", false);
    locala.a(false);
    locala.a("email", this.a);
    return locala;
  }
  
  protected b l()
  {
    return null;
  }
  
  protected boolean m()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */