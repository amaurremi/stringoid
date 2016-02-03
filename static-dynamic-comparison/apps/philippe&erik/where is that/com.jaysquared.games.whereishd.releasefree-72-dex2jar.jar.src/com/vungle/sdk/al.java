package com.vungle.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import com.vungle.sdk.a.a.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public final class al
{
  boolean a = false;
  final Context b;
  int c = -1;
  String d = null;
  b e = null;
  private TimerTask f = null;
  private int g = -1;
  private int h = 0;
  private long i = -1L;
  
  public al(Context paramContext)
  {
    this.b = paramContext;
  }
  
  static void d()
  {
    synchronized (ak.k)
    {
      if ((!ak.d()) && (ak.k.booleanValue())) {
        return;
      }
      ak.k = Boolean.valueOf(true);
      new al(ak.e()).b();
      return;
    }
  }
  
  public final void a()
  {
    if (this.f != null) {
      this.f.cancel();
    }
    this.f = null;
    if (ba.e(this.b))
    {
      String str = e.t;
      if (ak.i)
      {
        this.e = new b(this, 1);
        this.e.c.start();
      }
      return;
    }
    this.c = 5;
    c();
  }
  
  public final void a(String paramString, a parama)
  {
    this.d = paramString;
    if (aw.a(paramString) == e.l) {
      parama.a(e.l);
    }
    do
    {
      return;
      ak.j = false;
      ak.k = Boolean.valueOf(true);
      paramString = new am(this);
      paramString.a = parama;
      parama = aj.e();
    } while (parama == null);
    parama.a(ay.a(), paramString);
  }
  
  final void b()
  {
    if ((ak.m) && (!ak.i)) {}
    do
    {
      return;
      ak.j = false;
      if (this.f != null) {
        this.f.cancel();
      }
      this.f = null;
      if (ba.f(this.b) != null) {
        break;
      }
      String str = e.t;
    } while (!ak.i);
    this.g = 0;
    this.e = new b(this, 0);
    this.e.c.start();
    return;
    this.c = 4;
    c();
  }
  
  final void c()
  {
    this.f = new an(this);
    this.h += 1;
    if (this.h > ak.c())
    {
      this.a = false;
      ak.k = Boolean.valueOf(false);
    }
    do
    {
      return;
      long l;
      String str;
      if (this.a)
      {
        this.a = false;
        l = ak.a();
        if (l > -1L)
        {
          new Timer().schedule(this.f, l);
          str = e.t;
          new StringBuilder("Sleep Timer Starts for: ").append(l / 1000L).append(" Seconds");
          str = e.t;
          new StringBuilder("Timer Type ").append(this.c);
        }
      }
      else
      {
        if (this.i <= 0L) {}
        for (this.i = ak.b();; this.i <<= 1)
        {
          str = e.t;
          new StringBuilder("Retry Count : ").append(this.h);
          str = e.t;
          new StringBuilder("Current Sleep Time : ").append(this.i);
          l = this.i;
          break;
        }
      }
    } while (ay.e() == null);
    ay.f();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
  
  private static final class b
  {
    WeakReference<al> a;
    int b;
    Thread c;
    
    public b(al paramal, int paramInt)
    {
      this.a = new WeakReference(paramal);
      this.b = paramInt;
      this.c = new Thread(new a((byte)0), "VungleNetworkTaskThread");
      this.c.setDaemon(true);
    }
    
    private final class a
      implements Runnable
    {
      private a() {}
      
      public final void run()
      {
        boolean bool2 = false;
        for (;;)
        {
          try
          {
            al localal = (al)al.b.this.a.get();
            if (localal == null) {
              return;
            }
            switch (al.b.this.b)
            {
            case 2: 
              Log.e("VungleNetworkTask", "Unexpected event type: " + al.b.this.b);
              return;
            }
          }
          catch (Throwable localThrowable1)
          {
            ay.a(localThrowable1);
            return;
          }
          Object localObject2 = new ao(this, localThrowable1);
          ba.h(localThrowable1.b);
          localThrowable1.d = null;
          Object localObject4;
          if (ak.q)
          {
            ak.q = false;
            localObject4 = aj.e();
            if (localObject4 != null)
            {
              localThrowable1.d = ((aj)localObject4).d();
              localObject4 = localThrowable1.d;
            }
          }
          if (localThrowable1.d == null)
          {
            localObject4 = ay.a().b(null);
            f.a();
            f.a((String)localObject4, localThrowable1, (al.a)localObject2);
            return;
          }
          localThrowable1.a(localThrowable1.d, (al.a)localObject2);
          return;
          String str;
          try
          {
            localObject2 = ay.b();
            if (ba.e(ak.e()))
            {
              if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
                break label605;
              }
              localObject4 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                str = (String)((Iterator)localObject4).next();
                if (at.a(e.b(), str).contains(e.C)) {
                  ((Iterator)localObject4).remove();
                }
              }
              ay.a((ArrayList)localObject2);
            }
          }
          catch (Throwable localThrowable2)
          {
            ay.a(localThrowable2);
            return;
          }
          if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
          {
            localThrowable2.c = 5;
            localThrowable2.c();
            return;
            localObject2 = Uri.parse(e.c()).buildUpon();
            ((Uri.Builder)localObject2).appendQueryParameter("isu", ba.c(localThrowable2.b));
            ((Uri.Builder)localObject2).appendQueryParameter("app_id", ay.a().c);
            localObject4 = ba.a(localThrowable2.b);
            if ((localObject4 != null) && (((String)localObject4).length() != 0)) {
              ((Uri.Builder)localObject2).appendQueryParameter("ma", (String)localObject4);
            }
            localObject4 = ba.a();
            if (!ba.b((String)localObject4)) {
              ((Uri.Builder)localObject2).appendQueryParameter("serial", (String)localObject4);
            }
            new StringBuilder("Request url: ").append(((Uri.Builder)localObject2).build().toString());
            localObject2 = ((Uri.Builder)localObject2).build().toString();
            localObject4 = e.t;
            if (!ba.b((String)localObject2))
            {
              localObject2 = at.a((String)localObject2);
              boolean bool1 = bool2;
              if (localObject2 != null)
              {
                localObject4 = ((ArrayList)localObject2).iterator();
                bool1 = bool2;
                if (((Iterator)localObject4).hasNext())
                {
                  bool1 = bool2;
                  if (e.C.equals(((Iterator)localObject4).next())) {
                    bool1 = true;
                  }
                }
              }
              localObject4 = localThrowable2.b;
              str = e.X;
              ??? = e.Y;
              localObject4 = ((Context)localObject4).getSharedPreferences(str, 0).edit();
              if (localObject4 != null)
              {
                ((SharedPreferences.Editor)localObject4).putBoolean((String)???, bool1);
                ((SharedPreferences.Editor)localObject4).commit();
              }
              ??? = e.t;
              new StringBuilder("Install report response: ").append((String)((ArrayList)localObject2).get(0));
            }
            synchronized (ak.l)
            {
              ak.l = Boolean.valueOf(false);
              return;
            }
          }
          label605:
          return;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */