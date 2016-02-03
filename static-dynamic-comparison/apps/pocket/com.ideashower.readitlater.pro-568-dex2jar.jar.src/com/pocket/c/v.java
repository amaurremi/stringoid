package com.pocket.c;

import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;

public class v
  extends f
{
  private final String a;
  private final String b;
  
  public v(String paramString1, String paramString2)
  {
    super(1);
    this.a = paramString1;
    if ((paramString2.equals("https://getpocket.com/v3/deleteAlias")) || (paramString2.equals("https://getpocket.com/v3/resendEmailConfirmation")) || (paramString2.equals("https://getpocket.com/v3/addAlias")))
    {
      this.b = paramString2;
      return;
    }
    throw new IllegalArgumentException("invalid method" + paramString2);
  }
  
  protected void a(int paramInt)
  {
    if (paramInt == 3) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        e.a(paramInt, this.d, this.c, this.f, true);
      }
      return;
    }
  }
  
  protected a k()
  {
    a locala = new a(this.b, true);
    locala.a("email", this.a);
    return locala;
  }
  
  protected b l()
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */