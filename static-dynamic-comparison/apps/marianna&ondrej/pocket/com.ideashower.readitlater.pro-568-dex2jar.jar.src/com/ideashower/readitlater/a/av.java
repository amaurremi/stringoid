package com.ideashower.readitlater.a;

import com.pocket.c.e;
import com.pocket.c.f;
import com.pocket.c.g;
import com.pocket.user.UserMeta;
import com.pocket.user.a;
import com.pocket.user.d;

public class av
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public av a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public void a(String paramString, final aw paramaw)
  {
    final Object localObject = new d(as.k().h());
    if (this.c != null) {
      ((d)localObject).b(this.c);
    }
    if (this.d != null) {
      ((d)localObject).c(this.d);
    }
    if (this.a != null) {
      ((d)localObject).d(this.a);
    }
    if (this.b != null) {
      ((d)localObject).a(this.b);
    }
    localObject = ((d)localObject).a();
    e.a(paramString, this.a, this.e, this.b, this.c, this.d, new g()
    {
      public void a(f paramAnonymousf, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousf.u())
        {
          as.a(localObject);
          paramaw.a();
          return;
        }
        paramAnonymousf = paramAnonymousf.t();
        paramaw.a(paramAnonymousf);
      }
    });
  }
  
  public av b(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public av c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public av d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public av e(String paramString)
  {
    this.b = paramString;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */