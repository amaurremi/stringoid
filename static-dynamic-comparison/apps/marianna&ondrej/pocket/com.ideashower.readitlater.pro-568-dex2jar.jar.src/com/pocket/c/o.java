package com.pocket.c;

import com.ideashower.readitlater.a.a.d;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.db.operation.p;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.i.c;
import com.ideashower.readitlater.objects.UserMessage;
import com.ideashower.readitlater.objects.b;
import java.io.InputStream;

public class o
  extends an
{
  private final boolean a;
  private int b;
  private String h = null;
  private boolean p = false;
  
  public o(int paramInt, boolean paramBoolean)
  {
    super(paramInt, 2);
    this.a = paramBoolean;
  }
  
  protected void I()
  {
    super.I();
    e.a(false, false, this.c, this.a);
  }
  
  protected void a(int paramInt)
  {
    if (this.b > 0) {
      new aa(this.b).h();
    }
    boolean bool;
    if (paramInt == 3)
    {
      bool = true;
      if (!bool) {
        break label125;
      }
      if (!i.a(com.ideashower.readitlater.h.a.aU)) {
        i.b().a(com.ideashower.readitlater.h.a.aU, true).a();
      }
      if (!i.a(com.ideashower.readitlater.h.a.aV)) {
        i.b().a(com.ideashower.readitlater.h.a.aV, true).a();
      }
      i.b(com.ideashower.readitlater.h.a.aW);
      c.a();
      com.pocket.m.a.b(this.a);
      if (this.h == null) {}
    }
    for (;;)
    {
      e.a(bool, this.p, this.c, this.a);
      return;
      bool = false;
      break;
      label125:
      if (!e.q()) {
        e.a(paramInt, this.d, this.c, this.f, false);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.h != null) {}
    do
    {
      return;
      paramString = com.ideashower.readitlater.a.a.a.c().b(paramString);
    } while (paramString == null);
    this.h = paramString.b();
  }
  
  public void a(boolean paramBoolean, long paramLong, UserMessage paramUserMessage)
  {
    if (paramBoolean) {
      i.b().a(com.ideashower.readitlater.h.a.ag, System.currentTimeMillis()).a();
    }
    if (paramLong > 0L)
    {
      i.a(com.ideashower.readitlater.h.a.ac, paramLong);
      if (i.a(com.ideashower.readitlater.h.a.ad) <= 0L) {
        i.a(com.ideashower.readitlater.h.a.ad, paramLong);
      }
    }
    for (;;)
    {
      if (paramUserMessage != null) {
        paramUserMessage.g();
      }
      return;
      com.ideashower.readitlater.util.e.a("since was 0", true);
    }
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  protected com.ideashower.readitlater.objects.a k()
  {
    int m = 1;
    g.p();
    com.ideashower.readitlater.objects.a locala = new com.ideashower.readitlater.objects.a("https://getpocket.com/v3/get", true);
    long l = i.a(com.ideashower.readitlater.h.a.ac);
    int i;
    label137:
    int j;
    label148:
    int k;
    if (l > com.ideashower.readitlater.h.a.ac.a)
    {
      locala.a("since", l);
      locala.a("tags");
      locala.a("taglist");
      locala.a("account");
      locala.a("positions");
      locala.a("authors");
      locala.a("images");
      locala.a("videos");
      locala.a("shares");
      locala.a("loginRuleCheck");
      locala.a("rediscovery");
      locala.a("meta", "1");
      if (i.a(com.ideashower.readitlater.h.a.aU)) {
        break label303;
      }
      i = 1;
      if (i.a(com.ideashower.readitlater.h.a.aR)) {
        break label308;
      }
      j = 1;
      if (i.a(com.ideashower.readitlater.h.a.aV)) {
        break label313;
      }
      k = 1;
      label159:
      if (i.a(com.ideashower.readitlater.h.a.aW)) {
        break label318;
      }
    }
    for (;;)
    {
      if (j != 0) {
        locala.a("forcetaglist");
      }
      if (i != 0) {
        locala.a("forceshareupgrade");
      }
      if ((j != 0) || (i != 0))
      {
        locala.a("forceaccount");
        locala.a("forcemails");
        locala.a("forcesettings");
      }
      if (k != 0) {
        locala.a("forcetweetupgrade");
      }
      if ((j != 0) || (m != 0)) {
        locala.a("forcerediscovery");
      }
      locala.a("premium");
      if (j != 0) {
        locala.a("forcepremium");
      }
      l = i.a(com.ideashower.readitlater.h.a.ad);
      if (l >= 0L) {
        locala.a("since_m", l);
      }
      return locala;
      locala.a("state", "unread");
      break;
      label303:
      i = 0;
      break label137;
      label308:
      j = 0;
      break label148;
      label313:
      k = 0;
      break label159;
      label318:
      m = 0;
    }
  }
  
  protected b l()
  {
    new b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        int j = 2;
        int i;
        if (o.this.a_()) {
          i = 3;
        }
        int k;
        do
        {
          do
          {
            return i;
            i = j;
          } while (!paramAnonymousBoolean);
          paramAnonymousInputStream = new p(o.this, paramAnonymousInputStream);
          k = paramAnonymousInputStream.d();
          o.a(o.this, paramAnonymousInputStream.e());
          i = j;
        } while (k != 4);
        return 1;
      }
    };
  }
  
  public boolean n()
  {
    return e.q();
  }
  
  protected void s()
  {
    e.a(false, false, this.c, this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */