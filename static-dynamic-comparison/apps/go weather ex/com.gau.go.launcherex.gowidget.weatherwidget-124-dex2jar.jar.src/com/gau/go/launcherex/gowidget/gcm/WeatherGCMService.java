package com.gau.go.launcherex.gowidget.gcm;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.messagecenter.a.d;
import com.gau.go.launcherex.gowidget.messagecenter.util.m;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Vector;

public class WeatherGCMService
  extends IntentService
{
  private static PowerManager.WakeLock a;
  private static final Object b = WeatherGCMService.class;
  
  public WeatherGCMService()
  {
    super(WeatherGCMService.class.getName());
  }
  
  static void a(Context paramContext, Intent paramIntent)
  {
    paramIntent.setClassName(paramContext, WeatherGCMService.class.getName());
    paramContext.startService(paramIntent);
  }
  
  private void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("registration_id");
    Object localObject1 = paramIntent.getStringExtra("error");
    Object localObject2 = paramIntent.getStringExtra("unregistered");
    paramIntent = getApplicationContext();
    Object localObject3;
    if (str != null)
    {
      System.out.println("注册成功");
      Object localObject4 = paramIntent.getSharedPreferences("goweatherex_info", 0);
      localObject3 = ((SharedPreferences)localObject4).getString("gcm_cur_reg_id", null);
      if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
        break label241;
      }
      localObject4 = ((SharedPreferences)localObject4).edit();
      ((SharedPreferences.Editor)localObject4).putString("gcm_cur_reg_id", str);
      ((SharedPreferences.Editor)localObject4).commit();
      b.a(paramIntent).a(str, (String)localObject3, true);
      localObject4 = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GCM_UPDATE_REG_ID");
      ((Intent)localObject4).putExtra("extra_cur_reg_id", str);
      ((Intent)localObject4).putExtra("extra_old_reg_id", (String)localObject3);
      paramIntent.sendBroadcast((Intent)localObject4);
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        System.out.println("反注册成功");
        str = paramIntent.getSharedPreferences("goweatherex_info", 0).getString("gcm_cur_reg_id", str);
        localObject2 = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GCM_OPERATION");
        ((Intent)localObject2).putExtra("extra_gcm_id", str);
        ((Intent)localObject2).putExtra("extra_gcm_op", 0);
        paramIntent.sendBroadcast((Intent)localObject2);
      }
      if (localObject1 != null)
      {
        localObject1 = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GCM_OPERATION");
        ((Intent)localObject1).putExtra("extra_gcm_id", "");
        paramIntent.sendBroadcast((Intent)localObject1);
      }
      return;
      label241:
      localObject3 = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_GCM_OPERATION");
      ((Intent)localObject3).putExtra("extra_gcm_id", str);
      ((Intent)localObject3).putExtra("extra_gcm_op", 1);
      paramIntent.sendBroadcast((Intent)localObject3);
    }
  }
  
  private void b(Intent paramIntent)
  {
    int j = 55536;
    System.out.println("收到推送消息");
    Object localObject3 = getApplicationContext();
    Object localObject2 = f.a((Context)localObject3);
    Object localObject4 = paramIntent.getStringExtra("alert_id");
    String str3;
    String str1;
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      str3 = paramIntent.getStringExtra("city_id");
      str1 = paramIntent.getStringExtra("exp_time");
      if (!((f)localObject2).f(str3)) {}
    }
    do
    {
      do
      {
        int i;
        try
        {
          i = Integer.parseInt((String)localObject4);
          localObject3 = ((f)localObject2).a(str3);
          if (!((WeatherBean)localObject3).c(i))
          {
            localObject3 = new com.gau.go.launcherex.gowidget.weather.model.c();
            ((com.gau.go.launcherex.gowidget.weather.model.c)localObject3).c(i);
            ((com.gau.go.launcherex.gowidget.weather.model.c)localObject3).g(str3);
            ((com.gau.go.launcherex.gowidget.weather.model.c)localObject3).a(paramIntent.getStringExtra("publish_time"));
            ((com.gau.go.launcherex.gowidget.weather.model.c)localObject3).b(str1);
            ((com.gau.go.launcherex.gowidget.weather.model.c)localObject3).c(paramIntent.getStringExtra("type"));
            str1 = paramIntent.getStringExtra("description");
          }
        }
        catch (Exception localUnsupportedEncodingException3)
        {
          try
          {
            str3 = URLDecoder.decode(str1, "UTF-8");
            str1 = str3;
            ((com.gau.go.launcherex.gowidget.weather.model.c)localObject3).d(str1);
            ((com.gau.go.launcherex.gowidget.weather.model.c)localObject3).e(paramIntent.getStringExtra("phenomena"));
            str1 = paramIntent.getStringExtra("level");
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException3)
          {
            try
            {
              ((com.gau.go.launcherex.gowidget.weather.model.c)localObject3).b(Integer.parseInt(str1));
              str1 = paramIntent.getStringExtra("message");
            }
            catch (Exception localUnsupportedEncodingException3)
            {
              try
              {
                str3 = URLDecoder.decode(str1, "UTF-8");
                str1 = str3;
                ((com.gau.go.launcherex.gowidget.weather.model.c)localObject3).f(str1);
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException3)
              {
                try
                {
                  for (;;)
                  {
                    i = Integer.parseInt(paramIntent.getStringExtra("tz_offset"));
                    ((com.gau.go.launcherex.gowidget.weather.model.c)localObject3).a(i);
                    ((f)localObject2).a((com.gau.go.launcherex.gowidget.weather.model.c)localObject3);
                    return;
                    localException4 = localException4;
                    localException4.printStackTrace();
                    i = 0;
                    continue;
                    localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
                    localUnsupportedEncodingException2.printStackTrace();
                    continue;
                    localException1 = localException1;
                    localException1.printStackTrace();
                    localException4.b(0);
                  }
                  localUnsupportedEncodingException3 = localUnsupportedEncodingException3;
                  localUnsupportedEncodingException3.printStackTrace();
                }
                catch (Exception paramIntent)
                {
                  for (;;)
                  {
                    paramIntent.printStackTrace();
                    i = 55536;
                  }
                }
              }
            }
          }
          localObject4 = localException4.d(i);
          ((com.gau.go.launcherex.gowidget.weather.model.c)localObject4).a(paramIntent.getStringExtra("publish_time"));
          ((com.gau.go.launcherex.gowidget.weather.model.c)localObject4).b(localException1);
          ((com.gau.go.launcherex.gowidget.weather.model.c)localObject4).c(paramIntent.getStringExtra("type"));
          str2 = paramIntent.getStringExtra("description");
        }
        try
        {
          str4 = URLDecoder.decode(str2, "UTF-8");
          str2 = str4;
        }
        catch (UnsupportedEncodingException localException2)
        {
          try
          {
            ((com.gau.go.launcherex.gowidget.weather.model.c)localObject4).b(Integer.parseInt(str2));
          }
          catch (Exception localException2)
          {
            try
            {
              for (;;)
              {
                String str4;
                i = Integer.parseInt(paramIntent.getStringExtra("tz_offset"));
                ((com.gau.go.launcherex.gowidget.weather.model.c)localObject4).a(i);
                str2 = paramIntent.getStringExtra("message");
                try
                {
                  str4 = URLDecoder.decode(str2, "UTF-8");
                  str2 = str4;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException5)
                {
                  for (;;)
                  {
                    localUnsupportedEncodingException5.printStackTrace();
                  }
                }
                ((com.gau.go.launcherex.gowidget.weather.model.c)localObject4).f(str2);
                ((com.gau.go.launcherex.gowidget.weather.model.c)localObject4).b(paramIntent.getBooleanExtra("isNotify", false));
                ((f)localObject2).a(localException4.c(), (com.gau.go.launcherex.gowidget.weather.model.c)localObject4);
                return;
                localUnsupportedEncodingException4 = localUnsupportedEncodingException4;
                localUnsupportedEncodingException4.printStackTrace();
                continue;
                localException2 = localException2;
                localException2.printStackTrace();
                ((com.gau.go.launcherex.gowidget.weather.model.c)localObject4).b(0);
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                localException3.printStackTrace();
                i = j;
              }
            }
          }
        }
        ((com.gau.go.launcherex.gowidget.weather.model.c)localObject4).d(str2);
        ((com.gau.go.launcherex.gowidget.weather.model.c)localObject4).e(paramIntent.getStringExtra("phenomena"));
        String str2 = paramIntent.getStringExtra("level");
        localObject1 = paramIntent.getStringExtra("msg_id");
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      localObject2 = new d();
      ((d)localObject2).a = ("gcm" + (String)localObject1);
      ((d)localObject2).c = 100;
      ((d)localObject2).g = "23:59:59";
      ((d)localObject2).f = "00:00:00";
    } while (r.c(paramIntent.getStringExtra("end_time")));
    Object localObject1 = paramIntent.getStringExtra("title");
    try
    {
      String str5 = URLDecoder.decode((String)localObject1, "UTF-8");
      localObject1 = str5;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException6)
    {
      for (;;)
      {
        localUnsupportedEncodingException6.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((d)localObject2).b = ((String)localObject1);
    }
    localObject1 = paramIntent.getStringExtra("start_time");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((d)localObject2).d = ((String)localObject1);
    }
    localObject1 = paramIntent.getStringExtra("is_message_bar");
    ((d)localObject2).l = 1;
    if ((localObject1 != null) && (((String)localObject1).equals("1"))) {
      ((d)localObject2).l += 2;
    }
    paramIntent = paramIntent.getStringExtra("message");
    try
    {
      localObject1 = URLDecoder.decode(paramIntent, "UTF-8");
      paramIntent = (Intent)localObject1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      for (;;)
      {
        localUnsupportedEncodingException1.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty(paramIntent)) {
      ((d)localObject2).i = paramIntent;
    }
    paramIntent = m.a(localException4);
    localObject1 = new com.gau.go.launcherex.gowidget.messagecenter.a.c();
    ((com.gau.go.launcherex.gowidget.messagecenter.a.c)localObject1).a().add(localObject2);
    paramIntent.a(true, (com.gau.go.launcherex.gowidget.messagecenter.a.c)localObject1);
  }
  
  public final void onHandleIntent(Intent arg1)
  {
    try
    {
      str = ???.getAction();
      if (str.equals("com.google.android.c2dm.intent.REGISTRATION")) {
        a(???);
      }
    }
    finally
    {
      synchronized (b)
      {
        for (;;)
        {
          String str;
          a.release();
          return;
          if (str.equals("com.google.android.c2dm.intent.RECEIVE")) {
            b(???);
          }
        }
        localObject1 = finally;
      }
      synchronized (b)
      {
        a.release();
        throw ((Throwable)localObject1);
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    synchronized (b)
    {
      if (a == null) {
        a = ((PowerManager)getApplicationContext().getSystemService("power")).newWakeLock(1, "my_wakelock");
      }
      a.acquire();
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/gcm/WeatherGCMService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */