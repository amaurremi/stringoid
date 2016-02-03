package com.pocket.c;

import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.at;
import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.pocket.oauth.i;
import com.pocket.oauth.j;

public class d
  extends f
{
  private final String a;
  private final String b;
  private final String h;
  private final String p;
  private final i q;
  private final j r;
  private final boolean s;
  private String t;
  
  private d(g paramg)
  {
    super(1);
    this.a = null;
    this.h = null;
    this.p = null;
    this.b = null;
    this.q = null;
    a(paramg);
    this.s = true;
    this.r = new j();
  }
  
  private d(String paramString1, String paramString2, String paramString3, String paramString4, i parami)
  {
    super(1);
    this.a = paramString1;
    this.h = paramString3;
    this.p = paramString4;
    this.b = paramString2;
    this.q = parami;
    a(parami);
    this.s = false;
    this.r = new j();
  }
  
  public static d a(at paramat)
  {
    new d(new g()
    {
      public void a(f paramAnonymousf, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          d.this.a();
          return;
        }
        if (((d)paramAnonymousf).n())
        {
          d.this.a();
          return;
        }
        paramAnonymousf = paramAnonymousf.t();
        d.this.a(paramAnonymousf);
      }
    });
  }
  
  public static d a(String paramString, i parami)
  {
    return new d(paramString, null, null, null, parami);
  }
  
  protected void a()
  {
    this.t = this.r.a(as.v(), this.q);
    super.a();
  }
  
  protected int b(a parama)
  {
    this.r.a(parama);
    return super.b(parama);
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/acctchange", true);
    locala.a("id_token", this.t);
    if (this.s)
    {
      locala.a("disconnect_google");
      locala.a("source", "google");
    }
    do
    {
      return locala;
      if (this.a != null) {
        locala.a("newpassword", this.a);
      }
      if (this.h != null) {
        locala.a("newfirst_name", this.h);
      }
      if (this.p != null) {
        locala.a("newlast_name", this.p);
      }
    } while (this.b == null);
    locala.a("newemail", this.b);
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
  
  public boolean n()
  {
    return this.r.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */