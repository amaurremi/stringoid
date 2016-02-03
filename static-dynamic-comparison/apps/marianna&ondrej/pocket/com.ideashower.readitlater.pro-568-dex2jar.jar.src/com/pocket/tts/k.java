package com.pocket.tts;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.x;
import android.widget.RemoteViews;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.ReaderActivity;
import com.ideashower.readitlater.util.j;

public class k
  extends com.pocket.l.a.a
  implements com.ideashower.readitlater.a.h
{
  private static final boolean c = ;
  private static final int d = j.a(64.0F);
  private static final int e = j.a(128.0F);
  public Bitmap a;
  public Bitmap b;
  private final Context f;
  private Notification g;
  private PendingIntent h;
  private long i;
  private float j;
  private Runnable k;
  private l l;
  private x m;
  private int n;
  
  protected k(Context paramContext)
  {
    this.f = paramContext;
    g.a(this);
  }
  
  private PendingIntent a(String paramString)
  {
    paramString = new Intent(paramString);
    paramString.setComponent(new ComponentName(this.f, TTSMediaButtonReceiver.class));
    return PendingIntent.getBroadcast(this.f, 0, paramString, 0);
  }
  
  private void i()
  {
    boolean bool;
    if (c) {
      if (h.b() != null)
      {
        bool = true;
        if ((!bool) || (j()) || (this.l == null)) {
          break label133;
        }
        if (this.h == null)
        {
          localIntent = ReaderActivity.c(this.f);
          localIntent.addFlags(603979776);
          this.h = PendingIntent.getActivity(this.f, 0, localIntent, 0);
          this.i = System.currentTimeMillis();
        }
        if (!c) {
          break label122;
        }
        this.g = k();
        ((NotificationManager)this.f.getSystemService("notification")).notify(424242, this.g);
      }
    }
    label122:
    label133:
    while (this.g == null) {
      for (;;)
      {
        Intent localIntent;
        return;
        bool = false;
        break;
        bool = h.a();
        break;
        this.g = l();
      }
    }
    d();
  }
  
  private static boolean j()
  {
    com.ideashower.readitlater.activity.a locala = g.n();
    if ((locala instanceof ReaderActivity)) {
      return ((ReaderActivity)locala).D();
    }
    return false;
  }
  
  @TargetApi(16)
  private Notification k()
  {
    RemoteViews localRemoteViews1 = new RemoteViews(this.f.getPackageName(), 2130903088);
    RemoteViews localRemoteViews2 = new RemoteViews(this.f.getPackageName(), 2130903089);
    localRemoteViews1.setTextViewText(2131230768, l.a(this.l));
    localRemoteViews2.setTextViewText(2131230768, l.a(this.l));
    localRemoteViews1.setTextViewText(2131230927, l.b(this.l));
    localRemoteViews1.setTextViewText(2131230928, l.c(this.l));
    String str = org.apache.a.c.k.b(l.c(this.l), "");
    Object localObject = str;
    if (!org.apache.a.c.k.a(str)) {
      localObject = str + " — ";
    }
    localRemoteViews2.setTextViewText(2131230932, (String)localObject + l.b(this.l));
    localObject = a("com.pocket.tts.action.REWIND");
    localRemoteViews1.setOnClickPendingIntent(2131230929, (PendingIntent)localObject);
    localRemoteViews2.setOnClickPendingIntent(2131230929, (PendingIntent)localObject);
    localObject = a("com.pocket.tts.action.PLAY_PAUSE");
    localRemoteViews1.setOnClickPendingIntent(2131230930, (PendingIntent)localObject);
    localRemoteViews2.setOnClickPendingIntent(2131230930, (PendingIntent)localObject);
    if (this.n == 3) {}
    for (int i1 = 2130837515;; i1 = 2130837516)
    {
      localRemoteViews1.setImageViewResource(2131230930, i1);
      localRemoteViews2.setImageViewResource(2131230930, i1);
      localObject = a("com.pocket.tts.action.STOP");
      localRemoteViews1.setOnClickPendingIntent(2131230926, (PendingIntent)localObject);
      localRemoteViews2.setOnClickPendingIntent(2131230926, (PendingIntent)localObject);
      localRemoteViews1.setOnClickPendingIntent(2131230931, a("com.pocket.tts.action.FAST_FORWARD"));
      localRemoteViews1.setImageViewBitmap(2131230925, l.d(this.l));
      localRemoteViews2.setImageViewBitmap(2131230925, l.e(this.l));
      i1 = (int)(this.j * 100.0F);
      localRemoteViews1.setProgressBar(2131230758, 100, i1, false);
      localRemoteViews2.setProgressBar(2131230758, 100, i1, false);
      if (this.m == null) {
        this.m = new x(this.f).a(true).b(true).a(2130837694).a(this.h).c(this.f.getString(2131493786)).a(this.i);
      }
      localObject = this.m.a();
      ((Notification)localObject).contentView = localRemoteViews2;
      ((Notification)localObject).bigContentView = localRemoteViews1;
      ((Notification)localObject).contentIntent = this.h;
      return (Notification)localObject;
    }
  }
  
  private Notification l()
  {
    if (!com.ideashower.readitlater.util.a.g())
    {
      if (this.m == null) {
        this.m = new x(this.f).a(true).b(true).a(2130837694).a(this.h).c(this.f.getString(2131493786)).a(this.i);
      }
      return this.m.a(this.f.getString(2131493786)).b(l.a(this.l)).a(100, (int)(this.j * 100.0F), false).a();
    }
    return m();
  }
  
  private Notification m()
  {
    Notification localNotification = new Notification(2130837694, "Listening", System.currentTimeMillis());
    localNotification.setLatestEventInfo(this.f, "Listening", l.a(this.l), this.h);
    localNotification.flags = (localNotification.flags | 0x2 | 0x8);
    return localNotification;
  }
  
  private void n()
  {
    if (g.q())
    {
      i();
      return;
    }
    e();
  }
  
  public com.pocket.l.a.b a(boolean paramBoolean)
  {
    if ((paramBoolean) || (this.l == null)) {
      this.l = new l(this);
    }
    return this.l;
  }
  
  public void a(float paramFloat)
  {
    this.j = paramFloat;
    n();
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
    n();
  }
  
  public boolean a()
  {
    e();
    return false;
  }
  
  public void b(int paramInt) {}
  
  public boolean b()
  {
    e();
    return false;
  }
  
  public void c()
  {
    n();
  }
  
  public void d()
  {
    ((NotificationManager)this.f.getSystemService("notification")).cancel(424242);
    this.g = null;
    this.h = null;
    if (this.l != null)
    {
      if (l.f(this.l) != null) {
        l.f(this.l).b(false);
      }
      if (l.g(this.l) != null) {
        l.g(this.l).b(false);
      }
    }
  }
  
  public void e()
  {
    if (this.k == null) {
      this.k = new Runnable()
      {
        public void run()
        {
          k.a(k.this);
        }
      };
    }
    g.a(this.k);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/tts/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */