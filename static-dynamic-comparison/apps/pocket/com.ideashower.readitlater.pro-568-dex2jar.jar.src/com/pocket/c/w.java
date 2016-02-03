package com.pocket.c;

import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import java.io.InputStream;

public class w
  extends f
{
  private final boolean a;
  private final String b;
  private final String h;
  private final x p;
  
  public w(boolean paramBoolean1, String paramString1, String paramString2, x paramx, boolean paramBoolean2) {}
  
  protected void a(int paramInt)
  {
    if (paramInt == 3) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        e.a(paramInt, this.d, this.c, this.f, true);
      }
      this.p.a(this.a, bool);
      return;
    }
  }
  
  protected a k()
  {
    int i = 1;
    a locala = new a("https://getpocket.com/v3/oauth/approve_access", true);
    locala.a("request_token", this.b);
    if (this.a) {}
    for (;;)
    {
      locala.a("approve_flag", i);
      locala.a("permission", this.h);
      locala.c(this.b);
      return locala;
      i = 0;
    }
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        return 1;
      }
    };
  }
  
  protected boolean m()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */