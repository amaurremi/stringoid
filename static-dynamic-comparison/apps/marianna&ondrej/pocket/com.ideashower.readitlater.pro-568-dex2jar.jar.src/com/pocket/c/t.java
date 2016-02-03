package com.pocket.c;

public class t
  extends a
{
  private final String h;
  private final String p;
  private final String q;
  private final String r;
  private final String s;
  
  private t(String paramString1, String paramString2, int paramInt, g paramg)
  {
    super(b.b, paramInt);
    this.h = paramString1;
    this.p = paramString2;
    this.q = null;
    this.r = null;
    this.s = null;
    a(paramg);
  }
  
  private t(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, g paramg)
  {
    super(b.a, paramInt);
    this.h = paramString1;
    this.p = paramString2;
    this.q = paramString1;
    this.r = paramString3;
    this.s = paramString4;
    a(paramg);
  }
  
  public static t a(String paramString1, String paramString2, int paramInt, g paramg)
  {
    return new t(paramString1, paramString2, paramInt, paramg);
  }
  
  public static t a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, g paramg)
  {
    return new t(paramString1, paramString2, paramString3, paramString4, paramInt, paramg);
  }
  
  public String f_()
  {
    return this.h;
  }
  
  protected com.ideashower.readitlater.objects.a k()
  {
    int i;
    Object localObject;
    if (n() == b.b)
    {
      i = 1;
      if (i == 0) {
        break label68;
      }
      localObject = "https://getpocket.com/v3/oauth/authorize";
      label19:
      localObject = new com.ideashower.readitlater.objects.a((String)localObject, false);
      if (i == 0) {
        break label74;
      }
      ((com.ideashower.readitlater.objects.a)localObject).a("username", this.h);
      ((com.ideashower.readitlater.objects.a)localObject).a("grant_type", "credentials");
    }
    for (;;)
    {
      ((com.ideashower.readitlater.objects.a)localObject).a("password", this.p);
      return (com.ideashower.readitlater.objects.a)localObject;
      i = 0;
      break;
      label68:
      localObject = "https://getpocket.com/v3/signup";
      break label19;
      label74:
      ((com.ideashower.readitlater.objects.a)localObject).a("source", "email");
      ((com.ideashower.readitlater.objects.a)localObject).a("email", this.q);
      ((com.ideashower.readitlater.objects.a)localObject).a("first_name", this.r);
      ((com.ideashower.readitlater.objects.a)localObject).a("last_name", this.s);
      ((com.ideashower.readitlater.objects.a)localObject).a("get_access_token");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */