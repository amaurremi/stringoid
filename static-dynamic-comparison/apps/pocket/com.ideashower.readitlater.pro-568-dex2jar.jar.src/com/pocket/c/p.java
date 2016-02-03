package com.pocket.c;

import com.ideashower.readitlater.objects.ErrorReport;
import com.ideashower.readitlater.objects.a;
import com.ideashower.readitlater.objects.b;
import com.ideashower.readitlater.util.l;
import com.pocket.user.UserMeta;
import java.io.InputStream;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class p
  extends f
{
  protected UserMeta a;
  private final q b;
  private boolean h = false;
  
  public p(q paramq)
  {
    super(2);
    this.b = paramq;
  }
  
  protected void a(int paramInt)
  {
    q localq;
    UserMeta localUserMeta;
    ErrorReport localErrorReport;
    if (this.b != null)
    {
      localq = this.b;
      localUserMeta = this.a;
      localErrorReport = this.d;
      if (paramInt != 3) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localq.a(localUserMeta, localErrorReport, bool, this.h);
      return;
    }
  }
  
  protected int f(a parama)
  {
    this.h = true;
    return super.f(parama);
  }
  
  protected a k()
  {
    a locala = new a("https://getpocket.com/v3/getuser", true);
    locala.a("hash", "9dJDjsla49la");
    return locala;
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        paramAnonymousInputStream = l.d().createJsonParser(paramAnonymousInputStream);
        paramAnonymousInputStream.nextToken();
        while ((paramAnonymousInputStream.nextToken() != JsonToken.END_OBJECT) && (!paramAnonymousInputStream.isClosed()))
        {
          String str = paramAnonymousInputStream.getCurrentName();
          paramAnonymousInputStream.nextToken();
          if ("user".equals(str)) {
            p.this.a = UserMeta.a(paramAnonymousInputStream);
          } else {
            paramAnonymousInputStream.skipChildren();
          }
        }
        paramAnonymousInputStream.close();
        if (p.this.a != null) {
          return 1;
        }
        return 2;
      }
    };
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */