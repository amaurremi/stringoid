package com.pocket.c;

import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import java.io.InputStream;

public class ad
  extends f
{
  private final String a;
  private final String b;
  
  public ad(int paramInt, String paramString1, String paramString2)
  {
    super(paramInt);
    this.a = paramString1;
    this.b = paramString2;
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/email", true);
    locala.a("type", this.a);
    locala.a("template", this.b);
    return locala;
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */