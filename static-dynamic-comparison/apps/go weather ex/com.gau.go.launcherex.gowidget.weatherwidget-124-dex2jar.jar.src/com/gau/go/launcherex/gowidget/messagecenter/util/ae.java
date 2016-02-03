package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.gau.go.launcherex.gowidget.messagecenter.a.d;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class ae
{
  private static ae h;
  private HashMap a = new HashMap();
  private Context b = null;
  private NotificationManager c = null;
  private Notification d = null;
  private BroadcastReceiver e = null;
  private RemoteViews f = null;
  private boolean g = true;
  private e i;
  private q j;
  private int k;
  private Random l;
  
  private ae(Context paramContext)
  {
    this.b = paramContext;
    c();
    a();
  }
  
  public static ae a(Context paramContext)
  {
    if (h == null) {
      h = new ae(paramContext);
    }
    return h;
  }
  
  private void a()
  {
    if (this.j.C.equals("notification_style_default")) {
      b();
    }
    Resources localResources = this.b.getResources();
    if (this.j.C.equals("notification_style_default_black")) {
      this.k = localResources.getColor(2131361859);
    }
    while (!this.j.C.equals("notification_style_default_white")) {
      return;
    }
    this.k = localResources.getColor(2131361862);
  }
  
  private void a(d paramd, boolean paramBoolean)
  {
    String str = paramd.b;
    Object localObject;
    Bitmap localBitmap;
    int m;
    if ((paramd.c == 2) || (paramd.c == 5))
    {
      localObject = paramd.i;
      c(paramd);
      localBitmap = null;
      if (paramd.c != 4) {
        break label318;
      }
      if (paramd.D == null) {
        break label312;
      }
      localBitmap = paramd.D;
      m = 0;
    }
    for (;;)
    {
      label59:
      if (m == 0)
      {
        this.d.icon = 2130838350;
        label72:
        this.d.flags = 25;
        this.d.defaults = 4;
        this.f = new RemoteViews(this.b.getPackageName(), 2130903247);
        if (m != 0) {
          break label367;
        }
        this.f.setImageViewBitmap(2131231779, localBitmap);
      }
      for (;;)
      {
        this.d.tickerText = str;
        this.f.setViewVisibility(2131231783, 0);
        this.f.setTextColor(2131231784, this.k);
        this.f.setTextViewText(2131231784, str);
        this.f.setTextColor(2131231783, this.k);
        this.f.setTextViewText(2131231783, (CharSequence)localObject);
        this.d.contentView = this.f;
        localObject = Integer.valueOf(paramd.a.hashCode());
        if ((paramd.a == null) || (paramd.a.equals(""))) {
          localObject = Integer.valueOf(e());
        }
        this.c.notify("notification_tag_message", ((Integer)localObject).intValue(), this.d);
        return;
        if ((paramd.c == 4) && (!TextUtils.isEmpty(paramd.i)))
        {
          localObject = paramd.i;
          break;
        }
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        break;
        label312:
        m = 2130838276;
        break label59;
        label318:
        if ((paramd.c != 2) && (paramd.c != 5)) {
          break label380;
        }
        localBitmap = paramd.D;
        if (localBitmap == null)
        {
          m = 2130838350;
          break label59;
        }
        m = 0;
        break label59;
        this.d.icon = m;
        break label72;
        label367:
        this.f.setImageViewResource(2131231779, m);
      }
      label380:
      m = 2130838350;
    }
  }
  
  private void b()
  {
    TypedArray localTypedArray = this.b.obtainStyledAttributes(16973928, new int[] { 16842904 });
    int m = localTypedArray.getColor(0, 0);
    localTypedArray.recycle();
    if ((0xFFFFFF & m) < 8388607) {}
    for (this.j.C = "notification_style_default_white";; this.j.C = "notification_style_default_black")
    {
      this.i.a("notification_style", this.j.C);
      return;
    }
  }
  
  private void c()
  {
    boolean bool = true;
    this.a.clear();
    d();
    this.i = com.gau.go.launcherex.gowidget.weather.c.c.a(this.b.getApplicationContext()).f();
    this.j = this.i.a();
    if (this.j.z == 1) {}
    for (;;)
    {
      this.g = bool;
      this.c = ((NotificationManager)this.b.getSystemService("notification"));
      this.l = new Random();
      return;
      bool = false;
    }
  }
  
  private void c(d paramd)
  {
    this.d = new Notification();
    Integer localInteger = Integer.valueOf(paramd.a.hashCode());
    if ((paramd.a == null) || (paramd.a.equals(""))) {
      localInteger = Integer.valueOf(e());
    }
    Intent localIntent = new Intent(this.b, NotifyService.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("notify_request", 26);
    localBundle.putInt("request_extra_message_notify_pending_code", 1);
    localBundle.putString("extras_message_notify_pending_code_click_msg_id", paramd.a);
    localIntent.putExtras(localBundle);
    paramd = PendingIntent.getService(this.b, localInteger.intValue(), localIntent, 134217728);
    this.d.contentIntent = paramd;
    paramd = new Intent("action_delete_message_notification");
    paramd = PendingIntent.getBroadcast(this.b, 2, paramd, 134217728);
    this.d.deleteIntent = paramd;
  }
  
  private void d()
  {
    if (this.e == null) {
      this.e = new af(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_delete_message_notification");
    localIntentFilter.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_NOTIFICATION_SOUND");
    this.b.registerReceiver(this.e, localIntentFilter);
  }
  
  private int e()
  {
    return -this.l.nextInt(10000);
  }
  
  public void a(d paramd)
  {
    int m = 1;
    if (!paramd.B)
    {
      com.gtp.a.a.b.c.a("MSGCenter", "新增通知栏" + paramd.a);
      m.a(this.b).a(paramd.a, 2);
      this.a.put(paramd.a, paramd);
      m.a(this.b.getApplicationContext()).a(paramd);
      a(paramd, true);
    }
    for (;;)
    {
      return;
      if (this.a.get(paramd.a) != null) {}
      while (m != 0)
      {
        com.gtp.a.a.b.c.a("MSGCenter", "更新通知栏" + paramd.a);
        this.a.put(paramd.a, paramd);
        a(paramd, false);
        return;
        m = 0;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.c == null) {
      this.c = ((NotificationManager)this.b.getSystemService("notification"));
    }
    int m = paramString.hashCode();
    if ((paramString != null) && (!paramString.equals("")))
    {
      this.c.cancel("notification_tag_message", Integer.valueOf(m).intValue());
      com.gtp.a.a.b.c.a("MSGCenter", "取消通知栏" + paramString);
      this.a.remove(paramString);
    }
  }
  
  public void b(d paramd)
  {
    if (this.a.get(paramd.a) != null) {}
    for (int m = 1;; m = 0)
    {
      if (m != 0) {
        a(paramd.a);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */