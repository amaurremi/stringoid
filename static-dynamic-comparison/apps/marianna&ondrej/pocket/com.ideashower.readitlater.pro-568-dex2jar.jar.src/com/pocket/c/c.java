package com.pocket.c;

import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;

public class c
  extends f
{
  private final String a;
  private final String b;
  private final String h;
  private final String p;
  private final String q;
  private final String r;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, g paramg)
  {
    super(1);
    this.a = paramString1;
    this.b = paramString2;
    this.h = paramString3;
    this.q = paramString5;
    this.r = paramString6;
    this.p = paramString4;
    a(paramg);
  }
  
  private static void a(String paramString1, String paramString2, a parama)
  {
    if (paramString2 != null) {
      parama.a(paramString1, paramString2);
    }
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/acctchange", true);
    locala.a("password", this.a);
    a("newusername", this.b, locala);
    a("newpassword", this.h, locala);
    a("newfirst_name", this.q, locala);
    a("newlast_name", this.r, locala);
    a("newemail", this.p, locala);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */