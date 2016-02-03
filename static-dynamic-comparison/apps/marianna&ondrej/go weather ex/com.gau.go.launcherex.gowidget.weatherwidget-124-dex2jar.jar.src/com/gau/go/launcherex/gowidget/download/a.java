package com.gau.go.launcherex.gowidget.download;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.widget.RemoteViews;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.model.q;
import java.io.File;

public class a
  implements f
{
  private static long r = 0L;
  private NotificationManager a = null;
  private Notification b = null;
  private PendingIntent c = null;
  private PendingIntent d = null;
  private PendingIntent e = null;
  private int f = 0;
  private int g = 0;
  private Context h = null;
  private String i = null;
  private String j = null;
  private String k = null;
  private String l = null;
  private String m = null;
  private String n = null;
  private String o = null;
  private String p = null;
  private RemoteViews q = null;
  private com.gau.go.launcherex.gowidget.weather.c.e s;
  private q t;
  
  public a(Context paramContext)
  {
    if (paramContext != null)
    {
      this.h = paramContext;
      this.a = ((NotificationManager)paramContext.getSystemService("notification"));
      this.q = new RemoteViews(paramContext.getPackageName(), 2130903125);
      this.s = c.a(this.h.getApplicationContext()).f();
      this.t = this.s.a();
    }
  }
  
  private static long a()
  {
    try
    {
      r += 1L;
      long l1 = r;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void b()
  {
    TypedArray localTypedArray = this.h.obtainStyledAttributes(16973928, new int[] { 16842904 });
    int i1 = localTypedArray.getColor(0, 0);
    localTypedArray.recycle();
    if ((0xFFFFFF & i1) < 8388607) {}
    for (this.t.C = "notification_style_default_white";; this.t.C = "notification_style_default_black")
    {
      this.s.a("notification_style", this.t.C);
      return;
    }
  }
  
  public void a(e parame)
  {
    Object localObject;
    int i1;
    if ((this.h != null) && (parame != null) && (this.q != null) && (this.a != null))
    {
      localObject = parame.d();
      this.j = String.format("%1$s--%2$s(%3$s)", new Object[] { parame.d(), this.h.getString(2131165368), this.h.getString(2131165369) });
      this.k = String.format("%1$s--%2$s(%3$s)", new Object[] { parame.d(), this.h.getString(2131165370), this.h.getString(2131165371) });
      this.l = String.format("%1$s--%2$s(%3$s)", new Object[] { parame.d(), this.h.getString(2131165372), this.h.getString(2131165373) });
      this.i = String.format("%1$s--%2$s", new Object[] { localObject, this.h.getString(2131165374) });
      this.m = String.format("%1$s--%2$s", new Object[] { localObject, this.h.getString(2131165375) });
      this.n = String.format("%1$s--%2$s", new Object[] { localObject, this.h.getString(2131165370) });
      this.o = String.format("%1$s--%2$s", new Object[] { localObject, this.h.getString(2131165372) });
      this.p = String.format("%1$s--%2$s", new Object[] { localObject, this.h.getString(2131165376) });
      localObject = new Intent();
      ((Intent)localObject).setAction("com.gau.go.launcherex.gowidget.download.DownloadBrocastReceiver.GOWEATHER_DOWNLOAD_STOP");
      ((Intent)localObject).setData(Uri.parse("download://" + a()));
      ((Intent)localObject).putExtra("download_task_id_key", parame.b());
      this.c = PendingIntent.getBroadcast(this.h, 0, (Intent)localObject, 268435456);
      localObject = new Intent();
      ((Intent)localObject).setAction("com.gau.go.launcherex.gowidget.download.DownloadBrocastReceiver.GOWEATHER_DOWNLOAD_DELETE");
      ((Intent)localObject).setData(Uri.parse("download://" + a()));
      ((Intent)localObject).putExtra("download_task_id_key", parame.b());
      this.d = PendingIntent.getBroadcast(this.h, 0, (Intent)localObject, 268435456);
      localObject = new Intent();
      ((Intent)localObject).setAction("com.gau.go.launcherex.gowidget.download.DownloadBrocastReceiver.GOWEATHER_DOWNLOAD_RESTART");
      ((Intent)localObject).setData(Uri.parse("download://" + a()));
      ((Intent)localObject).putExtra("download_task_id_key", parame.b());
      this.e = PendingIntent.getBroadcast(this.h, 0, (Intent)localObject, 268435456);
      localObject = new Intent();
      ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject).setComponent(new ComponentName(this.h.getPackageName(), "com.gau.go.launcherex.gowidget.framework.GoWidgetActivity"));
      ((Intent)localObject).setFlags(270532608);
      localObject = PendingIntent.getActivity(this.h, 0, (Intent)localObject, 268435456);
      this.b = new Notification();
      this.b.icon = 2130838349;
      this.b.tickerText = this.m;
      this.b.when = System.currentTimeMillis();
      this.b.contentIntent = ((PendingIntent)localObject);
      this.b.flags = 2;
      this.b.deleteIntent = this.d;
      if (this.t.C.equals("notification_style_default")) {
        b();
      }
      i1 = 17170443;
      localObject = this.h.getResources();
      if (!this.t.C.equals("notification_style_default_black")) {
        break label802;
      }
      i1 = ((Resources)localObject).getColor(2131361859);
    }
    for (;;)
    {
      this.q.setTextColor(2131231295, i1);
      this.q.setTextColor(2131231296, i1);
      this.q.setCharSequence(2131231295, "setText", this.i);
      this.q.setCharSequence(2131231296, "setText", this.g + "%");
      this.b.contentView = this.q;
      this.a.notify("com.gau.go.launcherex.gowidget.powersave.download.NOTYFY_TAG", (int)parame.b(), this.b);
      return;
      label802:
      if (this.t.C.equals("notification_style_default_white")) {
        i1 = ((Resources)localObject).getColor(2131361862);
      }
    }
  }
  
  public void b(e parame)
  {
    if ((this.h != null) && (parame != null) && (this.q != null) && (this.a != null) && (this.b != null) && ((parame.f() > this.f) || (this.f >= 100)))
    {
      this.f += 5;
      this.g = parame.f();
      this.b.contentIntent = this.c;
      this.q.setCharSequence(2131231295, "setText", this.j);
      this.q.setInt(2131231297, "setProgress", this.g);
      this.q.setCharSequence(2131231296, "setText", this.g + "%");
      this.b.contentView = this.q;
      this.a.notify("com.gau.go.launcherex.gowidget.powersave.download.NOTYFY_TAG", (int)parame.b(), this.b);
    }
  }
  
  public void c(e parame)
  {
    if ((this.h != null) && (this.a != null) && (parame != null))
    {
      this.a.cancel("com.gau.go.launcherex.gowidget.powersave.download.NOTYFY_TAG", (int)parame.b());
      Object localObject = new Intent();
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      ((Intent)localObject).setDataAndType(Uri.fromFile(new File(parame.g())), "application/vnd.android.package-archive");
      localObject = PendingIntent.getActivity(this.h, 0, (Intent)localObject, 0);
      Notification localNotification = new Notification();
      localNotification.icon = 2130838349;
      localNotification.tickerText = this.p;
      localNotification.when = System.currentTimeMillis();
      RemoteViews localRemoteViews = new RemoteViews(this.h.getPackageName(), 2130903124);
      localRemoteViews.setImageViewResource(2131231294, 2130838349);
      localRemoteViews.setTextViewText(2131231295, this.p);
      localNotification.contentView = localRemoteViews;
      localNotification.setLatestEventInfo(this.h, parame.d(), this.p, (PendingIntent)localObject);
      localNotification.flags = 16;
      this.a.notify("com.gau.go.launcherex.gowidget.powersave.download.NOTYFY_TAG", (int)parame.b(), localNotification);
    }
  }
  
  public void d(e parame)
  {
    if ((this.h != null) && (parame != null) && (this.a != null) && (this.q != null) && (this.b != null))
    {
      this.a.cancel("com.gau.go.launcherex.gowidget.powersave.download.NOTYFY_TAG", (int)parame.b());
      this.b.tickerText = this.o;
      this.b.contentIntent = this.e;
      this.q.setCharSequence(2131231295, "setText", this.l);
      this.b.contentView = this.q;
      this.b.flags = 16;
      this.a.notify("com.gau.go.launcherex.gowidget.powersave.download.NOTYFY_TAG", (int)parame.b(), this.b);
    }
  }
  
  public void e(e parame)
  {
    if ((this.h != null) && (this.a != null) && (parame != null) && (this.q != null) && (this.b != null) && (parame.h() != 6))
    {
      this.a.cancel("com.gau.go.launcherex.gowidget.powersave.download.NOTYFY_TAG", (int)parame.b());
      this.b.tickerText = this.n;
      this.b.contentIntent = this.e;
      this.q.setCharSequence(2131231295, "setText", this.k);
      this.b.contentView = this.q;
      this.b.flags = 16;
      this.a.notify("com.gau.go.launcherex.gowidget.powersave.download.NOTYFY_TAG", (int)parame.b(), this.b);
    }
  }
  
  public void f(e parame)
  {
    this.f = 0;
    this.g = 0;
  }
  
  public void g(e parame)
  {
    if ((parame != null) && (this.a != null) && (this.h != null))
    {
      Notification localNotification = new Notification();
      localNotification.icon = 2130838349;
      localNotification.tickerText = String.format("%1$s--%2$s", new Object[] { parame.d(), this.h.getString(2131165377) });
      localNotification.when = System.currentTimeMillis();
      Object localObject = new Intent();
      ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject).setComponent(new ComponentName(this.h.getPackageName(), "com.gau.go.launcherex.gowidget.framework.GoWidgetActivity"));
      ((Intent)localObject).setFlags(270532608);
      localObject = PendingIntent.getActivity(this.h, 0, (Intent)localObject, 268435456);
      localNotification.setLatestEventInfo(this.h, parame.d(), this.h.getString(2131165378), (PendingIntent)localObject);
      localNotification.flags = 16;
      this.a.notify("com.gau.go.launcherex.gowidget.powersave.download.NOTYFY_TAG", (int)parame.b(), localNotification);
    }
  }
  
  public void h(e parame)
  {
    if ((this.a != null) && (parame != null) && (parame.f() < 100))
    {
      this.a.cancel("com.gau.go.launcherex.gowidget.powersave.download.NOTYFY_TAG", (int)parame.b());
      this.a = null;
    }
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.h = null;
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = null;
    this.q = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/download/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */