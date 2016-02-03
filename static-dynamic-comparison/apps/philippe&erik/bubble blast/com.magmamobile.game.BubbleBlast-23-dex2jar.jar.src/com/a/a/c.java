package com.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.scoreloop.client.android.core.utils.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class c
{
  private static c a;
  private List<a> b = new ArrayList();
  private String c;
  private String d;
  private String e;
  private Long f;
  private String g;
  private String h;
  private Date i;
  private List<f> j;
  private Date k;
  private int l;
  private Timer m;
  private TimerTask n = new g(this);
  
  private c(String paramString1, String paramString2, String paramString3)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = Long.valueOf(0L);
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = new ArrayList();
    this.k = new Date();
    this.l = 0;
    this.m = null;
  }
  
  public static c a()
  {
    return a;
  }
  
  public static c a(String paramString1, String paramString2, a parama)
  {
    paramString1 = a(paramString1, paramString2, null);
    paramString1.d().add(parama);
    return paramString1;
  }
  
  private static c a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new c(paramString1, paramString2, paramString3);
    if (a == null) {
      a = paramString1;
    }
    return paramString1;
  }
  
  private boolean a(f paramf, boolean paramBoolean)
  {
    int i1;
    if (this.k != null) {
      if (new Date().getTime() - this.k.getTime() < 2L) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if ((this.k != null) && (i1 != 0))
      {
        int i2 = this.l + 1;
        this.l = i2;
        if (i2 > 3)
        {
          if (paramBoolean) {
            b(paramf);
          }
          return false;
          i1 = 0;
          continue;
        }
      }
      try
      {
        paramf.b();
        if (i1 == 0)
        {
          this.l = 0;
          this.k = paramf.a();
        }
        return true;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
      i1 = 0;
    }
  }
  
  private void b(f paramf)
  {
    this.j.add(paramf);
    k();
  }
  
  private void k()
  {
    if (this.m == null)
    {
      long l1 = a.c.a(this.k);
      this.m = new Timer();
      this.m.schedule(this.n, (l1 + 2L) * 1000L);
    }
  }
  
  private void l()
  {
    while (this.j.size() > 0) {
      if (a((f)this.j.get(0), false)) {
        this.j.remove(0);
      } else {
        k();
      }
    }
  }
  
  public void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("FBSessionPreferences", 0).edit();
    if (this.f != null)
    {
      paramContext.putLong("FBUserId", this.f.longValue());
      if (this.g == null) {
        break label119;
      }
      paramContext.putString("FBSessionKey", this.g);
      label56:
      if (this.h == null) {
        break label131;
      }
      paramContext.putString("FBSessionSecret", this.h);
      label76:
      if (this.i == null) {
        break label143;
      }
      paramContext.putLong("FBSessionExpires", this.i.getTime());
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.remove("FBUserId");
      break;
      label119:
      paramContext.remove("FBSessionKey");
      break label56;
      label131:
      paramContext.remove("FBSessionSecret");
      break label76;
      label143:
      paramContext.remove("FBSessionExpires");
    }
  }
  
  public void a(Context paramContext, Long paramLong, String paramString1, String paramString2, Date paramDate)
  {
    this.f = paramLong;
    this.g = paramString1;
    this.h = paramString2;
    this.i = ((Date)paramDate.clone());
    a(paramContext);
  }
  
  public void a(f paramf)
  {
    a(paramf, true);
  }
  
  public String b()
  {
    return "http://api.facebook.com/restserver.php";
  }
  
  public boolean b(Context paramContext)
  {
    boolean bool2 = true;
    Object localObject = paramContext.getSharedPreferences("FBSessionPreferences", 0);
    Long localLong = Long.valueOf(((SharedPreferences)localObject).getLong("FBUserId", 0L));
    Logger.a("FBSession", "FBUserId = " + localLong);
    int i1;
    if (localLong.longValue() != 0L)
    {
      long l1 = ((SharedPreferences)localObject).getLong("FBSessionExpires", 0L);
      if (l1 > 0L)
      {
        Date localDate = new Date(l1);
        if ("expirationDate = " + localDate != null)
        {
          paramContext = localDate.toLocaleString();
          Logger.a("FBSession", paramContext);
          l1 = a.c.a(localDate);
          Logger.a("FBSession", "Time interval since now = " + l1);
          if ((localDate != null) && (l1 > 0L)) {
            break label291;
          }
          i1 = 1;
        }
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        Logger.a("FBSession", "Session can be loaded.  Loading...");
        this.f = localLong;
        this.g = ((SharedPreferences)localObject).getString("FBSessionKey", null);
        this.h = ((SharedPreferences)localObject).getString("FBSessionSecret", null);
        paramContext = this.b.iterator();
        for (;;)
        {
          bool1 = bool2;
          if (!paramContext.hasNext()) {
            break;
          }
          localObject = (a)paramContext.next();
          if (localObject != null) {
            ((a)localObject).a(this, localLong);
          }
        }
        paramContext = "null";
        break;
        Logger.a("FBSession", "FBSessionExpires does not exist.  Loading session...");
        i1 = 1;
        continue;
      }
      boolean bool1 = false;
      return bool1;
      label291:
      i1 = 0;
    }
  }
  
  public boolean c()
  {
    return this.g != null;
  }
  
  public List<a> d()
  {
    return this.b;
  }
  
  public String e()
  {
    return this.c;
  }
  
  public String f()
  {
    return this.d;
  }
  
  public String g()
  {
    return this.e;
  }
  
  public Long h()
  {
    return this.f;
  }
  
  public String i()
  {
    return this.g;
  }
  
  public String j()
  {
    return this.h;
  }
  
  public static abstract class a
  {
    public void a(c paramc, Long paramLong) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */