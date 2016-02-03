package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.messagecenter.a.d;
import com.gtp.a.a.b.c;
import com.jiubang.core.b.a;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;

public class i
{
  public static int a(Vector paramVector)
  {
    int k = paramVector.size();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      if (((d)paramVector.get(j)).y) {
        break label41;
      }
      i += 1;
    }
    label41:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramLong /= 1000L;
    localStringBuilder.append(paramLong / 3600L).append("小时").append(paramLong % 3600L / 60L).append("分钟").append(paramLong % 60L).append("秒");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    try
    {
      paramString = paramString.replace(" +0800", "");
      str = paramString;
      Date localDate = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(paramString);
      str = paramString;
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localDate);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return str;
  }
  
  public static void a(long paramLong, Context paramContext)
  {
    paramContext = GoWidgetApplication.c(paramContext.getApplicationContext()).a();
    if (paramContext != null) {
      paramContext.edit().putLong("key_last_check_message_update_time", paramLong).commit();
    }
  }
  
  public static void a(Context paramContext)
  {
    b(180000L, paramContext);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = GoWidgetApplication.c(paramContext.getApplicationContext()).a();
    if (paramContext != null)
    {
      paramContext = paramContext.edit();
      paramContext.putInt("key_is_first_request", paramInt);
      paramContext.commit();
    }
  }
  
  public static void a(boolean paramBoolean, Context paramContext)
  {
    paramContext = GoWidgetApplication.c(paramContext.getApplicationContext()).a();
    if (paramContext != null) {
      paramContext.edit().putBoolean("key_is_need_to_check_when_networked", paramBoolean).commit();
    }
  }
  
  public static void b(long paramLong, Context paramContext)
  {
    try
    {
      c.a("MSGCenter", a(paramLong) + "后发送请求消息的广播");
      long l = System.currentTimeMillis();
      PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, new Intent("action_update_message"), 134217728);
      ((AlarmManager)paramContext.getSystemService("alarm")).set(0, l + paramLong, localPendingIntent);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void b(Vector paramVector)
  {
    if (paramVector == null) {
      return;
    }
    Vector localVector1 = new Vector();
    Vector localVector2 = new Vector();
    Collections.sort(paramVector, new j());
    int i = 0;
    if (i < paramVector.size())
    {
      d locald = (d)paramVector.get(i);
      if (locald.y) {
        localVector2.add(locald);
      }
      for (;;)
      {
        i += 1;
        break;
        localVector1.add(locald);
      }
    }
    paramVector.clear();
    paramVector.addAll(localVector1);
    paramVector.addAll(localVector2);
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    paramContext = GoWidgetApplication.c(paramContext.getApplicationContext()).a();
    if (paramContext != null) {
      bool = paramContext.getBoolean("key_is_need_to_check_when_networked", false);
    }
    return bool;
  }
  
  public static long c(Context paramContext)
  {
    long l = 0L;
    paramContext = GoWidgetApplication.c(paramContext.getApplicationContext()).a();
    if (paramContext != null) {
      l = paramContext.getLong("key_last_check_message_update_time", 0L);
    }
    return l;
  }
  
  public static int d(Context paramContext)
  {
    int i = 1;
    paramContext = GoWidgetApplication.c(paramContext.getApplicationContext()).a();
    if (paramContext != null) {
      i = paramContext.getInt("key_is_first_request", 1);
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */