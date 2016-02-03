package com.pocket.stats;

import android.content.Context;
import android.widget.Toast;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.db.operation.action.ai;
import com.ideashower.readitlater.h.b;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.service.WakefulAppService;
import java.util.concurrent.atomic.AtomicInteger;

public class f
{
  private static final AtomicInteger a = new AtomicInteger(0);
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    com.ideashower.readitlater.objects.a locala = new com.ideashower.readitlater.objects.a("https://getpocket.com/v3/stat", false);
    locala.a();
    locala.a("c", paramInt1);
    locala.a("m", paramInt2);
    locala.a("v", paramInt3);
    locala.a("s", paramInt4);
    a(locala);
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    com.ideashower.readitlater.objects.a locala = new com.ideashower.readitlater.objects.a("https://getpocket.com/v3/trackValue", true);
    locala.a("v", paramInt);
    locala.a("value", paramString);
    a(locala);
  }
  
  private static void a(com.ideashower.readitlater.objects.a parama)
  {
    a(parama, null);
  }
  
  private static void a(com.ideashower.readitlater.objects.a parama, final com.ideashower.readitlater.d.f paramf)
  {
    if (!com.ideashower.readitlater.a.g.k())
    {
      if (paramf != null) {
        paramf.a(false);
      }
      return;
    }
    a.incrementAndGet();
    WakefulAppService.a("api send");
    com.ideashower.readitlater.a.g.a(new Runnable()
    {
      public void run()
      {
        new g(f.this, paramf).h();
      }
    });
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return;
      com.ideashower.readitlater.objects.a locala = new com.ideashower.readitlater.objects.a("https://getpocket.com/v3/reportArticleView", true);
      locala.a("url", paramString);
      a(locala);
    } while (paramContext == null);
    Toast.makeText(paramContext, 2131493735, 0).show();
  }
  
  public static void a(String paramString1, String paramString2, UiContext paramUiContext)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {
      return;
    }
    new ai(paramString1, paramString2, paramUiContext).j();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    new com.ideashower.readitlater.db.operation.action.g(paramString1, paramString2, paramString3, paramString4).j();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    new com.ideashower.readitlater.db.operation.action.g(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramInt4).j();
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (i.a((b)com.ideashower.readitlater.h.a.bf.a(paramString2))) {
        return;
      }
      i.b().a((b)com.ideashower.readitlater.h.a.bf.a(paramString2), true).a();
    }
    new com.ideashower.readitlater.db.operation.action.a(paramString1, paramString2).j();
  }
  
  public static boolean a()
  {
    return a.get() > 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/stats/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */