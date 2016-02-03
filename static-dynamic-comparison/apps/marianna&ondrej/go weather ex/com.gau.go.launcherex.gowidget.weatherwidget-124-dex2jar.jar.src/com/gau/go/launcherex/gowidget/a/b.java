package com.gau.go.launcherex.gowidget.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.y;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends Handler
{
  private static b b;
  private Context a;
  private AlarmManager c;
  private PendingIntent d;
  private e e;
  private SharedPreferences f;
  private boolean g = false;
  private boolean h = false;
  
  private b(Context paramContext)
  {
    this.a = paramContext;
    this.f = GoWidgetApplication.c(this.a.getApplicationContext()).a();
    this.c = ((AlarmManager)this.a.getSystemService("alarm"));
    paramContext = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GETJAR_HTTP_REQUEST");
    this.d = PendingIntent.getBroadcast(this.a, 0, paramContext, 134217728);
    this.e = new e(this, null);
    paramContext = new IntentFilter();
    paramContext.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GETJAR_HTTP_REQUEST");
    paramContext.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.addAction("android.intent.action.TIME_SET");
    paramContext.addAction("android.intent.action.TIMEZONE_CHANGED");
    paramContext.addAction("android.intent.action.LOCALE_CHANGED");
    this.a.registerReceiver(this.e, paramContext);
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new b(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = this.f.edit();
    localEditor.putInt("key_getjar_source", paramInt1);
    localEditor.putInt("key_getjar_pricetouse", paramInt2);
    localEditor.putInt("key_getjar_solid_price", paramInt3);
    localEditor.putString("key_support_paytype", paramString);
    localEditor.putLong("key_getjar_check_record_time", System.currentTimeMillis());
    localEditor.putLong("key_getjar_check_interval", paramLong);
    localEditor.commit();
  }
  
  private void a(String paramString, com.jiubang.goweather.b.f paramf)
  {
    int k = 75;
    com.gtp.a.a.a.a.a().a("请求结果：jsonResult -- " + paramString, "getjar_log.txt");
    if (paramString.length() > 0) {}
    label246:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString != null)
        {
          int m = paramString.optInt("source", 1);
          int j = 0;
          if (m == 0) {
            j = paramString.optInt("price", 75);
          }
          String str = paramString.optString("paytypes");
          long l = paramString.optLong("interval", 3600000L);
          i = j;
          if (j == 0)
          {
            paramString = y.n(this.a);
            localMap = m.a(this.a, 2131034121);
            if ((localMap != null) && (localMap.containsKey(paramString))) {
              i = ((Integer)localMap.get(paramString)).intValue();
            }
          }
          else
          {
            if (i != 0) {
              break label246;
            }
            i = k;
            a(m, 1, i, str, l);
            paramf.b(1);
            return;
          }
        }
      }
      catch (JSONException paramString)
      {
        Map localMap;
        paramString.printStackTrace();
        paramString = null;
        continue;
        if (localMap != null)
        {
          i = ((Integer)localMap.get("others")).intValue();
          continue;
        }
        int i = 75;
        continue;
        paramf.b(11);
        paramf.c(10);
        return;
      }
      paramf.b(11);
      paramf.c(10);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    long l1;
    if (!paramBoolean)
    {
      l1 = this.f.getLong("key_getjar_check_record_time", 0L);
      if (l1 == 0L) {
        l1 = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      this.c.cancel(this.d);
      this.c.set(0, l1, this.d);
      return;
      long l2 = this.f.getLong("key_getjar_check_interval", 0L);
      com.gtp.a.a.a.a.a().a("调度下一次请求 -- 间隔 " + l2 / 60000L + "分钟。", "getjar_log.txt");
      l1 += l2;
      continue;
      com.gtp.a.a.a.a.a().a("调度下一次请求 -- 延迟20分钟。", "getjar_log.txt");
      l1 = System.currentTimeMillis() + 1200000L;
    }
  }
  
  private byte[] a(String paramString)
  {
    byte[] arrayOfByte = null;
    if (paramString != null) {
      paramString = com.gau.go.launcherex.gowidget.statistics.c.a(paramString, "lvsiqiaoil611230");
    }
    try
    {
      arrayOfByte = paramString.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private String c()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str2 = y.d(this.a);
    String str1 = str2;
    if (str2 == null) {
      str1 = "0000000000000000";
    }
    localStringBuffer.append(str1).append("||");
    str1 = y.n(this.a);
    com.gtp.a.a.a.a.a().a("getjar请求地区码：" + str1, "getjar_log.txt");
    localStringBuffer.append(str1).append("||");
    localStringBuffer.append(this.a.getPackageName());
    return localStringBuffer.toString();
  }
  
  public void a()
  {
    if (!this.h)
    {
      removeMessages(1);
      sendEmptyMessageDelayed(1, 20000L);
    }
  }
  
  public com.jiubang.goweather.b.f b()
  {
    com.gtp.a.a.a.a.a().a("启动getjar请求。", "getjar_log.txt");
    Object localObject = new com.jiubang.goweather.b.e("http://gostore.3g.cn/gostore/webcontent/function/GetjarPrice.jsp?appuid=2");
    ((com.jiubang.goweather.b.e)localObject).a("POST");
    ((com.jiubang.goweather.b.e)localObject).a(a(c()));
    com.jiubang.goweather.b.f localf = new com.jiubang.goweather.b.f();
    com.jiubang.goweather.b.c localc = com.jiubang.goweather.b.d.a();
    if (localc.a(localf, this.a))
    {
      localObject = localc.b("http://gostore.3g.cn/gostore/webcontent/function/GetjarPrice.jsp?appuid=2", (com.jiubang.goweather.b.e)localObject, localf);
      if (localObject != null)
      {
        a((String)localObject, localf);
        return localf;
      }
      com.gtp.a.a.a.a.a().a("getjar请求失败，inputstream为null。", "getjar_log.txt");
      localf.b(11);
      return localf;
    }
    localf.b(11);
    localf.c(3);
    return localf;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = com.gau.go.launcherex.gowidget.weather.c.c.a(this.a.getApplicationContext()).e();
      boolean bool1 = paramMessage.b();
      boolean bool2 = paramMessage.c();
      if ((!bool1) || (!bool2)) {
        new d(this, null).execute(new Void[0]);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */