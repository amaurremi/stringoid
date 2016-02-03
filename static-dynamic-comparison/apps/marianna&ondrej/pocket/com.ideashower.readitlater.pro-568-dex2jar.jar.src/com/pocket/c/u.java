package com.pocket.c;

import com.google.android.gms.b.a.b.f;
import com.google.android.gms.b.a.b.g;
import com.pocket.oauth.i;
import com.pocket.oauth.j;
import org.codehaus.jackson.JsonParser;

public class u
  extends a
{
  private final String h;
  private final com.google.android.gms.b.a.b.a p;
  private final String q;
  private final String r;
  private final boolean s;
  private final i t;
  private String u;
  private boolean v;
  private boolean w;
  private final j x;
  
  public u(b paramb, String paramString, com.google.android.gms.b.a.b.a parama, boolean paramBoolean, i parami)
  {
    super(paramb, 1);
    this.h = paramString;
    this.p = parama;
    this.q = this.p.u().i();
    this.r = this.p.u().g();
    this.s = paramBoolean;
    this.t = parami;
    a(parami);
    this.x = new j();
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "other";
    case 1: 
      return "female";
    }
    return "male";
  }
  
  protected void a()
  {
    this.u = this.x.a(this.h, this.t);
    super.a();
  }
  
  protected boolean a(String paramString, JsonParser paramJsonParser)
  {
    boolean bool = false;
    if ("is_existing_user".equals(paramString))
    {
      if (paramJsonParser.getValueAsInt() == 1) {
        bool = true;
      }
      this.v = bool;
      return true;
    }
    return false;
  }
  
  protected int b(com.ideashower.readitlater.objects.a parama)
  {
    this.x.a(parama);
    switch (parama.e())
    {
    }
    for (;;)
    {
      return super.b(parama);
      this.w = true;
    }
  }
  
  public String f_()
  {
    return this.h;
  }
  
  protected com.ideashower.readitlater.objects.a k()
  {
    int i = 0;
    com.ideashower.readitlater.objects.a locala = new com.ideashower.readitlater.objects.a("https://getpocket.com/v3/ssoauth", false);
    if (n() == b.b) {
      i = 1;
    }
    if (i != 0) {}
    for (Object localObject = "login";; localObject = "signup")
    {
      locala.a("type", (String)localObject);
      locala.a("source", "google");
      locala.a("email", this.h);
      locala.a("id_token", this.u);
      locala.a("sso_firstname", this.q);
      locala.a("sso_lastname", this.r);
      locala.a("sso_gender", b(this.p.o()));
      localObject = this.p.q();
      if ((localObject != null) && (((f)localObject).h())) {
        locala.a("sso_avatar", ((f)localObject).g());
      }
      return locala;
    }
  }
  
  public boolean w()
  {
    return this.v;
  }
  
  public boolean x()
  {
    return this.w;
  }
  
  public boolean y()
  {
    return this.s;
  }
  
  public String z()
  {
    return this.h;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */