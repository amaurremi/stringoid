package com.appflood.c;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.appflood.AFListActivity.1;
import com.appflood.b.b;
import com.appflood.b.b.a;
import com.appflood.e.c;
import com.appflood.e.j;
import com.appflood.e.k;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import org.json.JSONObject;

public final class d
{
  public static String A = "_EN.png";
  public static int B = 30000;
  public static int C = 15000;
  public static String D = null;
  public static String E = null;
  public static int F = 255;
  public static int G;
  public static boolean H = true;
  public static boolean I = true;
  private static String J;
  private static String K;
  private static String L;
  private static String M;
  private static ArrayList<a> N = new ArrayList();
  private static a O = null;
  private static Semaphore P = new Semaphore(1);
  private static Semaphore Q = new Semaphore(1);
  public static boolean a = false;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static URL h;
  public static HashMap<String, Object> i;
  public static boolean j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;
  
  static
  {
    M = "get_token";
    j = false;
    k = null;
    m = null;
    n = null;
    s = null;
    t = null;
    u = null;
    v = null;
    w = null;
    x = null;
    y = null;
    z = "";
  }
  
  public static void a()
  {
    if ((j.a(D)) || (j.a(E))) {
      j.c("app id or secret key is null!!");
    }
    while (!P.tryAcquire()) {
      return;
    }
    if (j)
    {
      h();
      P.release();
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("model", Integer.valueOf(6));
    localHashMap.put("adid", c.B);
    localHashMap.put("duid", k.d(c.a));
    localHashMap.put("mac", k.d(c.e));
    localHashMap.put("aid", k.d(c.b));
    localHashMap.put("uuid", k.d(f.a));
    localHashMap.put("app_key", D);
    localHashMap.put("sm", Integer.valueOf(c.s));
    localHashMap.put("adtype", Integer.valueOf(F));
    long l1 = System.currentTimeMillis();
    localHashMap.put("ts", Long.valueOf(l1));
    localHashMap.put("signature", j.a(c.a + c.b + D + c.e + l1 + E));
    localHashMap.put("v", "V2.22".substring(1));
    new StringBuilder("package name = ").append(c.C).toString();
    j.a();
    localHashMap.put("bm", k.d(c.C));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("av", c.d);
      localJSONObject.put("br", c.l);
      localJSONObject.put("dn", c.c);
      localJSONObject.put("pm", c.k);
      localJSONObject.put("mf", c.m);
      localJSONObject.put("dp", c.n);
      localJSONObject.put("pn", c.f);
      localJSONObject.put("so", c.o);
      localJSONObject.put("sn", c.p);
      localJSONObject.put("sm", c.s);
      localJSONObject.put("mc", c.u);
      localJSONObject.put("wc", c.v);
      localJSONObject.put("lc", c.w);
      localJSONObject.put("ll", c.x);
      if (c.q != 0.0D)
      {
        localJSONObject.put("xx", c.q);
        localJSONObject.put("yy", c.r);
      }
      localHashMap.put("data", k.d(localJSONObject.toString()));
      new StringBuilder("connect  data = ").append(localJSONObject).toString();
      j.a();
      new b(k.a(g + M, localHashMap)).a(new b.a()
      {
        public final void a(b paramAnonymousb)
        {
          d.b(null);
          paramAnonymousb = paramAnonymousb.c();
          JSONObject localJSONObject = j.e(paramAnonymousb);
          int i = j.a(localJSONObject, "ret", -1);
          String str = j.a(localJSONObject, "msg", null);
          if (i == 0)
          {
            localJSONObject = j.a(localJSONObject, "data");
            if (localJSONObject != null)
            {
              d.a(localJSONObject);
              j.d("Login Success : " + paramAnonymousb.length());
            }
          }
          for (;;)
          {
            d.g().release();
            return;
            j.c("Login Failed. Error = " + str);
          }
        }
        
        public final void a(b paramAnonymousb, int paramAnonymousInt)
        {
          j.c("login Failed. code = " + paramAnonymousInt);
          if (d.e() != null) {}
          try
          {
            d.e().a();
            d.b(null);
            if (d.f().tryAcquire()) {
              f.a(new TimerTask()
              {
                public final void run()
                {
                  try
                  {
                    d.f().release();
                    d.a();
                    return;
                  }
                  catch (Throwable localThrowable)
                  {
                    j.b(localThrowable, "error in reconnect");
                  }
                }
              }, d.C);
            }
            d.g().release();
            return;
          }
          catch (Throwable paramAnonymousb)
          {
            for (;;) {}
          }
        }
      }).b(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public static void a(Context paramContext, a parama)
  {
    if (j) {
      if (parama == null) {}
    }
    do
    {
      try
      {
        parama.a();
        return;
      }
      catch (Throwable paramContext)
      {
        j.a(paramContext, "connection delegate error");
        return;
      }
      if (parama != null) {
        d(parama);
      }
    } while (!I);
    f.a(new b(paramContext));
  }
  
  public static void a(a parama)
  {
    if (j) {
      if (parama == null) {}
    }
    while (parama == null) {
      try
      {
        parama.a();
        return;
      }
      catch (Throwable parama)
      {
        j.a(parama, "connection delegate error");
        return;
      }
    }
    d(parama);
  }
  
  static void a(boolean paramBoolean)
  {
    a = paramBoolean;
    if (paramBoolean)
    {
      b = "免费热门游戏";
      J = "请连接网络以享受更多好玩的免费游戏！";
      K = "连接";
      L = "跳过";
      c = "载入中...";
      A = "_CN.png";
      e = "download_02_CN.png";
      f = "freebutton_02_CN.png";
      d = "下载";
    }
    for (g = "http://data.appflood.cn/";; g = "http://data.appflood.com/")
    {
      try
      {
        h = new URL(g);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      b = "More Free Games";
      J = "Connect to internet and enjoy more wonderful FREE games!";
      K = "Connect";
      L = "Skip";
      c = "Loading...";
      A = "_EN.png";
      e = "download_02.png";
      f = "freebutton_02.png";
      d = "Download";
    }
  }
  
  private static void d(a parama)
  {
    synchronized (N)
    {
      if (!N.contains(parama)) {
        N.add(parama);
      }
      return;
    }
  }
  
  private static void h()
  {
    Object localObject2 = new ArrayList();
    synchronized (N)
    {
      ((ArrayList)localObject2).addAll(N);
      N.clear();
      ??? = ((ArrayList)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)???).hasNext())
        {
          localObject2 = (a)((Iterator)???).next();
          if (localObject2 != null) {
            try
            {
              ((a)localObject2).a();
            }
            catch (Throwable localThrowable)
            {
              j.a(localThrowable, "connection delegate error");
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
  
  static final class b
    implements Runnable
  {
    Context a;
    
    public b(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public final void run()
    {
      try
      {
        final ProgressDialog localProgressDialog = ProgressDialog.show(this.a, "", d.c, true, true);
        d.b(new d.a()
        {
          public final void a()
          {
            f.a(new Runnable()
            {
              public final void run()
              {
                try
                {
                  if ((d.b.1.this.a != null) && (d.b.1.this.a.isShowing())) {
                    d.b.1.this.a.dismiss();
                  }
                  new AlertDialog.Builder(d.b.this.a).setMessage(d.d()).setPositiveButton(d.c(), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                    {
                      AFListActivity.1.a(d.b.a(d.b.this), new Intent("android.settings.WIRELESS_SETTINGS"));
                    }
                  }).setNegativeButton(d.b(), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int) {}
                  }).show();
                  return;
                }
                catch (Throwable localThrowable)
                {
                  j.b(localThrowable, "something wrong when dialog popup");
                }
              }
            });
          }
        });
        d.c(new d.a()
        {
          public final void a()
          {
            f.a(new Runnable()
            {
              public final void run()
              {
                try
                {
                  if ((d.b.this != null) && (d.b.this.isShowing())) {
                    d.b.this.dismiss();
                  }
                  return;
                }
                catch (Throwable localThrowable)
                {
                  j.b(localThrowable, "something wrong when dialog dismiss");
                }
              }
            });
          }
        });
        return;
      }
      catch (Throwable localThrowable)
      {
        j.b(localThrowable, "showProgress failed");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */