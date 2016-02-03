package com.pocket.c;

import android.database.sqlite.SQLiteDiskIOException;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.db.operation.t;
import com.ideashower.readitlater.h.h;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.net.ssl.SSLException;

public class ah
  extends an
{
  private boolean a;
  private final boolean b;
  private ArrayList h = new ArrayList();
  private ArrayList p = new ArrayList();
  private boolean q;
  
  public ah(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    super(paramInt, 3);
    this.a = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  protected void I()
  {
    super.I();
    e.a(false, this.q);
  }
  
  protected int a(com.ideashower.readitlater.objects.a parama)
  {
    if (parama == null) {
      return 1;
    }
    return super.a(parama);
  }
  
  protected void a(int paramInt)
  {
    boolean bool;
    if ((paramInt == 3) || (paramInt == 1))
    {
      bool = true;
      if (bool) {
        break label47;
      }
      e.a(paramInt, this.d, this.c, this.f, false);
    }
    for (;;)
    {
      e.a(bool, this.q);
      return;
      bool = false;
      break;
      label47:
      if (this.a) {
        e.b(true, this.c, this.b);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  protected com.ideashower.readitlater.objects.a k()
  {
    Object localObject2 = new ae();
    ((ae)localObject2).d();
    Object localObject1 = ((ae)localObject2).z();
    this.h = ((ae)localObject2).e();
    this.p = ((ae)localObject2).g();
    this.q = ((ae)localObject2).A();
    if (this.h.size() == 0) {
      localObject1 = null;
    }
    do
    {
      return (com.ideashower.readitlater.objects.a)localObject1;
      localObject2 = new com.ideashower.readitlater.objects.a("https://getpocket.com/v3/send", true);
      ((com.ideashower.readitlater.objects.a)localObject2).a("actions", (String)localObject1);
      localObject1 = localObject2;
    } while (!com.ideashower.readitlater.service.b.b());
    ((com.ideashower.readitlater.objects.a)localObject2).a();
    return (com.ideashower.readitlater.objects.a)localObject2;
  }
  
  protected com.ideashower.readitlater.objects.b l()
  {
    new com.ideashower.readitlater.objects.b()
    {
      public int a(InputStream paramAnonymousInputStream, boolean paramAnonymousBoolean)
      {
        int j = 1;
        int i = 1;
        if (ah.this.a_()) {
          i = 3;
        }
        for (;;)
        {
          return i;
          paramAnonymousInputStream = new t(ah.this, ah.a(ah.this), ah.b(ah.this), paramAnonymousInputStream);
          try
          {
            int k = paramAnonymousInputStream.d();
            if (k == 4) {
              continue;
            }
            return 2;
          }
          catch (RuntimeException localRuntimeException)
          {
            Object localObject = paramAnonymousInputStream.e();
            l locall;
            if (localObject == null)
            {
              i = 0;
              if ((localObject == null) || (!paramAnonymousBoolean) || (i == 0)) {
                break label225;
              }
              locall = i.b().a(com.ideashower.readitlater.h.a.ca, org.apache.a.c.c.a.a((Throwable)localObject)).a(com.ideashower.readitlater.h.a.cb, paramAnonymousInputStream.g());
              localObject = com.ideashower.readitlater.h.a.cc;
              if (ah.b(ah.this) == null) {
                break label220;
              }
            }
            label220:
            for (paramAnonymousInputStream = ah.b(ah.this).toString();; paramAnonymousInputStream = null)
            {
              locall.a((h)localObject, paramAnonymousInputStream).a();
              return 2;
              if ((localObject instanceof SocketTimeoutException))
              {
                i = 0;
                break;
              }
              if ((localObject instanceof SSLException))
              {
                i = 0;
                break;
              }
              if ((localObject instanceof UnknownHostException))
              {
                i = 0;
                break;
              }
              if (!g.k())
              {
                i = 0;
                break;
              }
              i = j;
              if (!(localObject instanceof SQLiteDiskIOException)) {
                break;
              }
              i = 0;
              break;
            }
            label225:
            throw locall;
          }
        }
      }
    };
  }
  
  protected void s()
  {
    e.a(false, this.q);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/c/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */